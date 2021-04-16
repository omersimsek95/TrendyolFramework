package pageObjects;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HesabimPage {
	
	public HesabimPage(AndroidDriver<AndroidElement> driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='YUKARIDAKİLERDEN HİÇBİRİ']")
	public WebElement smartLock;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='E-Posta']")
	public WebElement eposta_alani;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Şifre']")
	public WebElement sifre_alani;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='GİRİŞ YAP']")
	public WebElement giris_btn;
	
	@AndroidFindBy(id="trendyol.com:id/text_item_account")
	public List<WebElement> siparislerim;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hesap Bilgilerim']")
	public WebElement hesap_bilgilerim;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='E-posta adresiniz ve/veya şifreniz hatalı.']")
	public WebElement uyarı_snack;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Şifreniz 6 - 16 karakter arasında olmalıdır.']")
	public WebElement uyarı_sifre_karakter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Lütfen geçerli bir e-posta girin']")
	public WebElement gecersiz_eposta;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Anasayfa']")
	public WebElement anasayfa;
}
