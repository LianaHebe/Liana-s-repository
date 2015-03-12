package com;

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
import com.steps.MyFreeDaysSteps;

@Story(Application.Vacations.MyFreeDaysTest.class)
@RunWith(ThucydidesRunner.class)
public class MyFreeDaysTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	// @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	@ManagedPages(defaultUrl = VacationAppConstants.BASE_URL)
	public Pages pages;

	@Steps
	public LoginAndNavigationSteps loginAndNavigationSteps;

	@Steps
	public MyFreeDaysSteps myFreeDaysSteps;

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToMyFreeDays();
	}

	@Test
	public void myFreeDays() {
		myFreeDaysSteps.clickBackButton();
	}
}
