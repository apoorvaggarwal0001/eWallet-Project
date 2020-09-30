package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UnsuccessDueToWrongAccountNumber {
	WebDriver driver;
	
	@Given("^User is on money transfer page$")
	public void user_is_on_money_transfer_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/transfer");
		driver.manage().window().maximize();
	}

	@When("^User enters invalid account number and other things correct$")
	public void user_enters_invalid_account_number_and_other_things_correct() throws Throwable {
		driver.findElement(By.name("fromaccountId")).sendKeys("1234");
		driver.findElement(By.name("toAccountId")).sendKeys("67892");
		driver.findElement(By.name("amt")).sendKeys("100");
		driver.findElement(By.xpath("//input[@class='button2 button']")).click();
	}

	@Then("^invalid account message is displayed$")
	public void invalid_account_message_is_displayed() throws Throwable {
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='error']")).getText().equals("Invalid Account")) {
			System.out.println("The invalid account message is displayed");
		    driver.close();
		}
	}
}
