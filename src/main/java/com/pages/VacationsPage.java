package com.pages;

import static ch.lambdaj.Lambda.convert;

import java.util.List;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ch.lambdaj.function.convert.Converter;

public class VacationsPage extends PageObject {

    @FindBy(id="_58_login")
    private WebElementFacade username;

    @FindBy(id="_58_password")
    private WebElementFacade password;

    @FindBy(css="[value='Sign In']")
    private WebElementFacade signIn;

   // @FindBy(xpath="//a[contains(@href,'new-request')]")
    @FindBy(css="a[href*='vacation']")
    private WebElementFacade vacationLink;
        
    public void enter_username(String user) {
        username.type(user);
    }
    
    public void enter_password(String pass) {
        password.type(pass);
    }
    
    public void clickSubmit() {
        signIn.click();
    }

    public void clickVacation(){
    	vacationLink.click();
    }
     
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("ol"));
        List<WebElement> results = definitionList.findElements(By.tagName("li"));
        return convert(results, toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}