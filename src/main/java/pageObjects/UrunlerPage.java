package pageObjects;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UrunlerPage {
	
public UrunlerPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="trendyol.com:id/imageview_product")
	public List<WebElement> urunler;


}
