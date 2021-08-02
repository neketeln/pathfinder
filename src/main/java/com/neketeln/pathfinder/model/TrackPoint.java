package com.neketeln.pathfinder.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackPoint {

  @JacksonXmlProperty(localName = "name")
  private String name;

  @JacksonXmlProperty(localName = "ele")
  private double elevation;

  @JacksonXmlProperty(localName = "time")
  private Date time;

  @JacksonXmlProperty(localName = "lat", isAttribute = true)
  private double latitude;

  @JacksonXmlProperty(localName = "lon", isAttribute = true)
  private double longitude;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getElevation() {
    return elevation;
  }

  public void setElevation(double elevation) {
    this.elevation = elevation;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
