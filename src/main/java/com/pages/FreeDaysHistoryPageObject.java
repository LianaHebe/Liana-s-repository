package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class FreeDaysHistoryPageObject extends PageObject {

	public void selectFilterItem(String filterName) {
		List<WebElement> filtersList = getDriver().findElements(
				By.cssSelector((".aui-choice-label")));
		if (!filterName.trim().contentEquals("")) {
			boolean foundOption = false;
			for (WebElement vacatioType : filtersList) {
				if (vacatioType.getText().equals(filterName)) {
					System.out.print(vacatioType.getText());
					foundOption = true;
					vacatioType.click();
					break;
				}
			}
			Assert.assertTrue("The option was not found!", foundOption);
		}
	}

	@FindBy(css = "input[id $='applyButton']")
	private WebElementFacade applyButton;

	public void clickApplyButton() {
		applyButton.click();
	}
}
