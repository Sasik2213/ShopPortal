package sasiguides.ShopPortal.testingPart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullPro {
	public static void main(String[] args) throws InterruptedException{
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.cssSelector("#userEmail"))).sendKeys("bunny@gmail.com").build().perform();
		actions.click(driver.findElement(By.cssSelector("#userPassword"))).sendKeys("Bunny@123").build().perform();
		actions.click(driver.findElement(By.cssSelector("#login"))).build().perform();

	}
}
