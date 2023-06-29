package com.google.pages;

import com.google.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    public SearchResultsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Automatización")
    public WebElement wikipediaLink;

    @FindBy(xpath = "//h2[@data-attrid='title']")
    public WebElement searchKeywordHeader;
}
