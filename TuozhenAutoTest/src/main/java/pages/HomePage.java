package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseCode.Wait;

public class HomePage {
	private WebDriver driver;
	
	//首页用户登录按钮
	@FindBy(xpath="//*[@id='userLogin_sso']")
	private WebElement hometabusrlogin;
	
	//首页医生登录按钮
	@FindBy(xpath="//*[@id='doctorLogin_sso']")
	private WebElement hometabdoclogin;
	
	//点击退出登录按钮
	@FindBy(xpath="//*[@id='loginOut']")
	private WebElement loginout;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//点击进入用户登录页面
	public void goUsrloginpage(){
		Wait wait = new Wait(driver);
		wait.waitForElementPresent("//*[@id='userLogin_sso']");
		hometabusrlogin.click();
	}
	
	//点击进入医生登录页面
	public void goDocloginpage(){
		Wait wait = new Wait(driver);
		wait.waitForElementPresent("//*[@id='doctorLogin_sso']");
		hometabdoclogin.click();
	}
	
	//点击退出登录页面
	public void loginout(){
		loginout.click();
	}
}
