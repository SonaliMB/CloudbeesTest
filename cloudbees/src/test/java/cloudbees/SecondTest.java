package cloudbees;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Documents\\Sonali\\Softwares\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://github.com/SonaliMB/SimpleJavaExercises");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\":R55ab:\"]/span")).click();
		driver.findElement(By.xpath("//*[@class=\"octicon octicon-copy\"]")).click();
		driver.findElement(By.xpath("//*[@id=\":R55ab:\"]/span")).click();
		//Assumption: User has cloned the repo
		// Assumption: User is having write access to git repository
		//To Add a new file
		driver.findElement(By.xpath("//*[@id=\":R5b5ab:\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\":r51:--label\"]")).click();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter file name:");
		String fileName = sc.nextLine();
		System.out.println("Enter file content:");
		String content = sc.nextLine();
		driver.findElement(By.xpath("//*[@aria-label=\"File name\"]")).sendKeys(fileName);
		driver.findElement(By.xpath("//*[@class=\"cm-content\"]")).sendKeys(content);
		driver.findElement(By.cssSelector("span:contains('Commit changes...')"));
		
		//To update existing file
		
		System.out.println("Enter file name:");
		fileName = sc.nextLine();
		driver.findElement(By.xpath("//*[@aria-label=\"Go to file\"]")).sendKeys(fileName);
		driver.findElement(By.xpath("//*[@class=\"Box-sc-g0xbh4-0 kTgYii\"]")).click();
		driver.findElement(By.xpath("//*[@class=\"octicon octicon-pencil\"]")).click();
		System.out.println("Enter file content:");
		content = sc.nextLine();
		driver.findElement(By.xpath("//*[@class=\"cm-scroller\"]")).sendKeys(content);
		driver.findElement(By.cssSelector("span:contains('Commit changes...')"));
	}

}
