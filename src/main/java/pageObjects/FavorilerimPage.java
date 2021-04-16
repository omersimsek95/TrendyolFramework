package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FavorilerimPage {

	public FavorilerimPage(AndroidDriver<AndroidElement> driver) {
			
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
		@AndroidFindBy(id="trendyol.com:id/textViewFavoriteItemBrand")
		public WebElement urun_marka;
	
		@AndroidFindBy(id="trendyol.com:id/textViewFavoriteItemOptions")
		public WebElement favori_options;
		
		@AndroidFindBy(id="trendyol.com:id/favoriteItemOptionDelete")
		public WebElement favori_options_delete;

}
