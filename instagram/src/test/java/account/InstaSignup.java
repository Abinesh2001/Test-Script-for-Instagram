package account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class InstaSignup 
{
	WebDriver driver;
	@Test
	public void signup() throws IOException, InterruptedException 
	{
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.findElement(By.cssSelector("section._9eogI.E3X2T main.SCxLW.o64aR:nth-child(2) div.qF0y9.Igw0E.rBNOH.YBx95.ybXk5.vwCYk.MGky5.i0EQd div.rgFsT div.gr27e:nth-child(1) div.P8adC form.XFYOY div.qF0y9.Igw0E.IwRSH.eGOV_._4EzTm.bkEs3.CovQj.jKUp7.DhRcB:nth-child(2) > button.sqdOP.L3NKy.y3zKF")).click();
		  driver.navigate().back();
		   File in=new File("Data/inputdata.xlsx");

			FileInputStream fis=new FileInputStream(in);
			XSSFWorkbook wk=new XSSFWorkbook (fis);

		    XSSFSheet sh=wk.getSheet("Sheet1");
			

		    int size=sh.getLastRowNum();
		    for(int i=1; i<=size; i++)	
			{ 
		    	

		    	
				WebElement em= driver.findElement(By.name("emailOrPhone"));
				WebElement nm= driver.findElement(By.name("fullName"));
				WebElement un= driver.findElement(By.name("username"));
				WebElement pw= driver.findElement(By.name("password"));
		
				String n=sh.getRow(i).getCell(0).toString();
			   	String e=sh.getRow(i).getCell(1).toString();
			   	String p=sh.getRow(i).getCell(2).toString();
			   	String u=sh.getRow(i).getCell(3).toString();
			   	
			   	System.out.println(n+"       "+e+"      "+p+"      "+u);
			   	em.sendKeys(e);
			   	nm.sendKeys(n);
			   	un.sendKeys(u);
			   	pw.sendKeys(p);
			   	
			    
 
			   try
			   {
				   WebElement signin=driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
				   signin.click();
				   
				
				   Select mon = new Select(driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[1]/select")));
					      mon.selectByIndex(0);
				   Select day = new Select(driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[2]/select")));
						  day.selectByValue("28");
				   Select yr = new Select(driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[4]/div/div/span/span[3]/select")));
						  yr.selectByValue("2000");
					driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div/div[6]/button")).click();		
					driver.findElement(By.xpath("/html/body/div[1]/section/main/div/div/div[1]/div[2]/form/div/div[3]/button")).click();
					
					System.out.println("SUCCESSFULLY SIGNUP");
					
			   }
			   catch(Exception a)
			   {
				   System.out.println("INVALID INPUT DATA");
				   
			   }

              driver.navigate().refresh();

			  // Thread.sleep(3000);
			 //  em.clear();
			 //  un.clear();
			 //  nm.clear();  
			}
	}
	@BeforeTest
	public void beforeTest() 
	{
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.instagram.com/accounts/emailsignup/");
	}

	@AfterTest
	public void afterTest() 
	{
		  driver.quit();
	}

}
