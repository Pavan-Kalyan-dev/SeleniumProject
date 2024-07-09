package handson.selenium;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoking_browser {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts();
		driver.get("https://www.saucedemo.com");
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		driver.close();

	}

}
