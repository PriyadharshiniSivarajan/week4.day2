package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReziableAssignment {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement resizable = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle')][3]"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(resizable, 100, 80).perform();
	}

}
