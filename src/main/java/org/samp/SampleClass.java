package org.samp;

import java.util.Date;

import org.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleClass extends Baseclass {
	@BeforeClass
	private void launchthebrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	@BeforeMethod
	private void startdate() {
		Date d = new Date();
		System.out.println(d);

	}
	
@Test(retryAnalyzer = Failed.class)
private void tc() {
	driver.get("https://en-gb.facebook.com/");
	String title = driver.getTitle();
	
	WebElement email = driver.findElement(By.id("email"));
	email.sendKeys("ammuindhu1213@gmail.com");
	
	WebElement password = driver.findElement(By.name("pass"));
	password.sendKeys("indhu1213");
	

}
@Test
private void tc1() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
}
@Test
private void tc3() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
}
}
