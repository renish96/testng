package com.booking;

import org.base.BaseClass;
import org.pom.AdactinBookingConfirmPage;
import org.pom.AdactinBookingPage;
import org.pom.AdactinLogin;
import org.pom.AdactinSelectHotelPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AdactinBooking extends BaseClass {
	@BeforeSuite
	private void browserLaunch() {
		chromeBrowserLaunch();
		enterUrl("https://adactinhotelapp.com/index.php");
		maximizeWindow();
		implicitlyWait(30);
	}

	@Test
	private void hotelBooking() throws InterruptedException {
		AdactinLogin adactinLogin = new AdactinLogin();
		adactinLogin.login("renish0108", "Renish@1996");
		AdactinBookingPage adactinBookingPage = new AdactinBookingPage();
		adactinBookingPage.booking("26/06/2023", "27/06/2023");
		AdactinSelectHotelPage adactinSelectHotelPage = new AdactinSelectHotelPage();
		adactinSelectHotelPage.confirm();
		AdactinBookingConfirmPage adactinBookingConfirmPage = new AdactinBookingConfirmPage();
		adactinBookingConfirmPage.confirmBook("Arockia", "Renish", "20,new Building,Thoraipakkam,Chennai",
				"1234567890987654", "246");
	}

	@AfterSuite
	private void browserClose() {
		quitWindow();
	}

}
