package com.selenium.instadmbot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Instadmbot {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		   System.setProperty("webdriver.gecko.driver","/home/yistech/Selenium_Setup/geckodriver"); // Setting system properties of FirefoxDriver
		    WebDriver driver = new FirefoxDriver();
		    WebDriverWait Wait = new WebDriverWait(driver,15);
		    driver.get("https://www.instagram.com/direct/inbox/");
		   
		    Thread.sleep(3000);
		    WebElement username = driver.findElement(By.name("username"));
		    username.sendKeys("usr");
		    WebElement password = driver.findElement(By.name("password"));
		    password.sendKeys("pass");
		    
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
       Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Not Now\"]")));
       driver.findElement(By.xpath("//button[text()=\"Not Now\"]")).click();
       
	Thread.sleep(1000);
	Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[2]")));
	driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div[3]/button[2]")).click();
	
		
	String whom = "//*[contains(text(),"+ "\'"+"sweetue"+"\'"+ ")]";
	//String whom = string= "//*[contains(text(),"+ "\'"+receiver+"\'"+ ")]";
	WebElement who = driver.findElement(By.xpath(whom));
	who.click();
	WebElement messg = driver.findElement(By.xpath("//textarea[@placeholder='Message...']"));
	messg.clear();
	messg.sendKeys("test this is a bot");
	WebElement send = driver.findElement(By.xpath("//*[contains(text(), 'Send')]"));
	send.click();
	}

}
