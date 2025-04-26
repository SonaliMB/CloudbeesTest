package cloudbees;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class FirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\Sonali\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.cloudbees.com/");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		//driver.manage().addCookie(new Cookie(null, null));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Products']")).click();
		driver.findElement(By.xpath("//*[@id=\"subcategory-item-0__CloudBees CD/RO\"]")).click();
		
		WebElement knownElement = driver.findElement(By.xpath("//*[@data-test=\"stat.preTitle\"]"));
		
		WebElement toBeVerifiedElement = driver.findElement(RelativeLocator.with(By.tagName("span")).below(knownElement));
		String str = toBeVerifiedElement.getText();
		Assert.assertEquals("$2m", str, "The values do not match!");
		List <WebElement> labels = driver.findElements(By.xpath("//*[@data-test=\"button-label\"]"));
		WebElement expectedLabel=labels.get(0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", expectedLabel);
		for(WebElement label:labels) {
			if(label.getText().equals("Auditors / Security")) {
				System.out.println("label is:"+label.getText());
				expectedLabel = label;
				break;
			}
		}
		
		System.out.println("Scrolled down till expected label");
        expectedLabel.click();
        
        List<WebElement>knownElements = driver.findElements(By.xpath("//*[@data-test=\"headerContent.preTitle\"]"));
        for(WebElement label:knownElements) {
			if(label.getText().equals("Release Governance")) {
				System.out.println("label is:"+label.getText());
				expectedLabel = label;
				break;
			}
		}
        js.executeScript("arguments[0].scrollIntoView(true);", expectedLabel);
        toBeVerifiedElement = driver.findElement(RelativeLocator.with(By.tagName("h4")).below(expectedLabel));
        Assert.assertEquals(toBeVerifiedElement.getText(), "Generate single-click audit reports","Information do not match!");
        
        driver.findElement(By.xpath("//button[text()='Resources']")).click();
        WebElement linkElement = driver.findElement(By.linkText("Documentation"));
        
        String originalWindow = driver.getWindowHandle();

        linkElement.click();
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        String newTab = "";
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                newTab = handle;
                break;
            }
        }
	}

}
