package com.mycompany.jet.service;

import java.io.Serializable;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.jet.model.JetFlightRequest;
import com.mycompany.jet.model.JetFlightResponse;
import com.mycompany.jet.repository.JetFlightRepository;

/**
 * 
 * This class is used to implement all crude operations.
 *
 */
@Service
public class JetFlightServiceImpl implements JetFlightService {

  private final JetFlightRepository jetFlightRepository;

  @Autowired
  public JetFlightServiceImpl(final JetFlightRepository jetFlightRepository) {
    this.jetFlightRepository = jetFlightRepository;
  }

  @Override
  public JetFlightResponse saveFlight(final JetFlightResponse entity) {
    return jetFlightRepository.save(entity);
  }

  @Override
  public List<JetFlightResponse> getAllAirFlights() {
    return jetFlightRepository.findAll();
  }

  @Override
  public void deleteFlight(Serializable id) {
    jetFlightRepository.delete((Long) id);
  }

  @Override
  public List<JetFlightResponse> getFlightByRequest(final JetFlightRequest entity) {
    return jetFlightRepository.findByRequest(entity);
  }

  /**
   * Add some flights at application startup for testing
   */
  @PostConstruct
  public void loadFlights() {
    List<JetFlightResponse> users = Arrays.asList(
                    new JetFlightResponse("Virgin Airlines", 700.52, 250.00, 5.00, "LHR", "CDG",
                                    Instant.now(Clock.systemUTC()).plus(Duration.ofDays(5)),
                                    Instant.now().plus(Duration.ofDays(6))),
                    new JetFlightResponse("American Airlines", 700.52, 150.00, 7.5, "LHR", "CDG",
                                    Instant.now(Clock.systemUTC()).plus(Duration.ofDays(3)),
                                    Instant.now().plus(Duration.ofDays(4))));
    jetFlightRepository.save(users);
  }

}
