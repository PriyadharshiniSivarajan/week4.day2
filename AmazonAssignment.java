package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro ");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("The price of first element is " + text);
		String text3 = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println("The total customer ratings is" + text3);
		Thread.sleep(2000);
		WebElement rating = driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(rating).perform();
		rating.click();
		String text2 = driver.findElement(By.xpath("//span[@data-hook='acr-average-stars-rating-text']")).getText();
		System.out.println("The average rating is" + text2);
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color')])[1]")).click();
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		List<String> newHandles = new ArrayList<String>(handles);
		driver.switchTo().window(newHandles.get(1));
		WebElement image = driver.findElement(By.xpath("//img[@data-a-image-name='landingImage']"));
		File src = image.getScreenshotAs(OutputType.FILE);
		File dst = new File("phone.png");
		FileUtils.copyFile(src, dst);
		Thread.sleep(2000);
		driver.findElement(By.id("add-to-cart-button")).click();
	    WebElement cartTotal = driver.findElement(By.id("attach-accessory-cart-subtotal"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElement(cartTotal, "49,999"));
		String text4 = cartTotal.getText();
		System.out.println(text4);
		if (text4.contains(text)) {
			System.out.println("Cart total verified" + text4);
		} else {
			System.out.println("Not verified");
		}

	}

}
