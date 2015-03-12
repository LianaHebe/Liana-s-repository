package com.steps;

import com.pages.FreeDaysHistoryPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FreeDaysHistorySteps extends ScenarioSteps{
	
	FreeDaysHistoryPageObject freeDaysHistory;

	@Step
	public void selectFilterItems(String filterName) {
		freeDaysHistory.selectFilterItem(filterName);
	}
	
	@Step
	public void clickApplyButton() {
		freeDaysHistory.clickApplyButton();
	}
}
