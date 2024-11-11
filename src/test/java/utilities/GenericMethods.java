package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GenericMethods {
	
	private AndroidDriver<MobileElement> driver;
	
	public GenericMethods(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
	
	public void implicitlywait()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void waituntilClickable(MobileElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void FluentlywaitforClickable(MobileElement element)
	{
	FluentWait<AndroidDriver<MobileElement>> wait = new FluentWait<AndroidDriver<MobileElement>>(driver).
			withTimeout(Duration.ofSeconds(30)).
			pollingEvery(Duration.ofSeconds(2)).
			ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	
	

}
