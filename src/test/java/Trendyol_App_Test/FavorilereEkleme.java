package Trendyol_App_Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.AramaPage;
import pageObjects.CikisPage;
import pageObjects.FavorilerimPage;
import pageObjects.HesabimPage;
import pageObjects.HesapBilgilerimPage;
import pageObjects.HomePage;
import pageObjects.UrunDetayiPage;
import pageObjects.UrunlerPage;

public class FavorilereEkleme extends base {
	
	@Parameters({"gecerli_mail","gecerli_sifre","aranacak_esya"})
	@Test
	public void favorilereEkleme(String gecerli_mail,String gecerli_sifre,String aranacak_esya) throws InterruptedException {
		
		
		HomePage homepage=new HomePage(driver);
		HesabimPage hesabim=new HesabimPage(driver);
		HesapBilgilerimPage hesapBilgilerim=new HesapBilgilerimPage(driver);
		AramaPage arama=new AramaPage(driver);
		UrunlerPage urunler=new UrunlerPage(driver);
		UrunDetayiPage urundetayi=new UrunDetayiPage(driver);
		FavorilerimPage favorilerim=new FavorilerimPage(driver);
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
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		hesabim.anasayfa.click();
		
		homepage.arama_cubugu.click();
		homepage.arama_cubugu.sendKeys(aranacak_esya);
		Thread.sleep(2000);
		
		arama.aranan_esya.get(0).click();
		Thread.sleep(2000);
		
		urunler.urunler.get(0).click();
		Thread.sleep(2000);
		
		
		String aranan_esya_ismi=urundetayi.urun_marka.getText();
		
		Thread.sleep(2000);
		
		urundetayi.favori_butonu.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(4000);
		
		arama.favorilerim.click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		String urun_ismi=favorilerim.urun_marka.getText();
		
		
		assertEquals(aranan_esya_ismi,urun_ismi);
		
		favorilerim.favori_options.click();
		favorilerim.favori_options_delete.click();
		
		
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
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException 
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	
	}

}
