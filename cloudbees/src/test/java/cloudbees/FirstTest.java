package cloudbees;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\Sonali\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.cloudbees.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Products']")).click();
		WebElement cs = driver.findElement(By.xpath("//*[@id=\"subcategory-item-0__CloudBees CD/RO\"]"));
		String str = cs.getText();
	}

}
