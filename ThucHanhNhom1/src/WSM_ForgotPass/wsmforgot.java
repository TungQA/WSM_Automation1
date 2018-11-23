package WSM_ForgotPass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.VariableSettings;

@Test
public class wsmforgot {
FirefoxOptions firefox_options  = new FirefoxOptions();
	
	
	public WebDriver driver;
	
	public boolean bexpected;
	public boolean bactual;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty(VariableSettings.LIB_GECKO, VariableSettings.PATH_GECKO);
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		driver.manage().window().maximize();
	}

/*	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
*/
	
	@Test(priority = 0)
	public void TC01_ForgotScr() {
		String expected = null;
		String actual = null;
		
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();	
		driver.findElement(By.xpath("//a[contains(.,'Forgot password')]")).click();
		
		
		expected = "FORGOT PASSWORD";
		actual = driver.findElement(By.xpath("//label[contains(.,'Forgot password')]")).getText();
		
		Assert.assertEquals(actual, expected);
	}
	
	
	@Test(priority = 1)
	public void TC02_ForgotTitle() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String expected = null;
		String actual = null;
		expected = "FORGOT PASSWORD";
		actual = driver.findElement(By.xpath("//label[contains(.,'Forgot password')]")).getText();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 2)
	public void TC02_ForgotEmail() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		bexpected = true;
		bactual = driver.findElement(By.xpath("(//input[@required='required'][contains(@id,'email')])[2]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
	}
	
	@Test(priority = 3)
	public void TC02_ForgotOKbtn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		bexpected = true;
		bactual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/form/div[2]/button")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
	}
	
	@Test(priority = 4)
	public void TC02_ForgotCancelbtn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		bexpected = true;
		bactual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/form/div[2]/a")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
	}
	
	@Test(priority = 5)
	public void TC02_ForgotBackbtn() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		bexpected = true;
		bactual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/a")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
	}
	
	@Test(priority = 6)
	public void TC04_BackToLogin() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
								
		String expected = null;
		String actual = null;
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/a")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		expected = "LOGIN";
		actual = driver.findElement(By.xpath("//label[@class='login-title'][contains(.,'LOGIN')]")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}
	
	
	
	@Test(priority = 7)
	public void TC05_SentMessage() throws InterruptedException {
		
		
								
		String expected = null;
		String actual = null;
		driver.findElement(By.xpath("//a[contains(.,'Forgot password')]")).click();
		driver.findElement(By.xpath("(//input[@required='required'][contains(@id,'email')])[2]")).sendKeys("dinh.ba.tung@framgia.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/form/div[2]/button")).click();
		Thread.sleep(8000);
		expected = "You will receive an email with instructions on how to reset your password in a few minutes.";
		actual = driver.findElement(By.xpath("//p[contains(.,'You will receive an email with instructions on how to reset your password in a few minutes.')]")).getText();
		Thread.sleep(1000);
		
		Assert.assertEquals(actual, expected);
		
	}
	
	
	@Test(priority = 8)
	 public void TC06_OpenMail() throws InterruptedException {
		Thread.sleep(1000);
	 driver.get("http://www.yopmail.com/en/tungtestauto");
	 Thread.sleep(5000);
	 driver.switchTo().frame("ifmail");
	 Thread.sleep(3000);
	 String link=driver.findElement(By.xpath("//a[@class='link-website']")).getAttribute("href");
	 driver.get(link);
	 bexpected = true;
	bactual = true;
		Assert.assertEquals(bactual, bexpected);
	 }
	
	
	@Test(priority = 9)
	public void TC07_ChangePassScr() throws InterruptedException {
		
		Thread.sleep(1000);
		String expected = null;
		String actual = null;
		expected = "CHANGE PASSWORD";
		actual = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/label")).getText();
		
		Assert.assertEquals(actual, expected);
		
		
	}
	
	
	
	@Test(priority = 10)
	public void TC08_NoChangePass() throws InterruptedException {
		driver.get(VariableSettings.PATH_WEBTEST);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		// Enter email
        driver.findElement(By.id("user_email")).sendKeys("dinh.ba.tung@framgia.com");
        // Enter pass
        driver.findElement(By.id("user_password")).sendKeys("Tungtest123");
      //click on OK
        driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bexpected = true;
		bactual = driver.findElement(By.xpath("//div[@class='alert alert-info fade in hide-flash'][contains(.,'Signed in successfully.')]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
		
		
	}
	
	@Test(priority = 11)
	public void TC09_EmailBlank() throws InterruptedException {
		driver.close();
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Forgot password')]")).click();
		driver.findElement(By.xpath("(//input[@required='required'][contains(@id,'email')])[2]")).sendKeys("");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/form/div[2]/button")).click();
		
        bexpected = true;
		bactual = driver.findElement(By.xpath("//p[contains(.,'Email is required')]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
		
		
	}
	
	@Test(priority = 12)
	public void TC10_EmailInvalid() throws InterruptedException {
		
		driver.findElement(By.xpath("(//input[@required='required'][contains(@id,'email')])[2]")).sendKeys("abc@");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/form/div[2]/button")).click();
		
        bexpected = true;
		bactual = driver.findElement(By.xpath("//p[contains(.,'Please enter a valid email address')]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);		
		
	}
	
	@Test(priority = 12)
	public void TC11_EmailNotFound() throws InterruptedException {
		driver.close();
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		driver.findElement(By.xpath("//a[contains(.,'Forgot password')]")).click();
		driver.findElement(By.xpath("(//input[@required='required'][contains(@id,'email')])[2]")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/section/form/div[2]/button")).click();
		bexpected = true;
		bactual = driver.findElement(By.xpath("//p[@class='alert alert-danger'][contains(.,'Email not found')]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
		
	}
	
	
	
	@Test(priority = 13)
	public void TC12_ChangePassTitle() throws InterruptedException {
		driver.get("http://www.yopmail.com/en/");
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys("Tungtestauto");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/form/table/tbody/tr[1]/td[3]/a/span/span")).click();
		
		 Thread.sleep(5000);
		 driver.switchTo().frame("ifmail");
		 Thread.sleep(3000);
		 String link=driver.findElement(By.xpath("//a[@class='link-website']")).getAttribute("href");
		 driver.get(link);
		 String expected = null;
			String actual = null;
			expected = "CHANGE PASSWORD";
			actual = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/label")).getText();
			
			Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 14)
	public void TC12_ChangePassNewPassLabel() throws InterruptedException {
		
		 String expected = null;
			String actual = null;
			expected = "New password";
			actual = driver.findElement(By.xpath("//label[@class='field-title'][contains(.,'New password')]")).getText();
			
			Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 15)
	public void TC12_ChangePassNewPassField() throws InterruptedException {
		
		 
			bexpected = true;
			bactual = driver.findElement(By.xpath("//*[@id=\"user_password\"]")).isDisplayed();
			Assert.assertEquals(bactual, bexpected);
		
	}
	
	@Test(priority = 16)
	public void TC12_ChangePassConfPassLabel() throws InterruptedException {
		
		 String expected = null;
			String actual = null;
			expected = "Password confirmation";
			actual = driver.findElement(By.xpath("//label[@class='field-title'][contains(.,'Password confirmation')]")).getText();
			
			Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 17)
	public void TC12_ChangePassConfPassField() throws InterruptedException {
		
		 
			bexpected = true;
			bactual = driver.findElement(By.xpath("//*[@id=\"user_password_confirmation\"]")).isDisplayed();
			Assert.assertEquals(bactual, bexpected);
		
	}
	
	@Test(priority = 18)
	public void TC12_ChangePassOKbtn() throws InterruptedException {
		
		 
			bexpected = true;
			bactual = driver.findElement(By.xpath("//button[@name='button'][contains(.,'Ok')]")).isDisplayed();
			Assert.assertEquals(bactual, bexpected);
		
	}
	@Test(priority = 19)
	public void TC13_ChangePassSuccessMess() throws InterruptedException {
		
		String expected = null;
		String actual = null;
		driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("Tungtest123");
		driver.findElement(By.xpath("//*[@id=\"user_password_confirmation\"]")).sendKeys("Tungtest123");
		driver.findElement(By.xpath("//button[@name='button'][contains(.,'Ok')]")).click();
		
		expected = "×\n" + 
				"Your password has been changed successfully. You are now signed in.";
		
		Thread.sleep(1000);
		actual = driver.findElement(By.xpath("//div[@class='alert alert-info fade in hide-flash'][contains(.,'Your password has been changed successfully. You are now signed in.')]")).getText();
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 20)
	public void TC14_WorkingCalendar() throws InterruptedException {
		
		String expectedTitle = "Your timesheet | Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 21)
	public void TC15_LoginNewPass() throws InterruptedException {
		
		driver.close();
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		// Enter email
        driver.findElement(By.id("user_email")).sendKeys("dinh.ba.tung@framgia.com");
        // Enter pass
        driver.findElement(By.id("user_password")).sendKeys("Tungtest123");
      //click on OK
        driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        bexpected = true;
		bactual = driver.findElement(By.xpath("//div[@class='alert alert-info fade in hide-flash'][contains(.,'Signed in successfully.')]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
	}
	
	@Test(priority = 22)
	public void TC16_LoginOldPass() throws InterruptedException {
		
		driver.close();
		driver = new FirefoxDriver();
		driver.get(VariableSettings.PATH_WEBTEST);
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']")).click();
		// Enter email
        driver.findElement(By.id("user_email")).sendKeys("dinh.ba.tung@framgia.com");
        // Enter pass
        driver.findElement(By.id("user_password")).sendKeys("Tungtest1234");
      //click on OK
        driver.findElement(By.xpath("//button[@class='wsm-btn login-success']")).click();
        
        Thread.sleep(1000);
        bexpected = true;
		bactual = driver.findElement(By.xpath("//p[contains(.,'Invalid email or password.')]")).isDisplayed();
		Assert.assertEquals(bactual, bexpected);
	}
	
	@Test(priority = 23)
	public void TC17_PassFieldBlank() throws InterruptedException {
		
		driver.get("http://www.yopmail.com/en/");
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys("Tungtestauto");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("/html/body/div[3]/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/form/table/tbody/tr[1]/td[3]/a/span/span")).click();
		
		 Thread.sleep(5000);
		 driver.switchTo().frame("ifmail");
		 Thread.sleep(3000);
		 String link=driver.findElement(By.xpath("//a[@class='link-website']")).getAttribute("href");
		 driver.get(link);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[@name='button'][contains(.,'Ok')]")).click();		 
		 String expected = null;
			String actual = null;
			expected = "Password is required";
			actual = driver.findElement(By.xpath("//p[contains(@id,'password-error')][@class='help-block'][contains(.,'Password is required')]")).getText();
			
			Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 23)
	public void TC18_Enter1character() throws InterruptedException {
		
		 driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("a");
		 driver.findElement(By.xpath("//button[@name='button'][contains(.,'Ok')]")).click();		 
		 String expected = null;
			String actual = null;
			expected = "Please enter at least 6 characters";
			actual = driver.findElement(By.xpath("//p[contains(@id,'password-error')][@class='help-block'][contains(.,'Please enter at least 6 characters')]")).getText();
			
			Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 24)
	public void TC19_Enter130character() throws InterruptedException {
		
		 driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("textmaxlengthtextmaxlengthtextmaxlengthtextmaxlengthtextmaxlengthtextmaxlengthtextmaxlengthtextmaxlengthtextmaxlengthtextmaxlength");
		 driver.findElement(By.xpath("//button[@name='button'][contains(.,'Ok')]")).click();		 
		 String expected = null;
			String actual = null;
			expected = "Please enter max 128 characters";
			actual = driver.findElement(By.xpath("//p[contains(@id,'password-error')][@class='help-block'][contains(.,'Please enter max 128 characters')]")).getText();
			
			Assert.assertEquals(actual, expected);
	}
	
	@Test(priority = 25)
	public void TC20_PassNoMatch() throws InterruptedException {
		
		 driver.findElement(By.xpath("//*[@id=\"user_password\"]")).clear();
		 driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("Tungtest12345");
		 driver.findElement(By.xpath("//*[@id=\"user_password_confirmation\"]")).sendKeys("Tungtest123");
		 
		 driver.findElement(By.xpath("//button[@name='button'][contains(.,'Ok')]")).click();		 
		 String expected = null;
			String actual = null;
			expected = "Please enter the same value again.";
			actual = driver.findElement(By.xpath("//p[contains(@id,'confirmation-error')][@class='help-block'][contains(.,'Please enter the same value again.')]")).getText();
			
			Assert.assertEquals(actual, expected);
	}
		

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
