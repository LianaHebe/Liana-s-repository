package com.steps;

import com.pages.MyFreeDaysPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyFreeDaysSteps extends ScenarioSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyFreeDaysPageObject myFreeDays;

	@Step
	public void clickBackButton() {
		myFreeDays.myFreeDays();
	}
}
