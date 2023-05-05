package com.demoqa.step_definitions;

import com.demoqa.pages.AccordianPage;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccordianStepsDefs {

    public String baseUrl = ConfigurationReader.getProperty("baseUrl");
    AccordianPage accordianPage= new AccordianPage();


    @Given("Navigate to {string} page")
    public void navigate_to_page(String path) {
    //Driver.getDriver()--> giving me a Singleton Driver object
    Driver.getDriver().get(baseUrl+path);
    }

    @When("click {string} accordion")
    public void click_accordion(String number) throws InterruptedException {
//accordianPage.accordionTwo.click(); ---> this does not use parameter from feature
accordianPage.selectAccordion(number).click();
Thread.sleep(3);

    }


    @Then("verify class text is {string} for {string}")
    public void verifyClassTextIsFor(String stateOfAccordian, String number) {


    String collapsedInfo = accordianPage.getCollapsedInfoForAccordion(number).getAttribute("class");
        System.out.println(collapsedInfo);
        if(stateOfAccordian.equalsIgnoreCase("open")) {
            Assert.assertEquals("collapse show", collapsedInfo);
        }else if (stateOfAccordian.equalsIgnoreCase("close")) {
    Assert.assertEquals("collapse", collapsedInfo);
        }
    }


}

