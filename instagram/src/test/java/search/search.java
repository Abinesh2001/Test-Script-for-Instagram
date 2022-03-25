package search;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class search 
{
	WebDriver driver;
  @Test
  public void search() throws InterruptedException 
  {
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  WebElement un=driver.findElement(By.name("username"));
	  un.sendKeys("abi_nesh2001_01_28");
	  WebElement pw=driver.findElement(By.name("password"));
	  pw.sendKeys("Abinesh@1234");
	  
	  WebElement lgin=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]"));
	  lgin.click();
	  
	  driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[2]")).click();
	  
	  //search 
	  WebElement search=driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/nav[1]/div[2]/div[1]/div[1]/div[2]/input[1]"));
	  search.sendKeys("__t_h_e__c.o.p.y_ninja_");
	  
	  driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/nav[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
      driver.findElement(By.xpath("//div[contains(text(),'Follow')]")).click(); 
      
      //search2
      search.clear();
      search.sendKeys("edubridgelearn");
      driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/nav[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]")).click();
    //  driver.findElement(By.xpath("//div[contains(text(),'Follow')]")).click();
      
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
