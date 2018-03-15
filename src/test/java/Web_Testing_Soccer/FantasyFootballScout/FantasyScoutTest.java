package Web_Testing_Soccer.FantasyFootballScout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		driver.get("https://www.fantasyfootballscout.co.uk/team-news/");

	}

	@Test 
	public void testFootballsoutArsenal() throws Exception {
		assertEquals("Team News | Fantasy Football Tips, News and Views from Fantasy Football Scout", driver.getTitle());
		assertEquals("Next Match:", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/div/strong")).getText());
		assertEquals("ARSENAL", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/h2")).getText());
		assertEquals("CHELSEA", driver.findElement(By.xpath("//html//li[5]/div[1]/header[1]/h2[1]")).getText());
	}
	  
	 
	
	  @Test
	  public void ErrorLogin() throws Exception {
	    driver.findElement(By.xpath("//header[@id='header']/section/div[4]/div[2]/div")).click();
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


	
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	     
	  
	}



 