package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePopupPageObject extends PageObject {
	private WebDriver webdriver;

	public enum Screen {
		DaysScreen, MonthsScreen, YearsScreen
	}

	private Screen screen = Screen.DaysScreen;
	private WebElement datePopupTitle;
	GregorianCalendar currentDateCalendar, desiredDateCalendar;

	// /**
	// * Date Popup page object constructor. Each time a date is set, the popup
	// is
	// * closed. Once the popup is closed, to interact with it, we need to
	// create
	// * a new one.
	// */
	// public DatePopupPageObject() {
	// super();
	// }

	/**
	 * Date Popup page object constructor. Each time a date is set, the popup is
	 * closed. Once the popup is closed, to interact with it, we need to create
	 * a new one.
	 * 
	 * @param webdriver
	 */
	public DatePopupPageObject(WebDriver webdriver) {
		super();
		this.webdriver = webdriver;
	}

	/**
	 * Method to set the date inside a DatePicker popup.
	 * 
	 * @param day
	 *            - an int, from 0 to 30, designating desired day of month.
	 *            Actual day is obtained by adding "1".
	 * 
	 * @param month
	 *            - an int, from 0 to 11, designating desired month, where 0 is
	 *            January, and 11 is December
	 * 
	 * @param year
	 *            - an int
	 * @throws ParseException
	 */
	public void setDate(int day, int month, int year) throws ParseException {
		WebDriverWait genericWait = new WebDriverWait(webdriver, 10000L, 500L);
		SimpleDateFormat sdfOldDate = new SimpleDateFormat("MMM, yyyy, dd");
		desiredDateCalendar = new GregorianCalendar(year, month, day);
		Date desiredDate = desiredDateCalendar.getTime();
		System.out.println("Desired date is: " + desiredDate);
		WebDriverWait waitForDatePopup = new WebDriverWait(webdriver, 5000L,
				500L);
		WebElement datePopup = waitForDatePopup
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]")));
		WebDriverWait waitForPopupTitle = new WebDriverWait(webdriver, 5000L,
				500L);
		datePopupTitle = waitForPopupTitle
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table/tbody/tr/td[contains(@class,'dp_caption')]")));

		WebDriverWait waitForNextAndPreviousButtons = new WebDriverWait(
				webdriver, 5000L, 500L);
		WebElement nextButton = waitForNextAndPreviousButtons
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table/tbody/tr/td[contains(@class,'dp_next')]")));
		WebElement previousButton = waitForNextAndPreviousButtons
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table/tbody/tr/td[contains(@class,'dp_previous')]")));
		String oldMonthAndYear = datePopupTitle.getText();

		WebDriverWait waitForOriginalDate = new WebDriverWait(webdriver, 5000L,
				500L);
		WebElement originalDateFromPopup = waitForOriginalDate
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class, 'Zebra_DatePicker') and contains(@style, 'display: block')]/table[@class='dp_daypicker']/tbody/tr/td[contains(@class,'dp_selected')]")));
		String oldDayOfMonth = originalDateFromPopup.getText();

		Date oldDate = sdfOldDate.parse(oldMonthAndYear + ", " + oldDayOfMonth);
		System.out.println("Old date in field is: " + oldDate);
		currentDateCalendar = new GregorianCalendar();
		currentDateCalendar.setTime(oldDate);

		whileDateSearch: while ((currentDateCalendar
				.get(currentDateCalendar.YEAR) != desiredDateCalendar
				.get(desiredDateCalendar.YEAR))
				|| (currentDateCalendar.get(currentDateCalendar.MONTH) != desiredDateCalendar
						.get(desiredDateCalendar.MONTH))
				|| (currentDateCalendar.get(currentDateCalendar.DAY_OF_MONTH) != desiredDateCalendar
						.get(desiredDateCalendar.DAY_OF_MONTH))) {
			if (oldDate.compareTo(desiredDate) == -1) {
				boolean foundYear = false;
				// Navigate to "Year Picker" inside date popup.
				datePopupTitle.click();
				datePopupTitle.click();

				whileYearNotOk: while (!foundYear) {
					screen = Screen.YearsScreen;
					List<WebElement> yearCells = genericWait
							.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
									.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table[contains(@class,'dp_yearpicker')]/tbody/tr/td")));
					forYearCells: for (WebElement webElement : yearCells) {
						if (Integer.decode(webElement.getText()).intValue() == desiredDateCalendar
								.get(desiredDateCalendar.YEAR)) {
							System.out.println("Clicking year "
									+ webElement.getText());
							foundYear = true;
							webElement.click();
							break forYearCells;
						}
					}
					if (foundYear) {
						break whileYearNotOk;
					} else {
						nextButton.click();
					}
				}

				screen = Screen.MonthsScreen;

				List<WebElement> monthCells = genericWait
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
								.xpath("//div[contains(@class, 'Zebra_DatePicker') and (contains(@style, 'display: block'))]/table[contains(@class,'dp_monthpicker')]/tbody/tr/td")));
				WebElement januaryCell = monthCells.get(0);
				WebElement februaryCell = monthCells.get(1);
				WebElement marchCell = monthCells.get(2);
				WebElement aprilCell = monthCells.get(3);
				WebElement mayCell = monthCells.get(4);
				WebElement juneCell = monthCells.get(5);
				WebElement julyCell = monthCells.get(6);
				WebElement augustCell = monthCells.get(7);
				WebElement septemberCell = monthCells.get(8);
				WebElement octoberCell = monthCells.get(9);
				WebElement novemberCell = monthCells.get(10);
				WebElement decemberCell = monthCells.get(11);
				switch (desiredDateCalendar.get(desiredDateCalendar.MONTH)) {
				case 0:
					januaryCell.click();
					break;
				case 1:
					februaryCell.click();
					break;
				case 2:
					marchCell.click();
					break;
				case 3:
					aprilCell.click();
					break;
				case 4:
					mayCell.click();
					break;
				case 5:
					juneCell.click();
					break;
				case 6:
					julyCell.click();
					break;
				case 7:
					augustCell.click();
					break;
				case 8:
					septemberCell.click();
					break;
				case 9:
					octoberCell.click();
					break;
				case 10:
					novemberCell.click();
					break;
				case 11:
					decemberCell.click();
					break;
				}
				List<WebElement> dayCells = genericWait
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
								.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table[contains(@class,'dp_daypicker')]/tbody/tr/td[not(@class='dp_not_in_month')]")));
				int actualDayValue = desiredDateCalendar
						.get(desiredDateCalendar.DAY_OF_MONTH);
				for (WebElement webElement : dayCells) {
					if (Integer.decode(webElement.getText()).intValue() == actualDayValue) {
						System.out.println("Attempting to click on day cell "
								+ actualDayValue);
						webElement.click();
						break;
					}
				}

				break whileDateSearch;

			} else {
				boolean foundYear = false;
				// Navigate to "Year Picker" inside date popup.
				datePopupTitle.click();
				datePopupTitle.click();
				whileYearNotOk: while (!foundYear) {

					screen = Screen.YearsScreen;

					List<WebElement> yearCells = genericWait
							.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
									.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table[contains(@class,'dp_yearpicker')]/tbody/tr/td")));
					forYearCells: for (WebElement webElement : yearCells) {
						if (Integer.decode(webElement.getText()).intValue() == desiredDateCalendar
								.get(desiredDateCalendar.YEAR)) {
							System.out.println("Clicking year "
									+ webElement.getText());
							foundYear = true;
							webElement.click();
							break forYearCells;
						}
					}
					if (foundYear) {
						break whileYearNotOk;
					} else {
						previousButton.click();
					}
				}

				screen = Screen.MonthsScreen;

				List<WebElement> monthCells = genericWait
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
								.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table[contains(@class,'dp_monthpicker')]/tbody/tr/td")));
				WebElement januaryCell = monthCells.get(0);
				WebElement februaryCell = monthCells.get(1);
				WebElement marchCell = monthCells.get(2);
				WebElement aprilCell = monthCells.get(3);
				WebElement mayCell = monthCells.get(4);
				WebElement juneCell = monthCells.get(5);
				WebElement julyCell = monthCells.get(6);
				WebElement augustCell = monthCells.get(7);
				WebElement septemberCell = monthCells.get(8);
				WebElement octoberCell = monthCells.get(9);
				WebElement novemberCell = monthCells.get(10);
				WebElement decemberCell = monthCells.get(11);
				switch (desiredDateCalendar.get(desiredDateCalendar.MONTH)) {
				case 0:
					januaryCell.click();
					break;
				case 1:
					februaryCell.click();
					break;
				case 2:
					marchCell.click();
					break;
				case 3:
					aprilCell.click();
					break;
				case 4:
					mayCell.click();
					break;
				case 5:
					juneCell.click();
					break;
				case 6:
					julyCell.click();
					break;
				case 7:
					augustCell.click();
					break;
				case 8:
					septemberCell.click();
					break;
				case 9:
					octoberCell.click();
					break;
				case 10:
					novemberCell.click();
					break;
				case 11:
					decemberCell.click();
					break;
				}
				List<WebElement> dayCells = genericWait
						.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
								.xpath("//div[contains(@class,'Zebra_DatePicker') and contains(@style,'display: block')]/table[contains(@class,'dp_daypicker')]/tbody/tr/td[not(@class='dp_not_in_month')]")));

				int actualDayValue = desiredDateCalendar
						.get(desiredDateCalendar.DAY_OF_MONTH);
				for (WebElement webElement : dayCells) {
					if (Integer.decode(webElement.getText()).intValue() == actualDayValue) {
						System.out.println("Attempting to click on day cell "
								+ actualDayValue);
						webElement.click();
						break;
					}
				}

				break whileDateSearch;

			}
		}
	}

	/**
	 * Closes the date selection popup.
	 */
	public void closePopup() {
		datePopupTitle = new WebDriverWait(webdriver, 5L)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table/tbody/tr/td[contains(@class,'dp_caption')]")));
		System.out.println("Closing the date popup.");
		datePopupTitle.sendKeys(Keys.ESCAPE);
	}

	/**
	 * Method to return value of selected day from DatePicker popup.
	 * 
	 * @return int value of selected day from DatePicker popup.
	 */
	public int getSelectedDay() {
		WebElement originalDateFromPopup = new WebDriverWait(webdriver, 10L,
				500L)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class, 'Zebra_DatePicker') and contains(@style, 'display: block')]/table[@class='dp_daypicker']/tbody/tr/td[contains(@class,'dp_selected')]")));
		String oldDayOfMonth = originalDateFromPopup.getText();
		int dayNumber = Integer.decode(oldDayOfMonth);
		System.out.println("Selected day is: " + dayNumber + ".");
		closePopup();
		return dayNumber;
	}

	/**
	 * Method to return value of selected month from DatePicker popup.
	 * 
	 * @return int value of selected month from DatePicker popup. Values are
	 *         between 0 and 11, where 0 is January and 11 is December.
	 */
	public int getSelectedMonth() throws ParseException {
		datePopupTitle = new WebDriverWait(webdriver, 5L)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table/tbody/tr/td[contains(@class,'dp_caption')]")));
		SimpleDateFormat sdfSelectedMonthAndYear = new SimpleDateFormat(
				"MMM, yyyy");
		Date selectedDate = sdfSelectedMonthAndYear.parse(datePopupTitle
				.getText());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(selectedDate);
		int monthNumber = calendar.get(calendar.MONTH);
		System.out.println("Selected month is: " + monthNumber + ". ");
		System.out
				.print("Remember that month numbers are represented from 0 to 11, where 0 is January and 11 is December.");
		closePopup();
		return monthNumber;
	}

	/**
	 * Method to return value of selected year from DatePicker popup.
	 * 
	 * @return int value of selected year from DatePicker popup.
	 */
	public int getSelectedYear() throws ParseException {
		datePopupTitle = new WebDriverWait(webdriver, 5L)
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//div[contains(@class,'Zebra_DatePicker') and (contains(@style,'display: block'))]/table/tbody/tr/td[contains(@class,'dp_caption')]")));
		SimpleDateFormat sdfSelectedMonthAndYear = new SimpleDateFormat(
				"MMM, yyyy");
		Date selectedDate = sdfSelectedMonthAndYear.parse(datePopupTitle
				.getText());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(selectedDate);
		int yearNumber = calendar.get(calendar.YEAR);
		System.out.println("Selected year is: " + yearNumber + ".");
		closePopup();
		return yearNumber;

	}

	// public int getEndDay(){
	//
	// }
	//
	// public int getEndMonth(){
	//
	// }
	//
	// public int getEndYear(){
	//
	// }

	/*
	 * public Date getDate(){
	 * 
	 * }
	 * 
	 * public Date getCurrentDate(){
	 * 
	 * }
	 */

}
