package com.pages;

import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class SideMenuPageObject extends PageObject {

	@FindBy(xpath = "//a[contains(@href, 'new-request')]")
	private WebElementFacade newVacationRequestLink;
	@FindBy(xpath = "//a[contains(@href,'vacation-tracker')]")
	private WebElementFacade vacationTracker;
	@FindBy(xpath = "//a[contains(text(),'My Requests')]")
	private WebElementFacade myRequests;
	@FindBy(css = "a[href*='my-free-days']")
	private WebElementFacade myFreeDays;
	@FindBy(css = "a[href*='free-days-history']")
	private WebElement freeDaysHistory;

	public void goToNewVacationRequest() {
		newVacationRequestLink.click();
	}

	public void goToVacationTracker() {
		vacationTracker.click();
	}

	public void goToMyRequests() {
		myRequests.click();
	}

	public void goToMyFreeDays() {
		myFreeDays.click();
	}

	public void goToFreeDaysHistory() {
		freeDaysHistory.click();
	}

}
