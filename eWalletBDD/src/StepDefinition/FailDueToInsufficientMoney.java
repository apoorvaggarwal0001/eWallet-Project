package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FailDueToInsufficientMoney {
	WebDriver driver;
	
	@Given("^User is at the transfer your money here page$")
	public void user_is_at_the_transfer_your_money_here_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumSoftware\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4200/transfer");
		driver.manage().window().maximize();
	}

	@When("^person enters correct account numbers but has insufficient money$")
	public void person_enters_correct_account_numbers_but_has_insufficient_money() throws Throwable {
		driver.findElement(By.name("fromaccountId")).sendKeys("12345");
		driver.findElement(By.name("toAccountId")).sendKeys("67892");
		driver.findElement(By.name("amt")).sendKeys("1000000");
		driver.findElement(By.xpath("//input[@class='button2 button']")).click();
	}

	@Then("^error message is displayed saying insufficient balance$")
	public void error_message_is_displayed_saying_insufficient_balance() throws Throwable {
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='error']")).getText().equals("Insufficient Balance")) {
			System.out.println("The Insufficient Balance message is displayed");
		    driver.close();
		}
	}
}
