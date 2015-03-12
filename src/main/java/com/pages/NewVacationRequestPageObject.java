package com.pages;

import java.text.ParseException;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class NewVacationRequestPageObject extends PageObject {

	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CF']")
	private WebElementFacade vacationWithoutPaymentRadioButton;
	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_type_CS']")
	private WebElementFacade specialVacationRadioButton;
	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_specialReason']")
	private WebElementFacade specialVacationDropDown;
	@FindBy(css="input[name='startDate']")
	private WebElementFacade startDatePicker;	
	@FindBy(css="input[name='endDate']")
	private WebElementFacade endDatePicker;
	@FindBy(css="[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade saveButton;
	
	DatePopupPageObject datePopup;
	
	public void droDownAndSelectItem(String item) {
		specialVacationDropDown.selectByVisibleText(item);
	}
	
	public void selectVacationWithoutPayment() {
		vacationWithoutPaymentRadioButton.click();
	}
	
	public void selectspecialVacation() {
		specialVacationRadioButton.click();
	}
	
	public void openStartDatePicker(){
		startDatePicker.click();
		datePopup = new DatePopupPageObject(getDriver());
	}
	
	public void openEndDatePicker(){
		endDatePicker.click();
		datePopup = new DatePopupPageObject(getDriver());
	}
	
	public void setStartDate(int day, int month, int year) throws ParseException{
		openStartDatePicker();
		datePopup.setDate(day, month, year);
	}
	
	public void setEndDate(int day, int month, int year) throws ParseException {
		openEndDatePicker();
		datePopup.setDate(day, month, year);
	}
	
	public void clickSaveButton(){
		saveButton.click();
	}
}
