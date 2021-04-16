package Trendyol_App_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.AramaPage;
import pageObjects.HomePage;
import pageObjects.SepetimPage;
import pageObjects.UrunDetayiPage;
import pageObjects.UrunlerPage;

public class SepetToplamUcret extends base {
	@Parameters("aranacak_esya")
	@Test
	public void sepetToplamUcret(String aranacak_esya) throws InterruptedException {
		
		HomePage home=new HomePage(driver);
		AramaPage arama=new AramaPage(driver);
		UrunlerPage urunler=new UrunlerPage(driver);
		UrunDetayiPage urundetayi=new UrunDetayiPage(driver);
		SepetimPage sepetim=new SepetimPage(driver);
		
		
		
		home.arama_cubugu.click();
		home.arama_cubugu.sendKeys(aranacak_esya);
		Thread.sleep(2000);
		
		
		arama.aranan_esya.get(0).click();
		Thread.sleep(2000);
		urunler.urunler.get(0).click();
		Thread.sleep(2000);
		
		//driver.findElementByXPath("//android.widget.Button[@text='Sepete Ekle']").click();
		urundetayi.sepete_ekle_btn.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		urunler.urunler.get(1).click();
		//driver.findElementByXPath("//android.widget.Button[@text='Sepete Ekle']").click();
		urundetayi.sepete_ekle_btn.click();
		Thread.sleep(1000);
		
		double urun1=Double.parseDouble(sepetim.sepetteki_urunler.get(0).getText().substring(0,4));
		double urun2=Double.parseDouble(sepetim.sepetteki_urunler.get(1).getText().substring(0,4));
		double sum=urun1+urun2;
		
		double toplam_ucret=Double.parseDouble(sepetim.toplam_ucret.getText().substring(0, 4));
		
		assertEquals(sum, toplam_ucret);
		
		
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
