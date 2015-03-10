package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.requirements.Application;
import com.steps.LoginAndNavigationSteps;
import com.steps.MyRequestsSteps;

//import com.steps.NewVacationRequestSteps;

@Story(Application.Vacations.MyRequestsTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/Filters.csv")
public class MyRequestsTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
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
