package com.steps;

import java.text.ParseException;

import com.pages.NewVacationRequestPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;


public class NewVacationRequestSteps extends ScenarioSteps{
	
	private static final long serialVersionUID = -7719334151149195195L;
	NewVacationRequestPageObject newVacationRequestPageObject;

	@Step
	public void selectVacationWithoutPayment() {
		newVacationRequestPageObject.selectVacationWithoutPayment();
	}

	@Step
	public void selectSpecialVacation() {
		newVacationRequestPageObject.selectspecialVacation();
	}

	@Step
	public void dropDownAndSelectItem(String item) {
		newVacationRequestPageObject.droDownAndSelectItem(item);
	}
	
	@Step 
	public void setStartDate(int day, int month, int year) throws ParseException{
		newVacationRequestPageObject.setStartDate(day, month, year);
	}
	
	@Step 
	public void setEndDate(int day, int month, int year) throws ParseException{
		newVacationRequestPageObject.setEndDate(day, month, year);
	}
	
	@Step
	public void clickSaveButton(){
		newVacationRequestPageObject.clickSaveButton();
	}
}
