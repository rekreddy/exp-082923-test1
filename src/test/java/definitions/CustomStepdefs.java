package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.getDriver;

public class CustomStepdefs {
    @Given("client open web page")
    public void clientOpenWebPage() throws InterruptedException {
        getDriver().navigate().to("https://google.com");
        Thread.sleep(2000);
        WebElement searchBar = getDriver().findElement(By.xpath("//textarea[@name='q']"));
        searchBar.sendKeys("Portnov");
        searchBar.sendKeys(Keys.RETURN);
        Thread.sleep(1000);
        getDriver().navigate().back();
        Thread.sleep(1000);
        getDriver().navigate().forward();
        Thread.sleep(1000);
        getDriver().navigate().refresh();
        Thread.sleep(1000);
    }

    @Given("client open portnov web page")
    public void clientOpenPortnovWebPage() {
        getDriver().get("https://portnov.com");
    }

    @Then("client set browser size to mobile")
    public void clientSetBrowserSizeToMobile() {
        getDriver().manage().window().setSize(new Dimension(980, 600));
        WebElement headerBar = getDriver().findElement(By.xpath("//div[@id='header-bar-desktop']"));
        boolean headerBarDisplayed = headerBar.isDisplayed();
        assertThat(headerBarDisplayed).isFalse();

    }

    @Given("client open test url for the form")
    public void clientOpenTestUrlForTheForm() {
        getDriver().get("https://testautomationpractice.blogspot.com/2018/09/automation-form.html");

    }

    @And("I type {string} into all input fields")
    public void iTypeIntoAllInputFields(String inputString) {
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//input[@type='text']"));
        for (WebElement we : webElementList) {
            we.sendKeys(inputString);
        }
    }
}