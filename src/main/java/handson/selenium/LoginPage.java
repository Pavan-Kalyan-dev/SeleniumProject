package handson.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
		//login form
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(5000);
		driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.xpath("//div[@class='inventory_item_name ']")).click();
		
		driver.findElement(By.id("add-to-cart")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='checkout']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='cancel']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
		
		
//		String text = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
//		System.out.println(text);
//		
		//Thread.sleep(2000);
		
		driver.close();
		

	}

}
