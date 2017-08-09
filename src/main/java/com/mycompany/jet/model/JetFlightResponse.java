package com.mycompany.jet.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@SuppressWarnings("serial")
@Entity
@Table(name = "jetFlightResponse")
public class JetFlightResponse implements Serializable {

  @Id
  @Column(name = "carrier", nullable = false, length = 25)
  private String carrier;// Name of the airline

  @Column(name = "basePrice", nullable = false, length = 10)
  private Double basePrice; // Price without tax(doesn't include discount)

  @Column(name = "tax", nullable = false, length = 10)
  private Double tax; // Tax which needs to be charged along with the price

  @Column(name = "discount", nullable = false, length = 10)
  private Double discount;// Discount which needs to be applied on the price(in percentage)

  @Column(name = "departureAirportName", nullable = false, length = 3)
  private String departureAirportName;// 3 letter IATA code(eg. LHR, AMS)

  @Column(name = "arrivalAirportName", nullable = false, length = 3)
  private String arrivalAirportName;// 3 letter IATA code(eg. LHR, AMS)

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column(name = "outboundDateTime", nullable = false)
  private Instant outboundDateTime;// ISO_LOCAL_DATE_TIME format

  @JsonSerialize(using = LocalDateTimeSerializer.class)
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @Column(name = "inboundDateTime", nullable = false)
  private Instant inboundDateTime;// ISO_INSTANT format

  /**
   * Default constructor for entity bean creation.
   */
  public JetFlightResponse() {
  }

  /**
   * @param carrier
   * @param basePrice
   * @param tax
   * @param discount
   * @param departureAirportName
   * @param arrivalAirportName
   * @param outboundDateTime
   * @param inboundDateTime
   */
  public JetFlightResponse(String carrier, Double basePrice, Double tax, Double discount, String departureAirportName,
                  String arrivalAirportName, Instant outboundDateTime, Instant inboundDateTime) {
    this.carrier = carrier;
    this.basePrice = basePrice;
    this.tax = tax;
    this.discount = discount;
    this.departureAirportName = departureAirportName;
    this.arrivalAirportName = arrivalAirportName;
    this.outboundDateTime = outboundDateTime;
    this.inboundDateTime = inboundDateTime;
  }

  /**
   * @return the carrier
   */
  public String getCarrier() {
    return carrier;
  }

  /**
   * @param carrier
   *          the carrier to set
   */
  public void setCarrier(String carrier) {
    this.carrier = carrier;
  }

  /**
   * @return the basePrice
   */
  public Double getBasePrice() {
    return basePrice;
  }

  /**
   * @param basePrice
   *          the basePrice to set
   */
  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  /**
   * @return the tax
   */
  public Double getTax() {
    return tax;
  }

  /**
   * @param tax
   *          the tax to set
   */
  public void setTax(Double tax) {
    this.tax = tax;
  }

  /**
   * @return the discount
   */
  public Double getDiscount() {
    return discount;
  }

  /**
   * @param discount
   *          the discount to set
   */
  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  /**
   * @return the departureAirportName
   */
  public String getDepartureAirportName() {
    return departureAirportName;
  }

  /**
   * @param departureAirportName
   *          the departureAirportName to set
   */
  public void setDepartureAirportName(String departureAirportName) {
    this.departureAirportName = departureAirportName;
  }

  /**
   * @return the arrivalAirportName
   */
  public String getArrivalAirportName() {
    return arrivalAirportName;
  }

  /**
   * @param arrivalAirportName
   *          the arrivalAirportName to set
   */
  public void setArrivalAirportName(String arrivalAirportName) {
    this.arrivalAirportName = arrivalAirportName;
  }

  /**
   * @return the outboundDateTime
   */
  public Instant getOutboundDateTime() {
    return outboundDateTime;
  }

  /**
   * @param outboundDateTime
   *          the outboundDateTime to set
   */
  public void setOutboundDateTime(Instant outboundDateTime) {
    this.outboundDateTime = outboundDateTime;
  }

  /**
   * @return the inboundDateTime
   */
  public Instant getInboundDateTime() {
    return inboundDateTime;
  }

  /**
   * @param inboundDateTime
   *          the inboundDateTime to set
   */
  public void setInboundDateTime(Instant inboundDateTime) {
    this.inboundDateTime = inboundDateTime;
  }

  public Double getTotalPrice() {

    return 0.0;
  }
}
