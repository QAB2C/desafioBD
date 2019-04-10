package com.applause.auto.pageframework.testdata;

import java.time.LocalDate;

public class TestConstants {

	/**
	 * Test Groups
	 */
	public static final class TestNGGroups {

		public static final String DEBUG = "debug";
		public static final String LOGIN = "login";
		public static final String HOTEL_SEARCH_KR = "skyscanner";
	}

	/**
	 * Test Data for tests
	 */

	public static final class TestData {

		public static final String HOTELLIST_URL_K = "https://www.e-tsw.com/hoteles/busqueda?af=af-tvic";

		public static final String RANDOMPAGE = "https://edition.cnn.com/videos";

		public static final String DESTINATION = "Veracruz";

		public static final LocalDate STARTDATE = LocalDate.of(2019, 7, 25);

		public static final LocalDate ENDDATE = LocalDate.of(2019, 7, 27);

		public static final int ADULTS = 3;

	}
}