package testCollections;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuiteChrome {
	
	@Test
	public void writeText() {
		System.out.println("Prueba en Chrome");
	}
	
	@Test
	public void open() {
		System.setProperty("webdriver.chrome.driver", "..\\ProjectSauceDemo\\drivers\\chromedriver-v122\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.close();
	}
	
	@Test
	public void validateEmptyLogin() {
		System.setProperty("webdriver.chrome.driver", "..\\ProjectSauceDemo\\drivers\\chromedriver-v122\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("login-button")).click();
		
		String bodyText = driver.findElement(By.id("login_button_container")).getText();
		
		System.out.println("Texto de error: " + bodyText);
		
		driver.close();
		
		Assert.assertEquals("Epic sadface: Username is required", bodyText);
	}
	
	@Test
	public void login_logout(){
		boolean present= false;
		
        System.setProperty("webdriver.chrome.driver", "..\\ProjectSauceDemo\\drivers\\chromedriver-v122\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		present= driver.findElement(By.id("shopping_cart_container")).isDisplayed();
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		driver.close();
		
		Assert.assertTrue(present);
	}
	
	@Test
	public void validateUserBlocked(){	
        System.setProperty("webdriver.chrome.driver", "..\\ProjectSauceDemo\\drivers\\chromedriver-v122\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
        String bodyText = driver.findElement(By.id("login_button_container")).getText();
		
		System.out.println("Texto de error: " + bodyText);
		
		driver.close();
		
		Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", bodyText);
	}
}
