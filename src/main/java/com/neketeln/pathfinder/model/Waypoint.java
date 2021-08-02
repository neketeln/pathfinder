package com.neketeln.pathfinder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint {

  @JacksonXmlProperty(localName = "name")
  private String name;

  @JacksonXmlProperty(localName = "ele")
  private double elevation;

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

  @Override
  public String toString() {
    return "Waypoint{" + "name='" + name + '\'' + ", elevation=" + elevation + ", latitude=" + latitude + ", longitude=" + longitude + '}';
  }
}
