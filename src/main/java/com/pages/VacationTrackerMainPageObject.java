package com.pages;

import java.text.ParseException;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class VacationTrackerMainPageObject extends PageObject {
	private WebDriver webdriver;

	@FindBy(xpath = "//input[contains(@id, 'trackerStartDate')]")
	private WebElementFacade startDateField;
	@FindBy(xpath = "//input[contains(@id, 'trackerEndDate')]")
	private WebElementFacade endDateField;

	public void setStartDate(int day, int month, int year) {
		webdriver = getDriver();
		startDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		try {
			datePopup.setDate(day, month, year);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
