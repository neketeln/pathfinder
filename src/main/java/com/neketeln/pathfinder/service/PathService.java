package com.neketeln.pathfinder.service;

import org.springframework.stereotype.Service;

@Service
public class PathService {

  private static final double R = 6372800D;

  public double haversine(double lat1, double lon1, double lat2, double lon2) {
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);
    lat1 = Math.toRadians(lat1);
    lat2 = Math.toRadians(lat2);

    double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
    double c = 2 * Math.asin(Math.sqrt(a));
    return R * c;
  }

  public double length(double flatLength, double elevation) {
    return Math.sqrt(Math.pow(flatLength, 2) + Math.pow(elevation, 2));
  }

  public double angle(double length, double ele) {
    return Math.toDegrees(Math.atan(ele / length));
  }

  public double speed(double length, long time) {
    return length / time;
  }

  public double slope(double length, double ele) {
    return 100 * Math.tan(ele / length);
  }
}
