package com.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVacationRequestPageObject extends PageObject {
	
	//@FindBy(xpath="//input[contains(@type, 'radio') and position()=2]")
	@FindBy(css="[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
    private WebElementFacade vacationWithoutPaymentRadioButton;
	
	public void selectVacationWithoutPayment(){
		vacationWithoutPaymentRadioButton.click();
	}

}
