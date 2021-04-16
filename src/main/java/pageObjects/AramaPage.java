package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.beust.jcommander.Parameter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AramaPage {
public AramaPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
		@AndroidFindBy(id="trendyol.com:id/textViewSearchSuggestionText")
		public List<WebElement> aranan_esya;
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='Favorilerim']")
		public WebElement favorilerim;


}
