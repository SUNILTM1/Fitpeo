package StepDefinations;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartMobileVerificationStarting {
	WebDriver driver;
	static Set<String> allwindows;
	static Iterator<String> iterator;
	static String parent;
	@Given("open the website")
	public void open_the_website() {
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
		 driver=  new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://www.flipkart.com/");
	}

	@Given("enter the verify the phonenumber")
	public void enter_the_verify_the_phonenumber() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']/input[@type='text']")).sendKeys("7019502569");
		
		driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
		//OTP will genarate we have to enter the manually
		//the order is unable to place due to verifying the mobile number automatically
		Thread.sleep(10000);
		 driver.findElement(By.xpath("//button[text()='Verify']")).click();
	}

	@When("Search on the ipad")
	public void search_on_the_ipad() {
		WebElement Search = driver.findElement(By.xpath("//input[@type='text']"));
		Search.sendKeys("ipad");
		Search.sendKeys(Keys.ENTER);
	}

	@When("select the item and click on the buy now button")
	public void select_the_item_and_click_on_the_buy_now_button() {
		WebElement Search = driver.findElement(By.xpath("//input[@type='text']"));
		Search.sendKeys("ipad");
		Search.sendKeys(Keys.ENTER);
		parent=driver.getWindowHandle();
		  driver.findElement(By.xpath("//div[text()='APPLE iPad (9th Gen) 64 GB ROM 10.2 inch with Wi-Fi Only (Space Grey)']")).click();
		   allwindows=driver.getWindowHandles();
			for (String string : allwindows) {
			if (string!=null) {
				System.out.println(parent);
				 if (parent.equals(string)) {
					System.out.println(parent);
				} else {
					driver.switchTo().window(string);
				}
			}
			} 
		   driver.findElement(By.xpath("//button[text()='Buy Now']")).click();
		   driver.findElement(By.xpath("//button[text()='Deliver Here']")).click();
		    driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
		    driver.findElement(By.xpath("//button[text()='Accept & Continue']")).click();
		    driver.findElement(By.xpath("(//label[@for='COD']/div[contains(text(),'')])[1]")).click();
	}

	@Then("order should be placed")
	public void order_should_be_placed() {
		 
		System.out.println("the order is unable to place due to verifying the mobile number automatically");
	}

}
