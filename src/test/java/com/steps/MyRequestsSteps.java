package com.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.MyRequestsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MyRequestsSteps extends ScenarioSteps {
	private WebDriver webdriver;

	MyRequestsPage myRequestsPage;

	@Step
	public void testIfEvozonLogoIsPresent() {
		webdriver = getDriver();
		WebElement evozonLogo;
		try {
			evozonLogo = webdriver.findElement(By
					.xpath("//img[contains(@alt,'EvoPortal')]"));
		} catch (NotFoundException e) {
			evozonLogo = null;
		}

		Assert.assertTrue(evozonLogo != null);
	}

	@Step
	public void clickCheckBoxVacationType(String vacationType) {
		myRequestsPage.clickCheckBoxVacationType(vacationType);
	}

	@Step
	public void clickCheckBoxVacationStatus(String vacationStatus) {
		myRequestsPage.clickCheckBoxVacationStatus(vacationStatus);
	}

	@Step
	public void clickCheckBoxDaysNumber(String daysNumber) {
		myRequestsPage.clickCheckBoxDaysNumber(daysNumber);
	}

	@Step
	public void clickApplyButton() {
		myRequestsPage.clickApplyButton();
	}
}
