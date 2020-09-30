package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuccessfulTransfer {
	WebDriver driver;
	
	@Given("^User is on transfer money page$")
	public void user_is_on_transfer_money_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/transfer");
		driver.manage().window().maximize();
	}

	@When("^User enters both the account numbers$")
	public void user_enters_both_the_account_numbers() throws Throwable {
		driver.findElement(By.name("fromaccountId")).sendKeys("12345");
		driver.findElement(By.name("toAccountId")).sendKeys("67892");
		driver.findElement(By.name("amt")).sendKeys("100");
		driver.findElement(By.xpath("//input[@class='button2 button']")).click();
	}

	@Then("^message displayed Your transaction was successful!$")
	public void message_displayed_Your_transaction_was_successful() throws Throwable {
	    Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='success']")).getText().equals("Your transaction was successful!")) {
			System.out.println("The transaction was successful");
		    driver.close();
		}
	}
}
