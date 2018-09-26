package Web_Testing_Soccer.FantasyFootballScout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author Marco Moro
 *  
 */

public class FantasyScoutTest {			
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	


	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
		

	}

	@Test 
	public void testFootballsoutArsenal() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/team-news/");
		assertEquals("Team News | Fantasy Football Tips, News and Views from Fantasy Football Scout", driver.getTitle());
		assertEquals("Next Match:", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/div/strong")).getText());
		assertEquals("ARSENAL", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/h2")).getText());
		assertEquals("CHELSEA", driver.findElement(By.xpath("//html//li[5]/div[1]/header[1]/h2[1]")).getText());
	}
	  
	 
	
	  @Test
	  public void ErrorLogin() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/team-news/");
		
		driver.findElement(By.xpath("//*[@id='header']/section/div[4]/div[2]/div")).click();
	    driver.findElement(By.id("user_login")).click();
	    driver.findElement(By.id("user_login")).clear();
	    driver.findElement(By.id("user_login")).sendKeys("marco.moro75@yahoo.it");
	    driver.findElement(By.id("user_pass")).click();
	    driver.findElement(By.id("user_pass")).clear();
	    driver.findElement(By.id("user_pass")).sendKeys("mckl1998");
	    driver.findElement(By.id("wp-submit")).click();
	    try {
	      assertEquals("ERROR", driver.findElement(By.xpath("//div[@id='login_error']/strong")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }

	  
	  
	  @Test
	  public void ForgottenPasswordError() throws Exception {
		driver.get("https://fantasy.premierleague.com/");
		
		driver.findElement(By.xpath("//*[@id='ismr-main']/div[1]/form/div[4]/div/a[1]")).click();
	    driver.findElement(By.cssSelector("#email")).sendKeys("ginolatino@yahoo.it");
	    driver.findElement(By.xpath("//*[@id='ismr-content']/div/form/button")).click();
	    try {
	      assertEquals("Reset instructions sent", driver.findElement(By.xpath("//*[@id='ismr-content']/div/div/h2")).getText());
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	  }
	  
	  
	  
	  @Test
	  public void SignIn() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/team-news/");
		
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("document.getElementsByClassName('login-here alive').style.display='block';");
	//	executor.executeScript("document.getElementById('qEgULQ').st‌​yle.display='block';‌​");
		
		driver.findElement(By.xpath("//*[@title='Lost Password']")).click();
	    
	
		
	    }
	  
	  
	  
	  
	  
	  @Test 
		public void testInjuries() throws Exception {
			driver.get("https://www.fantasyfootballscout.co.uk");
			driver.findElement(By.xpath("//li[@id='menu-item-26249']")).click();
			 assertEquals("BOU", driver.findElement(By.xpath("//html//div[@id='panel']//tr[7]/td[2]")).getText());
			 assertEquals("ARS", driver.findElement(By.xpath("//article[@id='post-3127']/section/table/tbody/tr/td[2]")).getText());
		}
	  
	  
	  @Test
	  public void CreateAccount() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/register/");
	    driver.findElement(By.id("username")).click();
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("marco.moro75@yahoo.it");
	    driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("mckl1998");
	    driver.findElement(By.xpath("//li[@class='subscription free']//h3//label//input[@type='radio']")).click();
	   
	   
	    
	  }
	   
	 
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	     
	  
	}



 