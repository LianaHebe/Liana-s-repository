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

import com.dataclasses.VacationAppConstants;
import com.requirements.Application;
import com.steps.FreeDaysHistorySteps;
import com.steps.LoginAndNavigationSteps;

@Story(Application.Vacations.MyRequestsTest.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("resources/Filters2.csv")
public class FreeDaysHistoryTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = VacationAppConstants.BASE_URL)
	public Pages pages;

	@Steps
	public LoginAndNavigationSteps loginAndNavigationSteps;

	@Steps
	public FreeDaysHistorySteps freeDaysHistory;

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToFreeDaysHistory();
	}

	String VacationType, DaysNumber, Operation;
	
	@Test
	public void myFreeDaysHistory() {
		freeDaysHistory.selectFilterItems(VacationType);
		freeDaysHistory.selectFilterItems(DaysNumber);
		freeDaysHistory.selectFilterItems(Operation);
		freeDaysHistory.clickApplyButton();		
	}	
}
