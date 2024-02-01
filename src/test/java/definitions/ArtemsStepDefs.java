package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ArtemsStepDefs {
    @Given("I navigate {string}")
    public void iNavigate(String url) {
        getDriver().navigate().to(url);
    }

    @Then("I have something")
    public void iHaveSomething() {
        System.out.println("This is my tests");
    }

    @Given("client open main page")
    public void clientOpenMainPage() {
        getDriver().get("https://nop-qa.portnov.com/");
    }

    @Then("main page title should be displayed")
    public void mainPageTitleShouldBeDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), 'Featured products')]/../..//a[contains(text(), 'HTC')]")).isDisplayed()).isTrue();
    }

    @When("client click {string} item")
    public void clientClickItem(String itemName) {
        String xpath = "//*[contains(text(), 'Featured products')]/../..//a[contains(text(), '"+itemName+"')]";
        getDriver().findElement(By.xpath(xpath)).click();
    }

    @Then("client should see reviews with at least {int} review")
    public void clientShouldSeeReviewsWithAtLeastReview(int numberOfreviews) {
        WebElement reviewNum = getDriver().findElement(By.xpath("//*[contains(text(), 'review(s)')]"));
        String[] parts = reviewNum.getText().split(" ");
        int reviews = Integer.parseInt(parts[0]);
        assertThat(reviews).isGreaterThanOrEqualTo(numberOfreviews);
    }

    @When("client set items quantity to {string}")
    public void clientSetItemsQuantityTo(String q) {
        WebElement quantity = getDriver().findElement(By.xpath("//input[@aria-label='Enter a quantity']"));
        quantity.clear();
        quantity.sendKeys(q);
    }

    @And("client click add to cart button")
    public void clientClickAddToCartButton() {
        getDriver().findElement(By.xpath("//div[contains(@class, 'overview')]//button[contains(text(), 'Add to cart')]")).click();
    }

    @Then("client should see added to cart notification")
    public void clientShouldSeeAddedToCartNotification() {
        WebElement notification = getDriver().findElement(By.xpath("//div[contains(@class, 'bar-notification')][contains(@class, 'success')]"));
        assertThat(notification.getText()).contains("added");
    }

    @When("client opens shopping cart")
    public void clientOpensShoppingCart() {
        getDriver().findElement(By.xpath("//a/span[contains(text(), 'Shopping cart')]")).click();
    }

    @Then("items total amount shoud be {string}")
    public void itemsTotalAmountShoudBe(String amount) {
        WebElement amt = getDriver().findElement(By.xpath("//td[contains(@class, 'subtotal')]/span"));
        assertThat(amt.getText()).contains(amount);
    }
}