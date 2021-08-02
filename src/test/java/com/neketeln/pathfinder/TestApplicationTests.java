package com.neketeln.pathfinder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {

	private static final double R = 6372800D;

	@Test
	void contextLoads() {
	}

	@Test
	public void foo() {
		System.out.println(haversine(36.12, -86.67, 33.94, -118.40));
		System.out.println(haversine(50.7297521, 16.3091078, 50.7296135, 16.3088812));

		System.out.println(haversine(50.780766, 16.224141, 50.780536, 16.21786));
		System.out.println(Math.sqrt(Math.pow(130, 2) + Math.pow(haversine(50.780766, 16.224141, 50.780536, 16.21786), 2)));


		double ele = 200;
		double length = haversine(50.727613, 16.30436, 50.722907, 16.304505);
		double realLength = Math.sqrt(Math.pow(ele, 2) + Math.pow(length, 2));
		double angle = angle(length, ele);
		double slope = slope(length, ele);

		System.out.println();
		System.out.println(ele);
		System.out.println(length);
		System.out.println(realLength);
		System.out.println(angle);
		System.out.println(slope);
	}

	private double haversine(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}

	private double angle(double length, double ele) {
		return Math.toDegrees(Math.atan(ele / length));
	}

	private double slope(double length, double ele) {
		return 100 * Math.tan(ele / length);
	}

}
