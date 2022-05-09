package com.abhisheksah.controller;

import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Checksum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.abhisheksah.model.PaytmDetails;
import com.paytm.pg.merchant.PaytmChecksum;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class PaymentController {

	@Autowired
	private PaytmDetails paytmDetails;
	
	@Autowired
	private Environment env;
	
//	@RequestMapping(value="/index",method=RequestMethod.GET)
//	public String dashboard(Model model)
//	{
//		return "<h1>this is heading</h1>";
//	}
	
	@GetMapping(value="/")
	public String home() {
		return "home";
	}
	
	 @PostMapping(value = "/pgredirect")
	    public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
	                                    @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
	                                    @RequestParam(name = "ORDER_ID") String orderId) throws Exception {

	        ModelAndView modelAndView = new ModelAndView("redirect:" + paytmDetails.getPaytmUrl());
	        TreeMap<String, String> parameters = new TreeMap<>();
	        paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
	        parameters.put("ORDER_ID", orderId);
	        parameters.put("TXN_AMOUNT", transactionAmount);
	        parameters.put("CUST_ID", customerId);
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        return modelAndView;
	    }

	private String getCheckSum(TreeMap<String, String> parameters) throws Exception{
		// TODO Auto-generated method stub
		return PaytmChecksum.generateSignature(parameters, paytmDetails.getMerchantKey());
		//PaytmChecksum.verifySignature(parameters,paytmDetails.getMerchantKey(),paytmDetails);
	}

	  
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "report";
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return PaytmChecksum.verifySignature(parameters,paytmDetails.getMerchantKey(),paytmChecksum);   
	        }
	
}
