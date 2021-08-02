package com.neketeln.pathfinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

  @JacksonXmlProperty(localName = "name")
  private String name;

  @JacksonXmlProperty(localName = "trkseg")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<TrackSegment> trackSegments;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<TrackSegment> getTrackSegments() {
    return trackSegments;
  }

  public void setTrackSegments(List<TrackSegment> trackSegments) {
    this.trackSegments = trackSegments;
  }
}
