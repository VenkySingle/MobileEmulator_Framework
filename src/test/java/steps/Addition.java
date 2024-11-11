package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import pages.MainPage;
import utilities.DriverManager;
import utilities.GenericMethods;

public class Addition {
	
	private AndroidDriver<MobileElement> driver;
	MainPage mpage;
	GenericMethods generals;
	
	public Addition()
	{
		this.driver = utilities.DriverManager.getDriver();
		mpage = new MainPage(driver);
		generals = new GenericMethods(driver);
	}

	@Given("Verify app is Launched")
	public void verify_app_is_launched() {
	  mpage.verifyapplaunch();
	  
	}

	@Given("Enter First number {string}")
	public void enter_first_number(String number) {
	  mpage.EnterNumber(number);
	}

	@Given("Enter Operator as {string}")
	public void enter_operator_as(String string) {
	    mpage.clickOperator(string);
	}

	@Given("Enter Second number {string}")
	public void enter_second_number(String number) {
		 mpage.EnterNumber(number);
	}

	@When("Operator is given as {string}")
	public void operator_is_given_as(String string) {
		mpage.clickOperator(string);
	}

	@Then("Result should be calculated and assertion was done with {string} and {string}")
	public void result_should_be_calculated_and_assertion_was_done_with_and(String num1, String num2) {
	    mpage.finalResultCalculation(num1, num2);
	    DriverManager.tearDown();
	    
	}

	
	
}
