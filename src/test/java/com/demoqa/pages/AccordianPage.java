package com.demoqa.pages;

import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccordianPage extends BasePage {


    // if you were only testing the second one
    @FindBy(id = "section2Heading")
    public WebElement accordionTwo;

    public WebElement selectAccordion(String  number) {
        String locator = "#section"+number+"Heading";
        return Driver.getDriver().findElement(By.cssSelector(locator));
    }

       public WebElement getCollapsedInfoForAccordion(String number){
        String locator = "//div[@id='section"+number+"Content']/..";
        return Driver.getDriver().findElement(By.xpath(locator));
    }

}

