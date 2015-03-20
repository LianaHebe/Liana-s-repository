package com;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.requirements.Application;
import com.steps.LoginAndNavigationSteps;
import com.steps.VacationTrackerSteps;

@Story(Application.Vacations.VacationTrackerTest.class)
//@RunWith(ThucydidesParameterizedRunner.class)
//@UseTestDataFrom("resources/dateSet.csv")
@RunWith(ThucydidesRunner.class)
public class VacationTrackerTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	@ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
	public Pages pages;
	@Steps
	public LoginAndNavigationSteps loginAndNavigationSteps;
	@Steps
	public VacationTrackerSteps vacationTrackerSteps;
	// These parameters are extracted from dateSet.csv.
	String dayString, monthString, yearString;

	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsDM();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToVacationTracker();
		webdriver.manage().window().maximize();
	}

	@Test
	public void testStartDateLaterThanEndDate() throws ParseException {
		// Decode the parameters from the dateSet.csv file.
//		int dayInt = Integer.decode(dayString).intValue();
//		int monthInt = Integer.decode(monthString).intValue();
//		int yearInt = Integer.decode(yearString).intValue();
		// Set the date according to the parameters from dateSet.csv.
		int startDay=12;
		int endDay = 11;
		int startMonth = 3;
		int endMonth = 3;
		int startYear = 2016;
		int endYear = 2016;
		
		vacationTrackerSteps.setStartDate(startDay, startMonth, startYear);
		vacationTrackerSteps.setEndDate(endDay, endMonth, endYear);
		vacationTrackerSteps.checkIfEndDateEquals(startDay, startMonth, startYear);				
	}	
}
