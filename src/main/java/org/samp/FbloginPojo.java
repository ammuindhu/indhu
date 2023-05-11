package org.samp;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sam.BaseClass;

public class FbloginPojo extends BaseClass {
	//1.non parameterized constructor
	public FbloginPojo() {

		
		PageFactory.initElements(driver, this);
	}
	//2. privatewebElement
	//webElement email = driver.findElement(by.id("email"));
	
	@FindAll({
		@FindBy(xpath="//input[@id='email']"),
		@FindBy(xpath="//input[@name='email']"),
		@FindBy(xpath="//input[@data-testid='royal_email']")
	})
	private WebElement varRef;
	

	@FindBy(xpath="//input@[aria_label='Password']")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginbutton;
	//3.getter to access webElements outside the class

	public WebElement getVarRef() {
		return varRef;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}

	public WebElement getEmail() {
		
		return null;
	}

	

	
	}
	


