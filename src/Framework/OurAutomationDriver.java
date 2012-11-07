package Framework;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class OurAutomationDriver implements WebDriver {
	
	public static WebDriver webDriver = new GetAutomationDriver().GetMyAutomationDriver();
	
	public void selectValue(By by,String valueToBeSelected)
	{
		List <WebElement> options = webDriver.findElement(by).findElements(By.tagName("option"));
		for (WebElement option : options)
		{
			if(option.getText().contains(valueToBeSelected))
			{
				option.click();
				break;
			}
		}
	}
	
	public void waitForOptionToGetSelected(final String elementId, final String textToBePresent)
	{
		ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
		      public Boolean apply(WebDriver d) {
		    	Select selectedValue = new Select(webDriver.findElement(By.id(elementId)));
		        return Boolean.valueOf(selectedValue.getFirstSelectedOption().getText().equalsIgnoreCase(textToBePresent));
		      }
		    };
		   
		    //max wait time is 30 seconds
		   WebDriverWait wait = new WebDriverWait(webDriver, 30);
		   wait.until(e);
	}
	
	@Override
	public void close() {
		webDriver.close();
	}

	@Override
	public WebElement findElement(By arg0) {
		return webDriver.findElement(arg0);
	}

	@Override
	public List<WebElement> findElements(By arg0) {
		return webDriver.findElements(arg0);
	}

	@Override
	public void get(String arg0) {
		webDriver.get(arg0);
	}

	@Override
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return webDriver.getPageSource();
	}

	@Override
	public String getTitle() {
		return webDriver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return webDriver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return webDriver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return webDriver.manage();
	}

	@Override
	public Navigation navigate() {
		return webDriver.navigate();
	}

	@Override
	public void quit() {
		webDriver.quit();
	}

	@Override
	public TargetLocator switchTo() {
		return webDriver.switchTo();
	}
}
