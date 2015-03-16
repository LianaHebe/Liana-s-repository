package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class VacationReqDetailsPageObject extends PageObject {

	@FindBy (css="[id='_evovacation_WAR_EvoVacationportlet_withdrawnVacationRequest']")
	private WebElementFacade withdrawButton;
	
	public void clickWithdrawButton(){
		withdrawButton.click();
	}
}

