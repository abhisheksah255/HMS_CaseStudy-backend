package com.abhisheksah;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

	@Bean
	public RouteLocator locatorRoom(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/HMS/room/allroom")
						.uri("http://localhost:8084")
						)
						
						.route(p->p
								.path("/HMS/room/addroom")
								.uri("http://localhost:8084")
								)
						.route(p->p
								.path("/HMS/room/get/{roomId}")
								.uri("http://localhost:8084")
								)
						.route(p->p
								.path("/HMS/room/update/{roomId}")
								.uri("http://localhost:8084")
								)
						.route(p->p
								.path("/HMS/room/delete/{roomId}")
								.uri("http://localhost:8084")
								)
						.route(p->p
								.path("/HMS/room/search/{boolean}")
								.uri("http://localhost:8084")
								)
						.build();
	
	}

	@Bean
	public RouteLocator locatorGuest(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/HMS/guest/allguest")
						.uri("http://localhost:8081")
						)
						
						.route(p->p
								.path("/HMS/guest/addguest")
								.uri("http://localhost:8081")
								)
						.route(p->p
								.path("/HMS/guest/get/{id}")
								.uri("http://localhost:8081")
								)
						.route(p->p
								.path("/HMS/guest/update/{id}")
								.uri("http://localhost:8081")
								)
						.route(p->p
								.path("/HMS/guest/delete/{id}")
								.uri("http://localhost:8081")
								)
						.build();
	
	}
	
	@Bean
	public RouteLocator locatorReservation(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/HMS/reservation/allreservation")
						.uri("http://localhost:8082")
						)
						
						.route(p->p
								.path("/HMS/reservation/addreservation")
								.uri("http://localhost:8082")
								)
						.route(p->p
								.path("/HMS/reservation/get/{code}")
								.uri("http://localhost:8082")
								)
						.route(p->p
								.path("/HMS/reservation/update/{code}")
								.uri("http://localhost:8082")
								)
						.route(p->p
								.path("/HMS/reservation/delete/{code}")
								.uri("http://localhost:8082")
								)
						.build();
	
	}

	@Bean
	public RouteLocator locatorStaff(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/HMS/staff/allstaff")
						.uri("http://localhost:8083")
						)
						
						.route(p->p
								.path("/HMS/staff/addstaff")
								.uri("http://localhost:8083")
								)
						.route(p->p
								.path("/HMS/staff/get/{id}")
								.uri("http://localhost:8083")
								)
						.route(p->p
								.path("/HMS/staff/update/{id}")
								.uri("http://localhost:8083")
								)
						.route(p->p
								.path("/HMS/staff/delete/{id}")
								.uri("http://localhost:8083")
								)
						.build();
	
	}

	

}
