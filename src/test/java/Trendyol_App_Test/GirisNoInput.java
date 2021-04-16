package Trendyol_App_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HesabimPage;
import pageObjects.HomePage;

public class GirisNoInput extends base{
	
	@Test
	public void girisNoInput() throws InterruptedException {
		
		HomePage homepage=new HomePage(driver);
		HesabimPage hesabim=new HesabimPage(driver);
		
		homepage.hesabim.click();
		Thread.sleep(2000);
		
		hesabim.smartLock.click();
		Thread.sleep(1000);
		
		hesabim.giris_btn.click();
		Thread.sleep(1000);
		
		String actualMessage = "Lütfen geçerli bir e-posta girin";
		String ErrorMessage = (String) hesabim.gecersiz_eposta.getText();
		
		assertEquals(actualMessage, ErrorMessage);
	}
	@BeforeMethod
	public void BeforeMethod() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("TrendyolApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//android.widget.Button[@text='ERKEK']")).click();
		
		
	}
	@AfterMethod
	public void AfterMethod() {
		
		service.stop();
	}
	
	

}
