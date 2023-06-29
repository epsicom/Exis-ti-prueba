package com.google.step_definitions;

import com.google.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    Driver driver;

    @Before
    public void setUp(){
        driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quitDriver();
    }
}
