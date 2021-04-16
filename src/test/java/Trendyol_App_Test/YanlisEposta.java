package Trendyol_App_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.HesabimPage;
import pageObjects.HesapBilgilerimPage;
import pageObjects.HomePage;

public class YanlisEposta extends base{
	
	@Test
	public void yanlisEposta() throws InterruptedException {
		
		HomePage homepage=new HomePage(driver);
		HesabimPage hesabim=new HesabimPage(driver);
		Utilities utilities = new Utilities(driver);
		
		
		homepage.hesabim.click();
		Thread.sleep(2000);
		
		hesabim.smartLock.click();
		Thread.sleep(1000);
		
		String uretilenEposta= utilities.randomMail();
		hesabim.eposta_alani.click();
		hesabim.eposta_alani.sendKeys(uretilenEposta);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		String uretilenSifre= utilities.randomPassword(7);
		hesabim.sifre_alani.click();
		hesabim.sifre_alani.sendKeys(uretilenSifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.giris_btn.click();
		Thread.sleep(1000);
		
		String actualMessage = "E-posta adresiniz ve/veya şifreniz hatalı.";
		String snackMessage = (String) hesabim.uyarı_snack.getText();
		assertEquals(actualMessage, snackMessage);
		
		
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
