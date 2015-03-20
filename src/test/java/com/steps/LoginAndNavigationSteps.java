package com.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import com.dataclasses.VacationAppConstants;
import com.pages.NewVacationRequestPageObject;
import com.pages.SideMenuPageObject;
import com.pages.VacationsPage;

public class LoginAndNavigationSteps extends ScenarioSteps {

	private static final long serialVersionUID = 546423554344803636L;

	VacationsPage vacationsPage;
	SideMenuPageObject sideMenuPageObject;
	NewVacationRequestPageObject newVacationRequestPageObject;

	@Step
	public void enterDMUserNameAndPassword() {
		vacationsPage.enter_username(VacationAppConstants.DM_USERNAME);
		vacationsPage.enter_password(VacationAppConstants.DM_PASSWORD);
	}

	@Step
	public void enterUserNameAndPassword() {
		vacationsPage.enter_username(VacationAppConstants.USERNAME);
		vacationsPage.enter_password(VacationAppConstants.PASSWORD);
	}

	@Step
	public void starts_search() {
		vacationsPage.clickSubmit();
	}

	@Step
	public void should_see_definition(String definition) {
		assertThat(vacationsPage.getDefinitions(),
				hasItem(containsString(definition)));
	}

	@Step
	public void is_the_home_page() {
		vacationsPage.open();
		getDriver().manage().window().maximize();
	}

	@Step
	public void goToVacations() {
		vacationsPage.goToVacations();
	}

	@Step
	public void goToNewVacationRequest() {
		sideMenuPageObject.goToNewVacationRequest();
	}

	@Step
	public void goToMyRequests() {
		sideMenuPageObject.goToMyRequests();
	}

	@Step
	public void goToMyFreeDays() {
		sideMenuPageObject.goToMyFreeDays();
	}

	@Step
	public void goToFreeDaysHistory() {
		sideMenuPageObject.goToFreeDaysHistory();
	}

	@Step
	public void goToVacationTracker() {
		sideMenuPageObject.goToVacationTracker();
	}

	@Step
	public void signInAsDM() {
		enterDMUserNameAndPassword();
		vacationsPage.clickSubmit();
	}

	@Step
	public void signInAsBasicUser() {
		enterUserNameAndPassword();
		vacationsPage.clickSubmit();
	}

}
