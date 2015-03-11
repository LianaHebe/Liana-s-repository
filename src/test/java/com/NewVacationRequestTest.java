package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.LoginAndNavigationSteps;
import com.steps.NewVacationRequestSteps;
 
@Story(Application.Vacations.NewVacationRequestTest.class)
@RunWith(ThucydidesRunner.class)
public class NewVacationRequestTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
    public Pages pages;

    @Steps
    public LoginAndNavigationSteps loginAndNavigationSteps;
    
    @Steps
    public NewVacationRequestSteps newVacationRequestSteps;

    @Before
    public void signInUsernameAndPasswordAndGoToNewVacationRequest() {
        loginAndNavigationSteps.is_the_home_page();
		loginAndNavigationSteps.signInAsBasicUser();
		loginAndNavigationSteps.goToVacations();
		loginAndNavigationSteps.goToNewVacationRequest();
    }
    
    @Test
    public void selectVacationWithoutPayment(){
    	newVacationRequestSteps.selectVacationWithoutPayment();
    }
    

} 
