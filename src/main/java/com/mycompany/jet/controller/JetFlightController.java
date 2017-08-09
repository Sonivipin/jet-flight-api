package com.mycompany.jet.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.jet.model.JetFlightRequest;
import com.mycompany.jet.model.JetFlightResponse;
import com.mycompany.jet.service.JetFlightService;

@RestController
@RequestMapping("/jetflight")
public class JetFlightController {

  final static Logger LOGGER = Logger.getLogger(JetFlightController.class);

  private final JetFlightService airFlightService;

  @Autowired
  public JetFlightController(final JetFlightService airFlightService) {
    this.airFlightService = airFlightService;
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<JetFlightResponse> addFlight(@RequestBody final JetFlightResponse airFlightResponse) {
    airFlightService.saveFlight(airFlightResponse);
    LOGGER.debug("Added: " + airFlightResponse);

    return new ResponseEntity<JetFlightResponse>(airFlightResponse, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/searchCriteria", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<JetFlightResponse>> getFlightByRequest(
                  @RequestBody final JetFlightRequest airFlightRequest) {

    List<JetFlightResponse> airFlightResponses = airFlightService.getFlightByRequest(airFlightRequest);
    if (airFlightResponses.isEmpty()) {
      LOGGER.debug("AirFlightResponse does not exists");
      return new ResponseEntity<List<JetFlightResponse>>(HttpStatus.NO_CONTENT);
    } else {
      LOGGER.debug("Found " + airFlightResponses.size() + " Flights");
      LOGGER.debug(airFlightResponses);
      LOGGER.debug(Arrays.toString(airFlightResponses.toArray()));
    }

    return new ResponseEntity<List<JetFlightResponse>>(airFlightResponses, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<JetFlightResponse>> getAllFlights() {

    List<JetFlightResponse> airFlightResponses = airFlightService.getAllAirFlights();
    if (airFlightResponses.isEmpty()) {
      LOGGER.debug("AirFlightResponse does not exists");
      return new ResponseEntity<List<JetFlightResponse>>(HttpStatus.NO_CONTENT);
    } else {
      LOGGER.debug("Found " + airFlightResponses.size() + " Flights");
      LOGGER.debug(airFlightResponses);
      LOGGER.debug(Arrays.toString(airFlightResponses.toArray()));
    }

    return new ResponseEntity<List<JetFlightResponse>>(airFlightResponses, HttpStatus.OK);
  }

}
