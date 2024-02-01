
package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import groovyjarjarpicocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Helper;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class GoogleSteps {
    private String url;

    @Given("I open url for {string}")
    public void iOpenUrlFor(String urlName) {
        url = Helper.getUrlFor(urlName);
        getDriver().get(Helper.getUrlFor(urlName));
    }

    @Then("I type {string} into {string}")
    public void iTypeInto(String text, String elementName) {
        getDriver().findElement(By.xpath(Helper.getXpathFor(elementName))).sendKeys(text);
    }


    @Then("I click {string}")
    public void iClick(String elementName) {
        getDriver().findElement(By.xpath(Helper.getXpathFor(elementName))).click();
    }

    @Then("I wait for {string} to be present")
    public void iWaitForToBePresent(String elementName) {
        new WebDriverWait(getDriver(), 10, 200)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .xpath(Helper.getXpathFor(elementName))));

    }

    @Then("{string} should contain text {string}")
    public void shouldContainText(String elementName, String text) {
        String actualText = getDriver().findElement(By.xpath(Helper.getXpathFor(elementName))).getText();
        assertThat(actualText).containsIgnoringCase(text);
    }

    @And("I check final result")
    public void iCheckFinalResult() {
        System.out.println(url);
        System.out.println(Helper.myVal);
    }
}