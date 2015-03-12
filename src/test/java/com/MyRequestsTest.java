package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dataclasses.MyLoginInfo;
import com.requirements.Application;
import com.steps.LoginAndNavigationSteps;
import com.steps.MyRequestsSteps;

@Story(Application.Vacations.MyRequestsTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/Filters.csv")
public class MyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = MyLoginInfo.BASE_URL)
	public Pages pages;

	@Steps
	public LoginAndNavigationSteps loginAndNavigationSteps;

	@Steps
	public MyRequestsSteps myRequestSteps;

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToMyRequests();
	}

	String VacationType, DaysNumber, VacationStatus;

	@Test
	public void clickVacationType() {

		myRequestSteps.testIfEvozonLogoIsPresent();
		myRequestSteps.clickCheckBoxVacationType(VacationType);
		myRequestSteps.clickCheckBoxDaysNumber(DaysNumber);
		myRequestSteps.clickCheckBoxVacationStatus(VacationStatus);
		myRequestSteps.clickApplyButton();

	}
}
