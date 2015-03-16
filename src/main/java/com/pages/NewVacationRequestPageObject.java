package com.pages;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.thucydides.core.annotations.findby.By;
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
	@FindBy(css = "input[name='startDate']")
	private WebElementFacade startDatePicker;
	@FindBy(css = "input[name='endDate']")
	private WebElementFacade endDatePicker;
	@FindBy(css = "[id='_evovacation_WAR_EvoVacationportlet_saveButton']")
	private WebElementFacade saveButton;
	@FindBy(css = "span[class*='aui-paginator-current-page-report aui-paginator-total']")
	private WebElementFacade totalPages;
	@FindBy(css = "a[class*='aui-paginator-link aui-paginator-next-link']")
	private WebElementFacade nextButton;
	@FindBy(css = "input[id $='applyButton']")
	private WebElementFacade applyButton;

	DatePopupPageObject datePopup;

	public void droDownAndSelectItem(String item) {
		specialVacationDropDown.selectByVisibleText(item);
	}

	public void selectVacationWithoutPayment() {
		vacationWithoutPaymentRadioButton.click();
	}

	public void selectSpecialVacation() {
		specialVacationRadioButton.click();
	}

	public void openStartDatePicker() {
		startDatePicker.click();
		datePopup = new DatePopupPageObject(getDriver());
	}

	public void openEndDatePicker() {
		endDatePicker.click();
		datePopup = new DatePopupPageObject(getDriver());
	}

	public void setStartDate(int day, int month, int year)
			throws ParseException {
		openStartDatePicker();
		datePopup.setDate(day, month, year);
	}

	public void setEndDate(int day, int month, int year) throws ParseException {
		openEndDatePicker();
		datePopup.setDate(day, month, year);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickApplyButton() {
		applyButton.click();
	}

	/* Select and check pending filter */
	public void selectFilterItem(String filterName) {
		List<WebElement> filtersList = getDriver().findElements(
				By.cssSelector((".aui-choice-label")));
		if (!filterName.trim().contentEquals("")) {
			boolean foundOption = false;
			for (WebElement vacatioType : filtersList) {
				if (vacatioType.getText().equals(filterName)) {
					System.out.print(vacatioType.getText());
					foundOption = true;
					vacatioType.click();
					break;
				}
			}
			Assert.assertTrue("The option was not found!", foundOption);
		}
	}

	public void checkFilterAndClickNextPage(String filter, String filterCategory) {

		String textfield = totalPages.getText().toString();
		String[] newstring = textfield.split(" ");
		String newnewstring = newstring[0];

		System.out.println(newnewstring);

		String last, last1 = "";
		last = newnewstring.substring(1, newnewstring.length());

		String newnewstring1 = newstring[2];
		last1 = newnewstring1.substring(0, newnewstring1.length() - 1);

		System.out.println(last1);
		System.out.println(last);

		int lastt1 = Integer.parseInt(last1);
		int lastt = Integer.parseInt(last);

		while (lastt1 > lastt) {
			checkFilters(filter, filterCategory);
			System.out.println("iN WHILE " + last1);
			System.out.println("iN WHILE " + last);
			lastt++;
			nextButton.click();
		}
		// To navigate back to first page of results:
		clickApplyButton();
	}

	public void checkFilters(String filter, String filterCategory) {
		List<WebElement> tableCells = null;

		switch (filterCategory) {
		// Next section is pending.
		// case "Start Date":
		// tableCells = new WebDriverWait(getDriver(), 5L)
		// .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
		// .xpath("//td[contains(@id,'my.request.column.header.start.date')]/a")));
		// break;
		//
		// case "End Date":
		// tableCells = new WebDriverWait(getDriver(), 5L)
		// .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
		// .xpath("//td[contains(@id,'my.request.column.header.end.date')]/a")));
		// break;

		case "Type":
			tableCells = new WebDriverWait(getDriver(), 5L)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
							.xpath("//td[contains(@id,'my.request.column.header.type')]/a")));
			break;

		case "Status":
			tableCells = new WebDriverWait(getDriver(), 5L)
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
							.xpath("//td[contains(@id,'my.request.column.header.status')]/a")));
			break;
		}

		for (WebElement tableCell : tableCells) {//
			Assert.assertTrue(tableCell.getText().contentEquals(filter));
		}
	}
}
