package com;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

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

//	@Before
	public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
		loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsDM();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToVacationTracker();
		webdriver.manage().window().maximize();
	}

	// @Test
	public void testStartDateLaterThanEndDate() {
		// Decode the parameters from the dateSet.csv file.
		int dayInt = Integer.decode(dayString).intValue();
		int monthInt = Integer.decode(monthString).intValue();
		int yearInt = Integer.decode(yearString).intValue();
		// Set the date according to the parameters from dateSet.csv.
		vacationTrackerSteps.setStartDate(dayInt, monthInt, yearInt);
		try {
			Thread.sleep(3000L);
		} catch (Exception e) {
		}
	}

	@Test
	public void unrelatedHTTPRequestTest() {
		String url = "http://www.google.com/search";
		String charset = "UTF-8"; // Or in Java 7 and later, use the constant:
									// java.nio.charset.StandardCharsets.UTF_8.name()
		String param1 = "pretty";
		String param2 = "girls";
		String query = null;
		URLConnection connection = null;
		InputStream response = null;
		int readData=-1;
		
		try {
			query = String.format("%s+%s",
					URLEncoder.encode(param1, charset),
					URLEncoder.encode(param2, charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			connection = new URL(url + "?q=" + query).openConnection();
//			connection = new URL(url + param1 + "%20" + param2).openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		connection.setRequestProperty("Accept-Charset", charset);
		try {
			response = connection.getInputStream();
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		try {
			response = new URL(url).openStream();
		} catch (MalformedURLException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(response);
		do {
			try {
				readData=bufferedInputStream.read();
				System.out.print(readData);
			} catch (IOException e) {
				e.printStackTrace();
			}			
		} while (readData!=-1);
		
		try {
			bufferedInputStream.close();
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

//		WebDriver driverForHTTPReq = new FirefoxDriver();

	}
}
