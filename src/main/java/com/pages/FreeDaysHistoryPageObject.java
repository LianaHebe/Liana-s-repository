package com.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

public class FreeDaysHistoryPageObject extends PageObject {

	@FindBy(css = "input[id $='applyButton']")
	private WebElementFacade applyButton;
	
	public void selectFilterItem(String filterName) {
		List<WebElement> filtersList = getDriver().findElements(
				By.cssSelector((".aui-choice-label")));
		if (!filterName.trim().contentEquals("")) {
			boolean foundOption = false;
			
			for (WebElement filter : filtersList) {
				if (filter.getText().equals(filterName)) {
					System.out.print(filter.getText());
					foundOption = true;
					filter.click();
					break;
				}
			}
			Assert.assertTrue("The option was not found!", foundOption);
		}
	}

	public void clickApplyButton() {
		applyButton.click();
	}
}
