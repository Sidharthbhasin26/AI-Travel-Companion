package com.AI_Travel_Companion.flightservice.Controller;


import com.AI_Travel_Companion.flightservice.DTO.FlightRequest;
import com.AI_Travel_Companion.flightservice.DTO.FlightResponse;
import com.AI_Travel_Companion.flightservice.Service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/search")
    public ResponseEntity<List<FlightResponse>> getFlights(@RequestParam String departureAirport , @RequestParam String arrivalAirport){
      List<FlightResponse> saved = flightService.getFlights(departureAirport , arrivalAirport);
      return new ResponseEntity<>(saved , HttpStatus.OK);
    }

    @PostMapping("/addFlights")
    public ResponseEntity<FlightResponse> addFlights(@RequestBody FlightRequest flightRequest){
        FlightResponse saved = flightService.addFlights(flightRequest);
        return new ResponseEntity<>(saved , HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> flightById(@PathVariable Long id){
        FlightResponse saved = flightService.flightById(id);
        return new ResponseEntity<>(saved , HttpStatus.OK);

    }

}
