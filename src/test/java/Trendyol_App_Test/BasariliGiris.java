package Trendyol_App_Test;


import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Trendyol_App_Test.base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import pageObjects.CikisPage;
import pageObjects.HesabimPage;
import pageObjects.HesapBilgilerimPage;
import pageObjects.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

public class BasariliGiris extends base{
	
	@Parameters({"gecerli_mail","gecerli_sifre"})
	@Test
	public void basariliGiris(String gecerli_mail,String gecerli_sifre) throws IOException, InterruptedException   {
		

		HomePage homepage=new HomePage(driver);
		HesabimPage hesabim=new HesabimPage(driver);
		HesapBilgilerimPage hesapBilgilerim=new HesapBilgilerimPage(driver);
		CikisPage cikis=new CikisPage(driver);
		homepage.hesabim.click();
		Thread.sleep(2000);
		
		hesabim.smartLock.click();
		Thread.sleep(1000);
		
		hesabim.eposta_alani.click();
		hesabim.eposta_alani.sendKeys(gecerli_mail);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.sifre_alani.click();
		hesabim.sifre_alani.sendKeys(gecerli_sifre);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.giris_btn.click();
		Thread.sleep(4000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		String siparislerim=(String) hesabim.siparislerim.get(0).getText();
		
		assertEquals(siparislerim, "Siparişlerim");
		
	
		
		
		hesabim.hesap_bilgilerim.click();
		hesapBilgilerim.cikis_btn.click();
		cikis.cikis2_btn.click();
		
		
		
		
		
		
		
	}
	
	@BeforeMethod
	public void BeforeMethod() throws IOException, InterruptedException 
	{
		service = startServer();
		AndroidDriver<AndroidElement> driver = Capabilities("TrendyolApp");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//android.widget.Button[@text='ERKEK']")).click();
		
	}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	
	}
	@AfterMethod
	public void AfterMethod() {
		
		service.stop();
	}
	
	@BeforeSuite
	public void BeforeSuite() throws IOException {
		//service = startServer();
		//AndroidDriver<AndroidElement> driver = Capabilities("TrendyolApp");
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);	
		//driver.findElement(By.xpath("//android.widget.Button[@text='ERKEK']")).click();
	}
	
	

}
