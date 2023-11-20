package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookingPage extends BaseClass {
	public AdactinBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement ddnLocation;
	@FindBy(id = "hotels")
	private WebElement ddnHotels;
	@FindBy(id = "room_type")
	private WebElement ddnRoomType;
	@FindBy(id = "room_nos")
	private WebElement ddnNoofRooms;
	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement ddnAdult;
	@FindBy(id = "child_room")
	private WebElement ddnChild;
	@FindBy(id = "Submit")
	private WebElement btnSearch;

	public WebElement getDdnLocation() {
		return ddnLocation;
	}

	public WebElement getDdnHotels() {
		return ddnHotels;
	}

	public WebElement getDdnRoomType() {
		return ddnRoomType;
	}

	public WebElement getDdnNoofRooms() {
		return ddnNoofRooms;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getDdnAdult() {
		return ddnAdult;
	}

	public WebElement getDdnChild() {
		return ddnChild;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	public void booking(String dateIn, String dateOut) {
		elementClick(getDdnLocation());
		selectOptionByIndex(getDdnLocation(), 3);
		elementClick(getDdnHotels());
		selectOptionByIndex(getDdnHotels(), 3);
		elementClick(getDdnRoomType());
		selectOptionByIndex(getDdnRoomType(), 3);
		elementClick(getDdnNoofRooms());
		selectOptionByIndex(getDdnNoofRooms(), 3);
		elementClick(getTxtCheckInDate());
		elementSendkeys(getTxtCheckInDate(), dateIn);
		elementClick(getTxtCheckOutDate());
		elementSendkeys(getTxtCheckOutDate(), dateOut);
		elementClick(getDdnAdult());
		selectOptionByIndex(getDdnAdult(), 2);
		elementClick(getDdnChild());
		selectOptionByIndex(getDdnChild(), 2);
		elementClick(btnSearch);

	}

}
