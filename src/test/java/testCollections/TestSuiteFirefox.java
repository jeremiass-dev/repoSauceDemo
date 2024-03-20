package testCollections;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSuiteFirefox {
	
	@Test
	public void lab1_test() {
		System.out.println("Hola Mundo de Automatización!");
	}
	
	@Test
	public void lab1_e2() {
		System.setProperty("webdriver.gecko.driver", "..\\ProjectTestin2024\\drivers\\geckodriver-v0-34.0\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		
		driver.close();
	}
	
	@Test
	public void lab1_e3() {
		System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.click();
		
		driver.close();
	}
}
