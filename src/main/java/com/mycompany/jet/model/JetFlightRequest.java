package com.mycompany.jet.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("serial")
public class JetFlightRequest implements Serializable {

  private String from; // 3 letter IATA code(eg. LHR, AMS)

  private String to; // 3 letter IATA code(eg. LHR, AMS)

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate outboundDate; // ISO_LOCAL_DATE format

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDate inboundDate; // ISO_LOCAL_DATE format

  private Integer numberOfAdults; // Number of passengers

  public JetFlightRequest() {
  }

  /**
   * @param from
   * @param to
   * @param outboundDate
   * @param inboundDate
   * @param numberOfAdults
   */
  public JetFlightRequest(final String from, final String to, final LocalDate outboundDate, final LocalDate inboundDate,
                  final Integer numberOfAdults) {
    this.from = from;
    this.to = to;
    this.outboundDate = outboundDate;
    this.inboundDate = inboundDate;
    this.numberOfAdults = numberOfAdults;
  }

  /**
   * @return the from
   */
  public String getFrom() {
    return from;
  }

  /**
   * @param from
   *          the from to set
   */
  public void setFrom(String from) {
    this.from = from;
  }

  /**
   * @return the to
   */
  public String getTo() {
    return to;
  }

  /**
   * @param to
   *          the to to set
   */
  public void setTo(String to) {
    this.to = to;
  }

  /**
   * @return the outboundDate
   */
  public LocalDate getOutboundDate() {
    return outboundDate;
  }

  /**
   * @param outboundDate
   *          the outboundDate to set
   */
  public void setOutboundDate(LocalDate outboundDate) {
    this.outboundDate = outboundDate;
  }

  /**
   * @return the inboundDate
   */
  public LocalDate getInboundDate() {
    return inboundDate;
  }

  /**
   * @param inboundDate
   *          the inboundDate to set
   */
  public void setInboundDate(LocalDate inboundDate) {
    this.inboundDate = inboundDate;
  }

  /**
   * @return the numberOfAdults
   */
  public Integer getNumberOfAdults() {
    return numberOfAdults;
  }

  /**
   * @param numberOfAdults
   *          the numberOfAdults to set
   */
  public void setNumberOfAdults(Integer numberOfAdults) {
    this.numberOfAdults = numberOfAdults;
  }

  public Instant getOutboundDateTime() {
    return Instant.parse(getOutboundDate().toString());
  }

}
