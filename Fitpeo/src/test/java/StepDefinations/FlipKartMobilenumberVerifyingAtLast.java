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

public class FlipKartMobilenumberVerifyingAtLast {
	WebDriver driver;
	static Set<String> allwindows;
	static Iterator<String> iterator;
	static String parent;
@Given("open the fli[kart application")
public void open_the_fli_kart_application() {
	System.setProperty("webdriver.chrome.driver","src\\test\\resources\\drivers\\chromedriver.exe");
	 driver=  new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://www.flipkart.com/");
	 driver.findElement(By.xpath("//button[text()='✕']")).click();
}

@When("search on the ipad")
public void search_on_the_ipad() {
	WebElement Search = driver.findElement(By.xpath("//input[@type='text']"));
	Search.sendKeys("ipad");
	Search.sendKeys(Keys.ENTER);
}

@When("click on the buy nnow button and plce the order")
public void click_on_the_buy_nnow_button_and_plce_the_order() {
	 
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
	   
}
 

@Then("verify the order")
public void verify_the_order() {
     System.out.println("the order is unable to place due to verifying the mobile number automatically");
}

}
