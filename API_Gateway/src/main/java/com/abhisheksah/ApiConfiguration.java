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
								.path("/HMS/reservation/get/{reservationId}")
								.uri("http://localhost:8082")
								)
						.route(p->p
								.path("/HMS/reservation/update/{reservationId}")
								.uri("http://localhost:8082")
								)
						.route(p->p
								.path("/HMS/reservation/delete/{reservationId}")
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

	@Bean
	public RouteLocator locatorInventory(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/HMS/inventory/allinventory")
						.uri("http://localhost:8085")
						)
						
						.route(p->p
								.path("/HMS/inventory/addinventory")
								.uri("http://localhost:8085")
								)
						.route(p->p
								.path("/HMS/inventory/get/{inventoryid}")
								.uri("http://localhost:8085")
								)
						.route(p->p
								.path("/HMS/inventory/update/{inventoryid}")
								.uri("http://localhost:8085")
								)
						.route(p->p
								.path("/HMS/inventory/delete/{inventoryid}")
								.uri("http://localhost:8085")
								)
						.build();
	
	}

	
	@Bean
	public RouteLocator locatorDepartment(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route(p->p
						.path("/HMS/department/alldepartment")
						.uri("http://localhost:8086")
						)
						
						.route(p->p
								.path("/HMS/department/adddepartment")
								.uri("http://localhost:8086")
								)
						.route(p->p
								.path("/HMS/department/get/{id}")
								.uri("http://localhost:8086")
								)
						.route(p->p
								.path("/HMS/department/update/{id}")
								.uri("http://localhost:8086")
								)
						.route(p->p
								.path("/HMS/department/delete/{id}")
								.uri("http://localhost:8086")
								)
						.build();
	
	}

}
