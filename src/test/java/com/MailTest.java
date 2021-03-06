package com;

import java.io.IOException;
import java.text.ParseException;

import javax.mail.MessagingException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.dataclasses.VacationAppConstants;
import com.steps.EmailSteps;
import com.steps.LoginAndNavigationSteps;
import com.steps.NewVacationRequestSteps;

@RunWith(ThucydidesRunner.class)
public class MailTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = VacationAppConstants.BASE_URL)
	public Pages pages;

	@Steps
	public LoginAndNavigationSteps loginAndNavigationSteps;

	@Steps
	public NewVacationRequestSteps newVacationRequestSteps;

	@Steps
	public EmailSteps emailSteps;

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToNewVacationRequest();
	}

	@Test
	public void checkIfMailWasReceived() throws ParseException,
			MessagingException, IOException {

		newVacationRequestSteps.setStartDate(5, 4, 2015);
		newVacationRequestSteps.setEndDate(6, 4, 2015);
		newVacationRequestSteps.selectVacationWithoutPayment();
		newVacationRequestSteps.clickSaveButton();

		String startDate = "5/05/2015";
		String endDate = "6/05/2015";
		String body = "You have submitted a new Vacation Request.";

		emailSteps.checkLastEmailSubjectAndBody(
				"You have submitted a new Vacation Request", body);

		newVacationRequestSteps.withdrawSubmittedRequest();

	}
}
