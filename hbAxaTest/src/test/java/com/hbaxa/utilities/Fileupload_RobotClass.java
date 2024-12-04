package com.hbaxa.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Fileupload_RobotClass {

	public void remotclass_method(WebDriver driver,String path) throws Exception {
	Actions act =new Actions(driver);
	Robot rb=new Robot();
	rb.delay(2000);
	
	//copy file to clip board
	StringSelection ss=new StringSelection(path);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	
	
	//perform cnt +v action to past file
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_V);
	
	rb.keyRelease(KeyEvent.VK_CONTROL);
	rb.keyRelease(KeyEvent.VK_V);
	
	rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	
	
	}
}
