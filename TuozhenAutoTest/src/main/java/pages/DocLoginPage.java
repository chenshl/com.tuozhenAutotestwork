package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocLoginPage {
	
	private WebDriver driver;
	
	//�û���
	@FindBy(xpath="//input[@class='loginInput1'][@type='text']")
	private WebElement username;
	
	//����
	@FindBy(xpath="//input[@class='loginInput1'][@type='password']")
	private WebElement password;
	
	//��¼��ť
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	public DocLoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigate(String url){
		this.driver.get(url);
	}
	
	public void getusername(String username){
		this.username.sendKeys(username);
	}
	
	public void getpassword(String password){
		this.password.sendKeys(password);
	}
	
	public void login(){
		this.login.click();
	}

}
