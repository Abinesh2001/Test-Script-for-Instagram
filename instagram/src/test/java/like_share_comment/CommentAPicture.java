package like_share_comment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CommentAPicture
{
	WebDriver driver;
  @Test
  public void comment() throws InterruptedException 
  {
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  WebElement un=driver.findElement(By.name("username"));
	  un.sendKeys("abi_nesh2001_01_28");
	  WebElement pw=driver.findElement(By.name("password"));
	  pw.sendKeys("Abinesh@1234");
	  
	  WebElement lgin=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]"));
	  lgin.click();
	  
	  driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
	  driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[2]")).click();
	  
	  //to perform Scroll on application using Selenium
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.scrollBy(0,550)", "");
	  
	  driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/main[1]/section[1]/div[1]/div[3]/div[1]/article[1]/div[1]/div[3]/div[1]/div[1]/section[1]/span[2]/button[1]")).click();
	  WebElement comment=driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[3]/div[1]/form[1]/textarea[1]"));
	  comment.sendKeys("awesome");
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[3]/div[1]/form[1]/div[1]")).click();
	  Thread.sleep(3000);
	 
	  driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[3]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[3]/div[1]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/article[1]/div[1]/div[2]/div[1]/div[1]/div[2]/section[3]/div[1]/form[1]/button[1]")).click();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/");
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}
