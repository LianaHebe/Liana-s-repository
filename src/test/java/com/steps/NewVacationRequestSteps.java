package com.steps;

import com.pages.NewVacationRequestPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class NewVacationRequestSteps extends ScenarioSteps{

	NewVacationRequestPageObject newVacationRequestPageObject;
	
	@Step
	public void selectVacationWithoutPayment(){
		newVacationRequestPageObject.selectVacationWithoutPayment();
	}	
}
