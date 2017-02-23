package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseCode.Wait;

public class HomePage {
	private WebDriver driver;
	
	//��ҳ�û���¼��ť
	@FindBy(xpath="//*[@id='userLogin_sso']")
	private WebElement hometabusrlogin;
	
	//��ҳҽ����¼��ť
	@FindBy(xpath="//*[@id='doctorLogin_sso']")
	private WebElement hometabdoclogin;
	
	//����˳���¼��ť
	@FindBy(xpath="//*[@id='loginOut']")
	private WebElement loginout;

	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//��������û���¼ҳ��
	public void goUsrloginpage(){
		Wait wait = new Wait(driver);
		wait.waitForElementPresent("//*[@id='userLogin_sso']");
		hometabusrlogin.click();
	}
	
	//�������ҽ����¼ҳ��
	public void goDocloginpage(){
		Wait wait = new Wait(driver);
		wait.waitForElementPresent("//*[@id='doctorLogin_sso']");
		hometabdoclogin.click();
	}
	
	//����˳���¼ҳ��
	public void loginout(){
		loginout.click();
	}
}
