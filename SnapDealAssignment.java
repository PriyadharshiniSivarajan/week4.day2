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

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.snapdeal.com/");
		WebElement menFashion = driver.findElement(By.xpath("(//span[@class='catText'])[6]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(menFashion).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String text = driver.findElement(By.xpath("//span[@class='category-count']")).getText();
		System.out.println("The total shoes count" + text);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();

		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();

		String text2 = driver.findElement(By.className("sort-selected")).getText();
		System.out.println(text2);
		if (text2.contains("Low To High")) {
			System.out.println("Sort verified" + text2);
		}
		WebElement low = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
		low.clear();
		low.sendKeys("900");
		WebElement high = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		high.clear();
		high.sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn ')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
		String text3 = driver.findElement(By.xpath("(//a[@data-key='Price|Price'])[1]")).getText();
		String text4 = driver.findElement(By.xpath("(//a[@data-key='Color_s|Color'])[1]")).getText();
		if(text3.contains("900 - Rs. 1200"))
		{
			System.out.println("Price verified");
		}
		if(text4.contains("Navy"))
		{
			System.out.println("Colour Verified");
		}
		WebElement image = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		builder.moveToElement(image).perform();
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar  ')]")).click();	
		String text5 = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("The price of shoe is "+text5);
		String text6 = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		
		System.out.println("The discount percent is "+text6);
		
		WebElement shoeSnap = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
		Thread.sleep(2000);
		File src = shoeSnap.getScreenshotAs(OutputType.FILE);
		File dst= new File("screenshot5.png");
		FileUtils.copyFile(src, dst);
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.close();
	
}
}



/*WebElement slider1 = driver.findElement(By.xpath("//div[@data-min='439']/a"));

builder.dragAndDropBy(slider1, 55, 0).perform();
WebElement slider2 = driver.findElement(By.xpath("//div[@data-min='439']/a[2]"));
Thread.sleep(2000);
builder.dragAndDropBy(slider2, -109, 0).perform();
Thread.sleep(2000);
driver.findElement(By.xpath("//label[@for='Color_s-Black']")).click();
WebElement image = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
builder.moveToElement(image).perform();
driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar  ')]")).click();
String text3 = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]")).getText();
String text4 = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[2]")).getText();
if(text4.contains("Black"))
{
	System.out.println("COlour filter verified"+text4);
}
}
*/