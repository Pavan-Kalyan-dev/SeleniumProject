package handson.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.WebElement;

public class TicketBooking {

	public static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	// select Date method declaration
	public static void selectDate(WebDriver driver, String year, String month, String date) {
		// select year

		WebElement webyear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

		Select year_drop = new Select(webyear);

		year_drop.selectByVisibleText(year);

		// select month

		WebElement webmonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select month_drop = new Select(webmonth);
		month_drop.selectByVisibleText(month);
		sleep(3000);
		// select date
		List<WebElement> allDates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		// foreach loop
		sleep(3000);
		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}

//	public static void selectDepatureMethod(WebDriver driver,String year1,String month1,String date1) {
//		//select year
//		
//				WebElement ele1 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year' and @data-handler='selectYear']"));
//				
//				Select year_drop1=new Select(ele1);
//				sleep(3000);
//				//year_drop1.selectByVisibleText(year1);
//				
//				//select month
//				
//				WebElement webmonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
//				Select month_drop=new Select(webmonth);
//				//month_drop.selectByVisibleText(month1);	
//				sleep(3000);
//				//select date
//				List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
//				
//				//foreach loop
//				sleep(3000);
//				for(WebElement dt:allDates) {
//		      			if(dt.getText().equals(date1)) {
//		      				dt.click();
//		      				break;
//		      			}
//				}
//	}

	public static void main(String[] args) {

//		String year="2023";
//		String month="Mar";
//		String date="24";

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.dummyticket.com/");
		sleep(3000);
		driver.findElement(By.linkText("Buy Ticket")).click();

		driver.findElement(By.id("product_549")).click();

		sleep(3000);
		// driver.close();

		driver.findElement(By.xpath("//input[@name='travname']")).sendKeys("Pavan");
		driver.findElement(By.xpath("//input[@name='travlastname']")).sendKeys("Kalyan");
		driver.findElement(By.xpath("//input[@id='dob']")).click();

		// select method calling
		selectDate(driver, "1999", "Mar", "24");

		// let's select gender
		// male
		WebElement male = driver.findElement(By.xpath("//input[@id='sex_1']"));
		male.click();
		System.out.println("Male is selected: " + male.isSelected());
		// female
		WebElement female = driver.findElement(By.xpath("//input[@id='sex_2']"));
		System.out.println("female is selected: " + female.isSelected());

		// let's give travel details

		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("Kurnool");
		String x = "2024";
		String y = "Jun";
		String z = "16";

		// selectDepatureMethod(driver,x,y,z);

		// Delivery options

		WebElement element = driver.findElement(By.xpath("//select[@id='reasondummy']"));

		Select sc = new Select(element);

		sc.selectByIndex(0);

		sleep(2000);

		sc.selectByValue("2");

		// selecting the email

		driver.findElement(By.xpath("//input[@id='deliverymethod_1']")).sendKeys("ahahaja");
		driver.findElement(By.xpath("//input[@id='billname']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("ahahaja@gmail.com");
		driver.findElement(By.xpath("//input[@id='deliverymethod_1']")).sendKeys("ahahaja");

		// select country

		WebElement country = driver.findElement(By.xpath("//select[@id='billing_country']"));

		Select sc1 = new Select(country);

		sc.selectByIndex(0);
		sleep(2000);

		sc.selectByValue("2");
		
		
		//street address
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("ahahaja");
		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("ahahaja@gmail.com");
		
		
		WebElement countryes = driver.findElement(By.xpath("//select[@id='billing_state']"));

		Select sc2 = new Select(countryes);

		sc.selectByIndex(0);
		sleep(2000);

		sc.selectByValue("2");
		
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("ahahaja");
		//driver.findElement(By.xpath("//input[@id='deliverymethod_1']")).sendKeys("ahahaja");
		
		driver.close();
		

	}

}
