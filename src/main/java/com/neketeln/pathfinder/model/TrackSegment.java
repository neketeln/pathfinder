package com.neketeln.pathfinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackSegment {

  @JacksonXmlProperty(localName = "trkpt")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<TrackPoint> trackPoints;

  public List<TrackPoint> getTrackPoints() {
    return trackPoints;
  }

  public void setTrackPoints(List<TrackPoint> trackPoints) {
    this.trackPoints = trackPoints;
  }
}
