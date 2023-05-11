package org.samp;

import org.JunitTesting.FbloginPojo;

public class Sample extends BaseClass1{
	public static void main(String[] args) {
		launchBrowser();
		Launchurl("https://www.facebook.com/");
		windowMaximize();
		

  FbloginPojo f = new FbloginPojo();
  passText("Selenium", f.getVarRef());
  passText("Inmakes", f.getPassword());
  clickButton(f.getLoginbutton());
  

		
		
	}

}
