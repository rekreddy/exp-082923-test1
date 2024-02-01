//package definitions;
//
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import static org.assertj.core.api.Assertions.*;
//
//import static support.TestContext.getDriver;
//
//public class QuoteHwSteps {
//    @Given("I visit Quote Page in the {string} Environment")
//    public void iVisitQuotePageInTheEnvironment(String environmentName) {
//        if (environmentName.equals("QA")) {
//            getDriver().get("http://quote-stage.portnov.com");
//        } else {
//            System.out.println("Environment " + environmentName +" not supported.");
//        }
//    }
//
//    @When("I enter {string} for the Username field")
//    public void iEnterForTheUsernameField(String username) {
////        getDriver().findElement(By.xpath("//*[@name='username']")).sendKeys(username);
//
//        String xpath = "//*[@name='username']";
//        WebElement usernameField = getDriver().findElement(By.xpath(xpath));
//        usernameField.sendKeys(username);
//    }
//
//
//    @And("I enter {string} for first name and {string} for the last name in the Name field")
//    public void iEnterForFirstNameAndForTheLastNameInTheNameField(String firstName, String lastName) {
//        String xpath = "//*[@name='name']";
//        getDriver().findElement(By.xpath(xpath)).sendKeys(firstName + " " + lastName);
//    }
//
//    @And("I enter {string} for the Email field")
//    public void iEnterForTheEmailField(String email) {
//        String xpath = "//*[@name='email']";
//        getDriver().findElement(By.xpath(xpath)).sendKeys(email);
//    }
//
//    @When("I enter {string} for the Password field")
//    public void iEnterForThePasswordField(String password) {
//        String xpath = "//*[@name='password']";
//        getDriver().findElement(By.xpath(xpath)).sendKeys(password);
//    }
//
//
//    @And("I enter {string} for the Confirm Password field")
//    public void iEnterForTheConfirmPasswordField(String confirmPassword) {
//        String xpath = "//*[@name='confirmPassword']";
//        getDriver().findElement(By.xpath(xpath)).sendKeys(confirmPassword);
//    }
//
//    @Then("I {string} the Privacy Policy Policy checkbox")
//    public void iThePrivacyPolicyPolicyCheckbox(String check) {
//        String xpath = "//*[@name='agreedToPrivacyPolicy']";
//        WebElement agreeCheckbox = getDriver().findElement(By.xpath(xpath));
//        agreeCheckbox.click();
//
////        if (agreeCheckbox.getAttribute("checked") != null) {
////            System.out.println("Checked");
////        }
//
////        if (agreeCheckbox.isSelected()) {
////            System.out.println("Checked");
////        }
//    }
//
//
//    @When("I click on the {string} button at the bottom of the page")
//    public void iClickOnTheButtonAtTheBottomOfThePage(String submit) {
//        String xpath = "//*[@name='formSubmit']";
//        getDriver().findElement(By.xpath(xpath)).click();
//    }
//
//
//    @Then("I verify we see the Submitted Application Page")
//    public void iVerifyWeSeeTheSubmittedApplicationPage() {
//        String xpath = "//legend[contains(text(), 'Submitted Application')]";
//        WebElement title = getDriver().findElement(By.xpath(xpath));
//        assertThat(title.isDisplayed()).isTrue();
//    }
//}