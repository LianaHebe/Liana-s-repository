package com.pages;

import java.text.ParseException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

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

	public void selectspecialVacation() {
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

	//	public void nextPage(String filter, String filterName) { //ORIGINAL
		public void nextPage(String filter, String[] filterNames) {

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

//		checkFilters(filter, filterName); //ORIGINAL
		while (lastt1 > lastt) {
		for (String filterName : filterNames) {
			checkFilters(filter, filterName);			
		}

			System.out.println("iN WHILE " + last1);
			System.out.println("iN WHILE " + last);

			lastt++;

			nextButton.click();
//			checkFilters(filter, filterName);
		}

	}

	public void checkFilters(String filter, String filterName) {
		
		//td[contains(@id,'my.request.column.header.start.date')]/a
		//td[contains(@id,'my.request.column.header.end.date')]/a
		//td[contains(@id,'my.request.column.header.type')]/a
		//td[contains(@id,'my.request.column.header.status')]/a
		switch (filter) {
		case "":
			
			break;

		default:
			break;
		}
		
		List<WebElement> tableCells = getDriver().findElements(
				By.cssSelector("tr td[id*='evovacation'][class*='col-6']"));

		if (!filterName.trim().contentEquals("")) {
			if (filter.contentEquals("Vacation Status")) {
				boolean option = false;

				for (WebElement tableCell : tableCells) {

					if ((tableCell.getText()
							.contentEquals(filterName))) {
						System.out
								.print("!!! Vacation status displayed in the table!!! "
										+ tableCell.getText());
						System.out.print("Selected option :" + filterName);
						option = true;

					}

				}

				Assert.assertTrue("The option " + filterName
						+ " was not found!", option);
			}
		}
	}

}
