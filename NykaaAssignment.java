package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.nykaa.com/");
		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions action = new Actions(driver);
		action.moveToElement(brand).perform();
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		Thread.sleep(2000);
		WebElement category = driver.findElement(By.xpath("//span[@title='POPULARITY']"));
		category.click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("(//div[@class='control__indicator'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(2000);
		WebElement filterCheck = driver.findElement(By.xpath("//li[text()='Color Protection']"));
		String str = "Color Protection";
		String text = filterCheck.getText();
		if (text.contains("Color Protection"))

		{
			System.out.println("The filter is " + str);
		}
		driver.findElement(By.xpath("(//img[@class='listing-img'])[1]")).click();
		Set<String> handle = driver.getWindowHandles();
		List<String> listHandle = new ArrayList<String>(handle);
		driver.switchTo().window(listHandle.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='360ml']")).click();
		String text2 = driver.findElement(By.xpath("(//span[@class='post-card__content-price-offer'])[1]")).getText();
		System.out.println("The price of product is" + text2);
		driver.findElement(By.xpath("//div[@class='pull-left']//button")).click();
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		Thread.sleep(2000);
		/* driver.findElement(By.xpath("//button[@class='btn full fill']")).click(); */
		String text3 = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		System.out.println("The grand total is"+text3);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		String text4 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		if(text3.contains(text4))
		{
			System.out.println("total verified");
		}
		int size = handle.size();
		for(int i=0;i<size;i++)
			{
			driver.switchTo().window(listHandle.get(i));
			driver.close();
			}
			}
}
