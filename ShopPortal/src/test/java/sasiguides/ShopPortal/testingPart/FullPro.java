package sasiguides.ShopPortal.testingPart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FullPro {
	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		Actions actions = new Actions(driver);
		actions.click(driver.findElement(By.cssSelector("#userEmail"))).sendKeys("bunny@gmail.com").build().perform();
		actions.click(driver.findElement(By.cssSelector("#userPassword"))).sendKeys("Bunny@123").build().perform();
		actions.click(driver.findElement(By.cssSelector("#login"))).build().perform();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector(".card-body b")).getText().equals(productName))
				.findFirst().orElse(null);
		actions.click(prod.findElement(By.cssSelector(".card-body button:last-child"))).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		boolean match=cartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		

	}
}
