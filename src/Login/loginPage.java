package Login;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPage {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BL791HV\\eclipse-workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.findElement(By.id("username")).sendKeys("JAVA");
		driver.findElement(By.id("password")).sendKeys("java@123");
		driver.findElement(By.id("Login")).click();

		String actualError = driver.findElement(By.id("error")).getText();
		String errorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";

		if (actualError.equals(errorMsg)) {
			System.out.println("Test Case Passed");
		} else {
			System.out.println("Test Case Failed");
		}
		;

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sorc1 = screenshot.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("C:\\Users\\BL791HV\\eclipse-workspace\\SelenimJava\\screenshot\\login.png");
		FileUtils.copyFile(sorc1, dest1);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of links is " + links.size());
		driver.quit();
	}
}
