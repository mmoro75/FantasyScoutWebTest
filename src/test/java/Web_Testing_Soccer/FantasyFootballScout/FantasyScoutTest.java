package Web_Testing_Soccer.FantasyFootballScout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class FantasyScoutTest {
	  private WebDriver driver;
	  private boolean acceptNextAlert = true;
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
	    assertEquals("Team News | Fantasy Football Tips, News and Views from Fantasy Football Scout", driver.getTitle());
	    assertEquals("Next Match:", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/div/strong")).getText());
	    assertEquals("ARSENAL", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/h2")).getText());
	  }
	  
	  
	  @Test 
	  public void testFootballsoutChelsea() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/team-news/");
	    assertEquals("Team News | Fantasy Football Tips, News and Views from Fantasy Football Scout", driver.getTitle());
	    assertEquals("Team News | Fantasy Football Tips, News and Views from Fantasy Football Scout", driver.getTitle());
	    assertEquals("Next Match:", driver.findElement(By.xpath("//article[@id='post-3147']/section/div/ol/li/div/header/div/strong")).getText());
	    assertEquals("CHELSEA", driver.findElement(By.xpath("//html//li[5]/div[1]/header[1]/h2[1]")).getText());
	   
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



 