package com.AI_Travel_Companion.bookingservice.Clients;


import com.AI_Travel_Companion.bookingservice.DTO.FlightResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FLIGHTSERVICE")
public interface FlightOpenFeignClient {

    @GetMapping("/flights/{id}")
    FlightResponse flightById(@PathVariable Long id);
}
