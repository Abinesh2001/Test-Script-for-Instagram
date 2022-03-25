package profile;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class profile 
{
	WebDriver driver;
  @Test
  public void profile() throws InterruptedException 
  {
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  // login 
	  WebElement un=driver.findElement(By.name("username"));
	  un.sendKeys("abi_nesh2001_01_28");
	  WebElement pw=driver.findElement(By.name("password"));
	  pw.sendKeys("Abinesh@1234");
	  WebElement lgin=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]"));
	  lgin.click();
	  
	  //click on popup
	  driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
	//  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[2]")).click();
      
	  //click on profile
	  driver.findElement(By.xpath("//body/div[@id='react-root']/section[1]/nav[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[6]/span[1]/img[1]")).click();
	  driver.findElement(By.xpath("//div[contains(text(),'Profile')]")).click();
	  //click onedite profile
	  driver.findElement(By.xpath("//a[contains(text(),'Edit Profile')]")).click();
	  WebElement pic=driver.findElement(By.xpath("//button[contains(text(),'Change Profile Photo')]"));
	  
	 //upload picture
	  Thread.sleep(3000);
	  pic.click();
	  pic.sendKeys("img/new1.png"); //Uploading the file using sendKeys
	  System.out.println("File is Uploaded Successfully");
	   
	  //remove picture
	  pic.click();
	 driver.findElement(By.xpath("//button[contains(text(),'Remove Current Photo')]")).click();
	 System.out.println("profile picture removed Successfully");
	   
	 //add mobile number
	   WebElement no=driver.findElement(By.id("pepPhone Number"));
	   no.sendKeys("1234567890");
	   no.clear();
	   
	//   WebElement gen=driver.findElement(By.id("pepGender"));  igCoreRadioButtongender3
	//   Select gen=new Select(driver.findElement(By.id("pepGender")));
	//   gen.selectByVisibleText("Prefer Not To Say");
	  
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException 
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
