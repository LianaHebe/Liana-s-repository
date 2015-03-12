package com.steps;

import com.pages.MyFreeDaysPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysSteps extends ScenarioSteps  {

	MyFreeDaysPageObject myFreeDays;
	
	@Step
	public void clickBackButton(){
		myFreeDays.myFreeDays();
	}
}
