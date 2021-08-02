package com.neketeln.pathfinder.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GPX {

  @JacksonXmlProperty(localName = "metadata")
  private Metadata metadata;

  @JacksonXmlProperty(localName = "wpt")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Waypoint> waypoints;

  @JacksonXmlProperty(localName = "trk")
  private Track track;

  public Metadata getMetadata() {
    return metadata;
  }

  public void setMetadata(Metadata metadata) {
    this.metadata = metadata;
  }

  public List<Waypoint> getWaypoints() {
    return waypoints;
  }

  public void setWaypoints(List<Waypoint> waypoints) {
    this.waypoints = waypoints;
  }

  public Track getTrack() {
    return track;
  }

  public void setTrack(Track track) {
    this.track = track;
  }
}
