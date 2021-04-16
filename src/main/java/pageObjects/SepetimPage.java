package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SepetimPage {
	
	public SepetimPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="trendyol.com:id/textViewSalePrice")
	public List<WebElement> sepetteki_urunler;
	
	@AndroidFindBy(id="trendyol.com:id/textViewApproveBasketPrice")
	public WebElement toplam_ucret;

}
