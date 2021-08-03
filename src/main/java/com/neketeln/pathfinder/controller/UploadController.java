package com.neketeln.pathfinder.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.neketeln.pathfinder.model.GPX;
import com.neketeln.pathfinder.model.TrackPoint;
import com.neketeln.pathfinder.service.PathService;

@Controller
public class UploadController {

  @Autowired
  private PathService pathService;

  @GetMapping("/upload")
  public String upload(Model model) {
    return "uploadForm";
  }

  @PostMapping("/upload")
  public String upload(@RequestParam("file") MultipartFile file, Model model, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

    try {
      GPX gpx = new XmlMapper().readValue(file.getBytes(), GPX.class);

      List<List<Double>> trackData = new ArrayList<>();
      double distance = 0;
      Date startTime = gpx.getTrack().getTrackSegments().get(0).getTrackPoints().get(0).getTime();
      trackData.add(List.of(0D, gpx.getTrack().getTrackSegments().get(0).getTrackPoints().get(0).getElevation(), 0D, 0D, 0D));
      for (int i = 1; i < gpx.getTrack().getTrackSegments().get(0).getTrackPoints().size(); i++) {
        TrackPoint current = gpx.getTrack().getTrackSegments().get(0).getTrackPoints().get(i);
        TrackPoint previous = gpx.getTrack().getTrackSegments().get(0).getTrackPoints().get(i - 1);

        double flatLength = pathService.haversine(current.getLatitude(), current.getLongitude(), previous.getLatitude(), previous.getLongitude());
        double realLength = pathService.length(flatLength, current.getElevation() - previous.getElevation());
        double angle = pathService.angle(flatLength, current.getElevation() - previous.getElevation());
        long timeDifference = TimeUnit.SECONDS.convert(Math.abs(current.getTime().getTime() - previous.getTime().getTime()), TimeUnit.MILLISECONDS);
        double speed = pathService.speed(realLength, timeDifference);
        long elapsedTime = TimeUnit.SECONDS.convert(Math.abs(current.getTime().getTime() - startTime.getTime()), TimeUnit.MILLISECONDS);

        distance += realLength;
        trackData.add(List.of(distance, current.getElevation(), angle, speed, (double) elapsedTime));
      }
      model.addAttribute("trackData", trackData);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return "trackChart";
  }

}
