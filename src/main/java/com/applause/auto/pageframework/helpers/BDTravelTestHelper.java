package com.applause.auto.pageframework.helpers;

public class BDTravelTestHelper {

	public static String getDataUser(String[] data) {

		return data[(int) (Math.floor(Math.random() * data.length))];
	}
}
