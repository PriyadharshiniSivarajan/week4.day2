package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggableAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions builder =new Actions(driver);
		builder.dragAndDropBy(draggable, 70, 70).perform();

	}

}
