package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class SideMenuPageObject extends PageObject {
	
	@FindBy(xpath="//a[contains(@href, 'new-request')]")
	private WebElementFacade newVacationRequestLink;
	
	@FindBy(xpath="//a[contains(@href,'vacation-tracker')]")
	private WebElementFacade vacationTracker;
	
	public void goToNewVacationRequest(){
		newVacationRequestLink.click();
	}
	
	public void goToVacationTracker() {
		vacationTracker.click();		
	}	
}
