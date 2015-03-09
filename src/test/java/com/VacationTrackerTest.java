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
import com.steps.EndUserSteps;

@Story(Application.Vacations.VacationTrackerTest.class)
@RunWith(ThucydidesRunner.class)
public class VacationTrackerTest {
	
	@Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
    public Pages pages;
    
    @Steps
    public EndUserSteps endUser;
	
    @Before
    public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
        endUser.is_the_home_page();
		endUser.signIn();
		endUser.goToVacations();
		endUser.goToVacationTracker();
    }
    
    @Test
    public void testStartDateLaterThanEndDate(){
    	
    }
	

}
