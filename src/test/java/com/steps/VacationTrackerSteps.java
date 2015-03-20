package com.steps;

import com.pages.VacationTrackerMainPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class VacationTrackerSteps extends ScenarioSteps {
	private static final long serialVersionUID = -2554212203016046482L;
	VacationTrackerMainPageObject vacationTrackerMainPageObject;

	@Step
	public void setStartDate(int day, int month, int year) {
		vacationTrackerMainPageObject.setStartDate(day, month, year);
	}

}
