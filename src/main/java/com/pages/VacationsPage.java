package com.pages;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

public class VacationsPage extends PageObject {

    @FindBy(id="_58_login")
    private WebElementFacade username;

    @FindBy(id="_58_password")
    private WebElementFacade password;

    @FindBy(css="[value='Sign In']")
    private WebElementFacade signIn;
    
    public void enter_username(String user) {
        username.type(user);
    }
    
    public void enter_password(String pass) {
        password.type(pass);
    }
    
    public void clickSubmit() {
        signIn.click();
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