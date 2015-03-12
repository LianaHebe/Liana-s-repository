package com;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import com.requirements.Application;
import com.steps.LoginAndNavigationSteps;
import com.steps.VacationTrackerSteps;

@Story(Application.Vacations.VacationTrackerTest.class)
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
	
    @Before
    public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
        loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsDM();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToVacationTracker();
		webdriver.manage().window().maximize();
    }
    
    @Test
    public void testStartDateLaterThanEndDate(){
//    	System.out.println("Setting start date to May 21, 2013. Check if correct.");
    	vacationTrackerSteps.setStartDate(3, 7, 2);
    	try {
			Thread.sleep(5000L);
		} catch (Exception e) {
		}    	
    }
}
