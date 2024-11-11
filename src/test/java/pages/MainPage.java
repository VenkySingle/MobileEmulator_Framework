package pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.GenericMethods;

public class MainPage {
	
	private AndroidDriver<MobileElement> driver;
	SoftAssert asserts;
	GenericMethods general;
	
	public MainPage(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(20)),this);
		general = new GenericMethods(driver);
		
	}
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private MobileElement BtnOk;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='1']")
	private MobileElement BtnOne;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='2']")
	private MobileElement BtnTwo;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='3']")
	private MobileElement BtnThree;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='4']")
	private MobileElement BtnFour;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='5']")
	private MobileElement BtnFive;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='6']")
	private MobileElement BtnSix;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='7']")
	private MobileElement BtnSeven;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='8']")
	private MobileElement BtnEight;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='9']")
	private MobileElement BtnNine;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='+']")
	private MobileElement BtnAdd;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='-']")
	private MobileElement BtnSub;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='×']")
	private MobileElement BtnMul;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='÷']")
	private MobileElement BtnDiv;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='=']")
	private MobileElement BtnEquals;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='0']")
	private MobileElement BtnZero;
	
	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement FinalRes;
	

	public void EnterNumber(String Num)
	{
		int len  = Num.length();
		if(len==1)
		{
			switch (Num) {
			case "1": 
				general.waituntilClickable(BtnOne);
				BtnOne.click();
			break;
			case "2": 
				general.waituntilClickable(BtnTwo);
				BtnTwo.click();
			break;
			case "3": 
				BtnThree.click();
			break;
			case "4": 
				BtnFour.click();
			break;
			case "5": 
				BtnFive.click();
			break;
			case "6": 
				BtnSix.click();
			break;
			case "7": 
				BtnSeven.click();
			break;
			case "8": 
				BtnEight.click();
			break;
			case "9": 
				BtnNine.click();
			break;
			case "0": 
				BtnZero.click();
			break;
			

			default: System.out.println("Please Enter Valid Number");
				break;
			}
		}
		else if(len!=1)
		{
			String str[]=Num.split("");
			for(int i=0;i<str.length;i++)
			{
				String finalstr = str[i];
				switch (finalstr) {
				case "1": 
					BtnOne.click();
				break;
				case "2": 
					BtnTwo.click();
				break;
				case "3": 
					BtnThree.click();
				break;
				case "4": 
					BtnFour.click();
				break;
				case "5": 
					BtnFive.click();
				break;
				case "6": 
					BtnSix.click();
				break;
				case "7": 
					BtnSeven.click();
				break;
				case "8": 
					BtnEight.click();
				break;
				case "9": 
					BtnNine.click();
				break;
				case "0": 
					BtnZero.click();
				break;
				

				default: System.out.println("Please Enter Valid Number");
					break;
				}
		}
		 }
	}
	public void verifyMainPage()
	{
	   if(BtnOne.isDisplayed())
	   {
		   asserts = new SoftAssert();
		   String demo = BtnOne.getAttribute("text");
		   asserts.assertEquals(demo, "1");
		   System.out.println("successfully verified");
		   
	   }
		
		
	}
	
	public void verifyapplaunch()
	{
		try
		{
		if(BtnOk.isDisplayed())
		   {
			   asserts = new SoftAssert();
			   String demos = BtnOk.getAttribute("text");
			   asserts.assertEquals(demos, "OK");
			   System.out.println("successfully verified");
			   BtnOk.click();
			   asserts.assertAll();
			   
			   
		   }  }
		catch(Exception e)
		{
			   String demos = BtnTwo.getAttribute("text");
			   asserts.assertEquals(demos, "2");
			   System.out.println("successfully verified");
		}
	}
	
	public void clickOperator(String Oper)
	{
	switch (Oper) {
	case "+":
		general.waituntilClickable(BtnAdd);
		BtnAdd.click();
		break;
		
	case "-":
		BtnSub.click();
		break;
		
	case "*":
		BtnMul.click();
		break;
		
	case "/":
		BtnDiv.click();
		break;
		
	case "=":
		BtnEquals.click();
		break;

	default:
		System.out.println("Enter +,-,*,/,=.....Others are Invalid");
		break;
	}
	}
	
	public void finalResultCalculation(String num1,String num2)
	{
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);
		int num5 = num3+num4;
		//System.out.println(num3);
		//System.out.println(num4);
		String finalresult = String.valueOf(num5);
		if(FinalRes.isDisplayed())
		{
			String total = FinalRes.getAttribute("text");
			  asserts = new SoftAssert();
			  System.out.println(total);
			  System.out.println(finalresult);
			   asserts.assertEquals(total, finalresult);
			   System.out.println("successfully verified");
			   asserts.assertAll();
			 
		}

		else
		{
			System.out.println("Element not displayed");
		}
		
	}
	
	
}