package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UrunDetayiPage {
		public UrunDetayiPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
		@AndroidFindBy(id="trendyol.com:id/imageViewFavorite")
		public WebElement favori_butonu;
		
		@AndroidFindBy(id="trendyol.com:id/textViewBrandName")
		public WebElement urun_marka;
		
		@AndroidFindBy(id="trendyol.com:id/textViewProductName")
		public WebElement urun_acıklama;
		
		@AndroidFindBy(id="trendyol.com:id/button_add_to_basket")
		public WebElement sepete_ekle_btn;
}
