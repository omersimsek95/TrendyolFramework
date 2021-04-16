package Trendyol_App_Test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import pageObjects.AramaPage;
import pageObjects.HomePage;
import pageObjects.SepetimPage;
import pageObjects.UrunDetayiPage;
import pageObjects.UrunlerPage;
import pageObjects.HesabimPage;
public class GirisYapmadanFavori extends base {

	
	
		@Parameters("aranacak_esya")
		@Test
		public void girisYapmadanFavori(String aranacak_esya) throws InterruptedException {
			
			HomePage home=new HomePage(driver);
			AramaPage arama=new AramaPage(driver);
			UrunlerPage urunler=new UrunlerPage(driver);
			UrunDetayiPage urundetayi=new UrunDetayiPage(driver);
			HesabimPage hesabim=new HesabimPage(driver);
			
			
			home.arama_cubugu.click();
			home.arama_cubugu.sendKeys(aranacak_esya);
			Thread.sleep(2000);
			
			
			arama.aranan_esya.get(0).click();
			Thread.sleep(2000);
			
			urunler.urunler.get(0).click();
			Thread.sleep(2000);
			
			urundetayi.favori_butonu.click();
			Thread.sleep(2000);
			
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			
			assertEquals(hesabim.giris_btn.isDisplayed(), true);
			
			
			
			
			
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
