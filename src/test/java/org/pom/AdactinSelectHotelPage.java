package org.pom;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinSelectHotelPage extends BaseClass {
	public AdactinSelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "radiobutton_0")
	private WebElement btnSelect;
	@FindBy(id = "continue")
	private WebElement btnContinue;

	public WebElement getBtnSelect() {
		return btnSelect;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void confirm() {
		elementClick(getBtnSelect());
		elementClick(getBtnContinue());
	}
}
