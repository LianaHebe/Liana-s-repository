package com.steps;

import com.dataclasses.MyLoginInfo;
import com.pages.SideMenuPageObject;
import com.pages.VacationsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

	VacationsPage vacationsPage;
	SideMenuPageObject sideMenuPageObject;

	@Step
	public void enterUserNameAndPassword() {
		vacationsPage.enter_username(MyLoginInfo.username);
		vacationsPage.enter_password(MyLoginInfo.password);
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
	}

	@Step
	public void goToVacations() {
		vacationsPage.goToVacations();
	}

//	@Step
//	public void signIn() {
//		enterUserNameAndPassword();
//		vacationsPage.clickSubmit();
//	}
	
	@Step
	public void goToNewVacationRequest(){
		sideMenuPageObject.goToNewVacationRequest();
	}

	@Step
    public void signIn() {    	
        enterUserNameAndPassword();
        vacationsPage.clickSubmit();
        vacationsPage.clickVacation();
        
    }
}
