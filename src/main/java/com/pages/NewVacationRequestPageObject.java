package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVacationRequestPageObject extends PageObject {

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
	private WebElementFacade vacationWithoutPaymentRadioButton;

	public void selectVacationWithoutPayment() {
		vacationWithoutPaymentRadioButton.click();
	}

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade specialVacationRadioButton;

	public void selectspecialVacation() {
		specialVacationRadioButton.click();
	}

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_specialReason']")
	private WebElementFacade specialVacationDropDown;

	public void droDownAndSelectItem(String item) {
		specialVacationDropDown.selectByVisibleText(item);
	}
}
