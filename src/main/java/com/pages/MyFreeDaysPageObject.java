package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class MyFreeDaysPageObject extends PageObject {

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_TabsBack']")
	private WebElementFacade backButton;

	public void myFreeDays() {
		backButton.click();
	}
}
