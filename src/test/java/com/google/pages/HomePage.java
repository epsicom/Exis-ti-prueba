package com.google.pages;

import com.google.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "APjFqb")
    public WebElement searchInputBox;

    @FindBy(id="L2AGLb")
    public WebElement acceptCookies;
}
