package com.mycompany.jet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.jet.model.JetFlightRequest;
import com.mycompany.jet.model.JetFlightResponse;

@Repository
public interface JetFlightRepository extends JpaRepository<JetFlightResponse, Long> {

  @Query("select jf from JetFlightResponse jf where jf.departureAirportName = :#{#jetFlightRequest.from} and jf.arrivalAirportName=:#{#jetFlightRequest.to} and jf.outboundDateTime like :#{#jetFlightRequest.outboundDateTime}")
  List<JetFlightResponse> findByRequest(@Param("jetFlightRequest") final JetFlightRequest jetFlightRequest);

}
