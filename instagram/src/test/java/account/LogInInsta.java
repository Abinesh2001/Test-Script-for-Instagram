package account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LogInInsta 
{
	WebDriver driver;
	@Test
	public void login() throws IOException, InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		File in=new File("Data/inputdata.xlsx");

		FileInputStream fis=new FileInputStream(in);
		XSSFWorkbook wk=new XSSFWorkbook (fis);

		XSSFSheet sh=wk.getSheet("Sheet2");

		int size=sh.getLastRowNum();
	    for(int i=1; i<=size; i++)		
		{


			WebElement un=driver.findElement(By.name("username"));
			WebElement pw=driver.findElement(By.name("password"));

			String u=sh.getRow(i).getCell(0).toString();
			String p=sh.getRow(i).getCell(1).toString();

			System.out.println(u+"      "+p);
			un.sendKeys(u);
			pw.sendKeys(p);

			WebElement lgin=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/main[1]/article[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]"));
			lgin.click();
			try
			{
				driver.findElement(By.xpath("//button[contains(text(),'Not Now')]")).click();
				driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[2]")).click();
				driver.findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/span")).click();
				WebElement logout=driver.findElement(By.xpath("/html/body/div[1]/section/nav/div[2]/div/div/div[3]/div/div[6]/div[2]/div[2]/div[2]/div[2]/div/div/div/div/div/div"));
				logout.click();
				System.out.println("LOGIN SUCCESSFULL");
			}
			catch(Exception a)
			{
				System.out.println("INVALID INPUT");
			}
			Thread.sleep(3000);
			 driver.navigate().refresh();
			//un.clear();
			//pw.clear();
		}
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

