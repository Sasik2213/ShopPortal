package sasiguidess;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		
		Actions actions = new Actions(driver);
	actions.click(driver.findElement(By.xpath("//input[@id='userEmail']"))).sendKeys("sasikiran2213@gmail.com")
				.build().perform();
		actions.click(driver.findElement(By.xpath("//input[@id='userPassword']"))).sendKeys("Sasikiran@2213").build()
			.perform();
		actions.click(driver.findElement(By.xpath("//input[@id='login']"))).build().perform();

		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = products.stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		waits.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
	List<WebElement>cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	boolean match=cartProducts.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(productName));

	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	waits.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();
	

		

	}
}