package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetAutomationDriver {
	
	private WebDriver webDriver = new FirefoxDriver();
	
	public WebDriver GetMyAutomationDriver()
	{
		return webDriver;
	}
	
	/*public class OurAutomationDriver implements WebDriver
	{
		
		
		public void selectValue(By by,String valueToBeSelected)
		{
			WebElement selectLine = webDriver.findElement(by);
			List <WebElement> options = selectLine.findElements(By.tagName("option"));
			for (WebElement option : options)
			{
				if(option.getText().contains(valueToBeSelected))
					option.click();
			}
		}	
	}
	
		public void waitForElementPresent(By by)
		{
			WebElement itemToBePresent = webDriver.findElement(by);
			int count;
			for (count=0; count<=60; count++)
			{
				if(itemToBePresent.isDisplayed())
					break;
				else
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		}*/
}
