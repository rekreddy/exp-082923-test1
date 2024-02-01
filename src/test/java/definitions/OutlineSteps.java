
package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class OutlineSteps {
    @Then("I enter {string} into the field with xpath {string}")
    public void iEnterFullnameIntoTheFieldWithXpath(String text, String xpath) {
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }
}