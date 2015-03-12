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

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToNewVacationRequest();
	}

	// @Test
	public void selectVacationWithoutPayment() {
		newVacationRequestSteps.selectVacationWithoutPayment();
	}

	//@Test
	public void selectSpecialVacation() {
		newVacationRequestSteps.selectSpecialVacation();
		newVacationRequestSteps.dropDownAndSelectItem("Other");
	}
	
	@Test 
	public void setDate() throws ParseException { 
		newVacationRequestSteps.setStartDate(10, 2, 2015);
		newVacationRequestSteps.setEndDate(11, 2, 2015);
		newVacationRequestSteps.selectVacationWithoutPayment();
		newVacationRequestSteps.clickSaveButton();
		
	}
}
