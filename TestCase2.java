package marathan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		//01) Launch the Browser
		ChromeDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		//02) Load the Url "https://www.amazon.in/"
		driver.get("https://www.amazon.in/");

		//03) Type "Bags for boys" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys" , Keys.ENTER);
		
		Thread.sleep(3000);
		//04) Choose the item in the result (bags for boys)
		
		
		//05) Print the total number of results (like 50000)
		 //  example like this-----> 1-48 of over 50,000 results for "bags for boys"
		
		String totalNumber = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none s-breadcrumb-header-text']")).getText();
		
		System.out.println("The Total Number of results are : "  + totalNumber);
		
		//06) Select the first 2 brands in the left menu
	    //(like American Tourister, Generic)
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Safari'])[3]")).click();
		Thread.sleep(3000);
		WebElement list = driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left'])[2]"));
		driver.executeScript("arguments[0].click();", list);
		//07) Choose New Arrivals (Sort)  //i[@class='a-icon a-icon-dropdown']
		Thread.sleep(3000);
		WebElement downArrow = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		driver.executeScript("arguments[0].click();", downArrow);
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		
		//08) Print the first resulting bag info (name, discounted price)
		Thread.sleep(3000);
		String name = driver.findElement(By.xpath("(//span[contains(text(),'Boys and Girls')])[1]")).getText();
		String price = driver.findElement(By.xpath("//span[@class='a-price']")).getText();
		System.out.println("Bag name: " + name   + " Price is :  "  + price);
		
		Thread.sleep(3000);
		//09) Get the page title and close the browser(driver.close())
		String title = driver.getTitle();
		System.out.println("The Title of the Web Page : " + title);
		//driver.close();
		
	}

}
