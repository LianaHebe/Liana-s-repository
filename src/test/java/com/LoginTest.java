package com;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.requirements.Application;
import com.steps.EndUserSteps;

@Story(Application.Search.Login.class)
@RunWith(ThucydidesRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://192.168.1.68:9090/login")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    /*@Issue("#WIKI-1")
    @Test
    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
        endUser.is_the_home_page();
		endUser.looks_for("ana");
   //     endUser.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");
    }*/

    /*@Test
    public void searching_by_username() {
        endUser.is_the_home_page();
		endUser.looks_for("ana");		
    }*/
    
    @Test
    public void signInUsernameAndPassword() {
        endUser.is_the_home_page();
		endUser.signIn("Mihaela","training1");		
    }
} 