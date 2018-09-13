package Web_Testing_Soccer.FantasyFootballScout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	  
	  
	  @Test
	  public void StaticDropdown() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/register/");

		Select s = new Select(driver.findElement(By.id("country_of_residence")));
		s.selectByValue("ITA");
		System.out.println(driver.findElement(By.id("country_of_residence")).getText());
	    
	  }
	  
	  
	  @Test
	  public void DynamicDropdown() throws Exception {
		driver.get("https://spicejet.com/");
	    
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//a[@value='BKK']")).click();
		
		driver.findElement(By.xpath("(//a[@value='DXB'])[2]")).click();
		
		
		
	    
	  }
	  
	  
	  
	  @Test
	  public void CheckBox() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/register/");
		
		assertFalse("false", driver.findElement(By.xpath("//p//input[@value='yes']")).isSelected());

		driver.findElement(By.xpath("//p//input[@value='yes']")).click();
		
		
		assertTrue("true", driver.findElement(By.xpath("//p//input[@value='yes']")).isSelected());
		
	  
	  }
	  
	 
	  @Test
	  public void RadioButton() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/register/");
		
		

		driver.findElement(By.xpath("//input[@value='yes']")).click();
		
		// count Radio button in the page with same attribute 
		
		System.out.println(driver.findElements(By.xpath("//input[@name='email_accept']")).size());
	  
	  
	  
	  // the for loop increments until finds second button and click it (2 buttons index 1)
	  
	  
	  int count =driver.findElements(By.xpath("//input[@name='email_accept']")).size();

	  for (int i=0;i<count;i++) {
	  	
	  	driver.findElements(By.xpath("//input[@name='email_accept']")).get(1).click();
	  	
	    }
	  
	  
	  /*
	   in this scenario foor look click every radio button in the page as the variable (i) incemenet through the loop 
	  
	   int count =driver.findElements(By.xpath("//input[@name='email_accept']")).size();

	  for (int i=0;i<count;i++) {
	  	
	  	driver.findElements(By.xpath("//input[@name='email_accept']")).get(i).click();
	  	
	    }
	  
	  
	  */
	  
	  // get the attributes for the radio buttons in the page and print them out the loop is 

	  for (int i=0;i<count;i++) {
	  	
		  System.out.println(driver.findElements(By.xpath("//input[@name='email_accept']")).get(i).getAttribute("value"));
	  	
	  }
	  
	  // now we want to click on radio button with value yes 
	  
	  for (int i=0;i<count;i++) {
			
			String text = driver.findElements(By.xpath("//input[@name='email_accept']")).get(i).getAttribute("value");
			
			if (text.equals("yes")) {
				
				driver.findElements(By.xpath("//input[@name='email_accept']")).get(i).click();
				
			}

		}

	  
	  }
	  
	  @Test
	  public void SeleniumMethods() throws Exception {
		driver.get("https://www.fantasyfootballscout.co.uk/");
	    
		// check if an element is in hidden mode
	    System.out.println(driver.findElement(By.xpath("//div[@class='login-here alive']")).isDisplayed()); 
		
	    // extract text from the specific location for validation 
	    System.out.println(driver.findElement(By.xpath("//div[@class='login-here alive']")).getText());
	    
	    // check if an element exists in a page and how many  
	    System.out.println(driver.findElements( By.xpath("//div[@class='login-here alive']")).size()); 
	    
	    // check whetjer the element is enabled or disabled 
	    System.out.println(driver.findElement(By.xpath("//div[@class='login-here alive']")).isEnabled());
	    
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



 