package marathan;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		//1) Launch the Browser
		ChromeDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		//2) Load the Url "https://www.pvrcinemas.com/"
		driver.get("https://www.pvrcinemas.com/");
		
		//3) Choose Your location as "Chennai" (sometimes it will be located automatically)
		driver.findElement(By.xpath("(//div[@class='cities-overlay cities-active'])[6]/following-sibling::h6")).click();
		System.out.println("City as Chennai  Selected successfully ");
		
		//4) Click on Cinema under Quick Book
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		System.out.println("Cinenma is selected under Quick Book ");
		
		//5) Select Your Cinema
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='INOX National,Virugambakkam Chennai']")).click();
		
		System.out.println("Selected my Cinema to Book ");
		Thread.sleep(3000);
		//6) Select Your Date as Tomorrow
		driver.findElement(By.xpath("//span[text()='Select Date']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]"));
		driver.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		//7) Select Your Movie
		driver.findElement(By.xpath("//span[text()='Select Movie']")).click();
		driver.findElement(By.xpath("(//ul[@role='listbox'])/li[2]")).click();
		
		//8) Select Your Show Time
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Select Timing']")).click();
		driver.findElement(By.xpath("(//span[text()='12:15 PM'])")).click();
		
		//9) Click on Book Button 
		
		driver.findElement(By.xpath("(//div[@class='quick-lefts '])/button")).click();
		
		
		//10) Click Accept on Term and Condition
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		
		//11) Click any one available seat
		driver.findElement(By.xpath("//span[@id='SL.SILVER|M:13']")).click();
		
		//12) Click Proceed Button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//13) Print the Seat info under book summary
		Thread.sleep(3000);
		String seat = driver.findElement(By.xpath("//div[@class='seat-number']/p")).getText();
		System.out.println("The Seat Information under Book Summary is : " + seat );
		
		//14) Print the grand total under book summary
		Thread.sleep(3000);
		String total = driver.findElement(By.xpath("//div[@class='all-grand']//span")).getText();
		System.out.println("The Grand Total under Book summary is " + total );
		
		//15) Click Proceed and Continue Button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		//16) Close the popup
		driver.findElement(By.xpath("//i[@class='pi pi-times'])[2]")).click();
		
		//17) Print Your Current Page title
		System.out.println("Current Page Title is : " + driver.getTitle());
	
		//18) Close Browser
		
		driver.quit();
		

	}

}
