package com.mycompany.jet.service;

import java.io.Serializable;
import java.util.List;

import com.mycompany.jet.model.JetFlightRequest;

public interface CRUDServices<E> {

  E saveFlight(final E entity);

  List<E> getAllAirFlights();

  void deleteFlight(final Serializable id);

  List<E> getFlightByRequest(final JetFlightRequest entity);
}
