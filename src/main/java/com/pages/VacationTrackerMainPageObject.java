package com.pages;

import java.text.ParseException;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.WebDriver;

public class VacationTrackerMainPageObject extends PageObject {
	private WebDriver webdriver;

	@FindBy(xpath = "//input[contains(@id, 'trackerStartDate')]")
	private WebElementFacade startDateField;
	@FindBy(xpath = "//input[contains(@id, 'trackerEndDate')]")
	private WebElementFacade endDateField;
	private int startDay, startMonth, startYear, endDay, endMonth, endYear;

	/**
	 * Method to set the start date in the DatePicker popup.
	 * @param day int value, designating the selected start day
	 * @param month int value, designating the selected start month, where 0 is January and 11 is December
	 * @param year int value, designating the selected start year
	 */
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

	/**
	 * Method to set the end date in the DatePicker popup.
	 * @param day int value, designating the selected end day
	 * @param month int value, designating the selected end month, where 0 is January and 11 is December
	 * @param year int value, designating the selected end year
	 */
	public void setEndDate(int day, int month, int year) {
		webdriver = getDriver();
		endDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		try {
			datePopup.setDate(day, month, year);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to return the start day value from the DatePicker popup.
	 * 
	 * @return an int value, designating selected start day from the popup.
	 */
	public int getStartDay() {
		webdriver = getDriver();
		startDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		return datePopup.getSelectedDay();
	}

	/**
	 * Method to return an int value, from 0 to 11, designating the start month.
	 * January is 0, December is 11.
	 * 
	 * @return an int value, from 0 to 11, designating the month.
	 */
	public int getStartMonth() throws ParseException {
		webdriver = getDriver();
		startDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		return datePopup.getSelectedMonth();
	}

	/**
	 * Method to return the value of the selected start year from the DatePicker popup.
	 * @return an int value, designating the selected year.
	 * @throws ParseException
	 */
	public int getStartYear() throws ParseException {
		webdriver = getDriver();
		startDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		return datePopup.getSelectedYear();
	}

	/**
	 * Method to return the end day value from the DatePicker popup.
	 * 
	 * @return an int value, designating selected end day from the popup.
	 */
	public int getEndDay() {
		webdriver = getDriver();
		endDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);		
		return datePopup.getSelectedDay();		
	}

	/**
	 * Returns an int value, from 0 to 11, designating the selected end month. January is 0,
	 * December is 11.
	 * 
	 * @return an int value, from 0 to 11, designating the selected end month.
	 * @throws ParseException 
	 */
	public int getEndMonth() throws ParseException {
		webdriver = getDriver();
		startDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		return datePopup.getSelectedMonth();
	}

	/**
	 * Method to return the value of the selected end year from the DatePicker popup.
	 * @return an int value, designating the selected end year.
	 * @throws ParseException
	 */
	public int getEndYear() throws ParseException {
		webdriver = getDriver();
		startDateField.click();
		DatePopupPageObject datePopup = new DatePopupPageObject(webdriver);
		return datePopup.getSelectedYear();
	}
	
	public void openStartDatePicker(){
		startDateField.click();
	}
	
	public void openEndDatePicker(){
		endDateField.click();
	}

}
