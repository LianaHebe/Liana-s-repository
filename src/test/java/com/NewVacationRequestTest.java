package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dataclasses.VacationAppConstants;
import com.requirements.Application;
import com.steps.EmailSteps;
import com.steps.LoginAndNavigationSteps;
import com.steps.NewVacationRequestSteps;

@Story(Application.Vacations.NewVacationRequestTest.class)
@RunWith(ThucydidesRunner.class)
public class NewVacationRequestTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = VacationAppConstants.BASE_URL)
	public Pages pages;

	@Steps
	public LoginAndNavigationSteps loginAndNavigationSteps;

	@Steps
	public NewVacationRequestSteps newVacationRequestSteps;
	
	@Steps
	public EmailSteps emailSteps;

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToNewVacationRequest();
	}

	//@Test
	public void selectVacationWithoutPayment() {
		newVacationRequestSteps.selectVacationWithoutPayment();
	}

	//@Test
	public void selectSpecialVacation() {
		newVacationRequestSteps.selectSpecialVacation();
		newVacationRequestSteps.dropDownAndSelectItem("Marriage");
		newVacationRequestSteps.dropDownAndSelectItem("Child birth");
		newVacationRequestSteps.dropDownAndSelectItem("Funeral");
		newVacationRequestSteps.dropDownAndSelectItem("Other");
	}		
	
	String filter;
	
	@Test 
	public void createNewVacationWithoutPaymentAndCheckInMyRequests() throws ParseException { 
		newVacationRequestSteps.setStartDate(13, 4, 2015);
		newVacationRequestSteps.setEndDate(14, 4, 2015);
		/*GregorianCalendar startDateCal = new GregorianCalendar(10, 2, 2015);
		GregorianCalendar endDateCal = new GregorianCalendar(11, 2, 2015);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		Date startDate = formatter.parse(10 + "/"+2+"/"+2015);
		StringBuffer startDateStringFormatted = formatter.format(startDate, startDateStringFormatted, 0);
		*/
		newVacationRequestSteps.selectVacationWithoutPayment();
//		newVacationRequestSteps.selectSpecialVacation();
//		newVacationRequestSteps.dropDownAndSelectItem("Marriage");
		newVacationRequestSteps.clickSaveButton();

		loginAndNavigationSteps.goToMyRequests();
		newVacationRequestSteps.selectFilterItem("Vacation Without Payment");
		newVacationRequestSteps.selectFilterItem("Pending");
		newVacationRequestSteps.clickApplyButton();
		newVacationRequestSteps.checkFilterAndClickNextPage("Vacation Without Payment", "Type");
		newVacationRequestSteps.checkFilterAndClickNextPage("Pending", "Status");
	}
}
