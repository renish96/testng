package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinBookingConfirmPage extends BaseClass {

	public AdactinBookingConfirmPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "address")
	private WebElement txtAddress;
	@FindBy(id = "cc_num")
	private WebElement txtCardNo;
	@FindBy(id = "cc_type")
	private WebElement ddnCardType;
	@FindBy(id = "cc_exp_month")
	private WebElement ddnMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement ddnYear;
	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNo;
	@FindBy(id = "book_now")
	private WebElement btnBook;
	@FindBy(id = "order_no")
	private WebElement txtOrderNo;

	public WebElement getTxtOrderNo() {
		return txtOrderNo;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCardNo() {
		return txtCardNo;
	}

	public WebElement getDdnCardType() {
		return ddnCardType;
	}

	public WebElement getDdnMonth() {
		return ddnMonth;
	}

	public WebElement getDdnYear() {
		return ddnYear;
	}

	public WebElement getTxtCvvNo() {
		return txtCvvNo;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}

	public void confirmBook(String firstName, String lastName, String address, String cardNo, String cvvNo)
			throws InterruptedException {
		elementClick(getTxtFirstName());
		elementSendkeys(getTxtFirstName(), firstName);
		elementClick(getTxtLastName());
		elementSendkeys(getTxtLastName(), lastName);
		elementClick(getTxtAddress());
		elementSendkeys(getTxtAddress(), address);
		elementClick(getTxtCardNo());
		elementSendkeys(getTxtCardNo(), cardNo);
		elementClick(getDdnCardType());
		selectOptionByIndex(getDdnCardType(), 2);
		elementClick(getDdnMonth());
		selectOptionByIndex(getDdnMonth(), 9);
		elementClick(getDdnYear());
		selectOptionByIndex(getDdnYear(), 16);
		elementClick(getTxtCvvNo());
		elementSendkeys(getTxtCvvNo(), cvvNo);
		elementClick(getBtnBook());
		Thread.sleep(3000);
		elementGetText(getTxtOrderNo());

	}

}
