package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class SideMenuPageObject extends PageObject {
	
	@FindBy(xpath="//a[contains(@href, 'new-request')]")
	private WebElementFacade newVacationRequestLink;
	
	public void goToNewVacationRequest(){
		newVacationRequestLink.click();
	}

}
