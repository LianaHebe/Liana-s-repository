package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class MyRequestsPage extends PageObject{
	

	public void clickCheckBoxVacationType(String vacationType){
		WebElement element = getDriver().findElement(By.cssSelector(vacationType));
		element.click();
	}

	public void clickCheckBoxDaysNumber(String daysNumber){
		WebElement element2 = getDriver().findElement(By.cssSelector(daysNumber));
		element2.click();
	}
	
	public void clickCheckBoxVacationStatus(String vacationStatus){
		WebElement element3 = getDriver().findElement(By.cssSelector(vacationStatus));
		element3.click();
	}
	
	@FindBy(css="[id='_evovacation_WAR_EvoVacationportlet_applyButton']")
    private WebElementFacade applyButton;
	
	public void clickApplyButton(){
		applyButton.click();
	}
}
