package com.keyworddriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeywDrivenFramework 
{
	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException 
	{
		String baseURL = "https://naveenautomationlabs.com/opencart/index.php?route=account/register";
		String propfilepath = "C:\\Users\\HP\\Documents\\SeleniumPractice\\KeywordDrivenF\\properties\\Keyword.properties";
		
		int length = 10; // Change the length as per your requirement
        String randomStrng = generateRandomString(length);
        String domain = "@mailnator.com"; // Change the domain name as per your requirement
        String email = randomStrng + domain;
        System.out.println("Random Email: " + email);
        
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
		Properties p = new Properties();
		
		try 
		{
			FileInputStream fis = new FileInputStream(propfilepath);
			p.load(fis);
		} 
		catch (IOException e) 
		{
			System.out.println("Properties file not found, Please check the path once: "+e);
		}
		
//		String ftextbox = p.getProperty("fnametextbox");
//		String ltextbox = p.getProperty("lnametextbox");
//		String emailtextbox = p.getProperty("emailtextbox");
		
		driver.findElement(By.xpath(p.getProperty("fnametextbox"))).sendKeys(p.getProperty("FirstName"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("lnametextbox"))).sendKeys(p.getProperty("LastName"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("emailtextbox"))).sendKeys(email);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("phonenumtextbox"))).sendKeys(p.getProperty("Phone"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("passwordtextbox"))).sendKeys(p.getProperty("Password"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("confirmtextbox"))).sendKeys(p.getProperty("CnfPassword"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("radiobutton"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("termndcondchecktbox"))).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(p.getProperty("continubutton"))).click();
		Thread.sleep(3000);
		
	}
	
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static final SecureRandom random = new SecureRandom();
	
	public static String generateRandomString(int length) 
    {
		 StringBuilder stringBuilder = new StringBuilder(length);
	        for (int i = 0; i < length; i++) 
	        {
	            stringBuilder.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
	        }
	        return stringBuilder.toString();
    }
	

}
