package com.abhisheksah.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.abhisheksah.services.CustomUserDetailService;
import com.abhisheksah.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter{

	
	   @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private CustomUserDetailService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
			throws ServletException, IOException {
	
		String authorizationHeader = httpServletRequest.getHeader("Authorization");
//Bearer - eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBYmhpc2hlayIsImV4cCI6MTY1MDkyNTgxOCwiaWF0IjoxNjUwODg5ODE4fQ.BbjdsEKcryseOTv-vM8BGq-rptSf-A5vAxzhQmVhtG8
		String token = null;
        String username = null;
		
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring(7);
			username = jwtUtil.extractUsername(token);	
		}
		
	
	 if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

         
		UserDetails userDetails = service.loadUserByUsername(username);

        
		if (jwtUtil.validateToken(token, userDetails)) {

             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
             usernamePasswordAuthenticationToken
                     .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
             SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
         }
     }
     filterChain.doFilter(httpServletRequest, httpServletResponse);
 }

}
