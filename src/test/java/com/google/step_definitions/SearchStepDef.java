package com.google.step_definitions;

import com.google.pages.HomePage;
import com.google.pages.SearchResultsPage;
import com.google.pages.WikipediaPage;
import com.google.utilities.BrowserUtils;
import com.google.utilities.ConfigurationReader;
import com.google.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class SearchStepDef {

    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    WikipediaPage wikipediaPage = new WikipediaPage();

    @Given("que estoy en la página de inicio de búsqueda de Google")
    public void que_estoy_en_la_página_de_inicio_de_búsqueda_de_google() {

        Driver.getDriver().get(ConfigurationReader.get("url"));
        BrowserUtils.waitForClickablility(homePage.acceptCookies, 10).click();
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Google"));
    }
    @When("busco la palabra {string}")
    public void busco_la_palabra(String palabra) {
        BrowserUtils.waitForClickablility(homePage.searchInputBox, 10).sendKeys(palabra);
        homePage.searchInputBox.sendKeys(Keys.ENTER);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(palabra));
        Assert.assertEquals(searchResultsPage.searchKeywordHeader.getText().toLowerCase(), palabra);
    }
    @When("hago clic en el enlace de Wikipedia de los resultados de búsqueda")
    public void hago_clic_en_el_enlace_de_wikipedia_de_los_resultados_de_búsqueda() {
        BrowserUtils.clickWithJS(searchResultsPage.wikipediaLink);
    }

    @Then("veo que el primer proceso automático se realizó en {string}")
    public void veoQueElPrimerProcesoAutomáticoSeRealizóEn(String año) throws IOException {
        BrowserUtils.getScreenshot("Wikipedia");
        Assert.assertTrue(BrowserUtils.waitForVisibility(wikipediaPage.contentText, 10).getText().contains(año));
    }
}
