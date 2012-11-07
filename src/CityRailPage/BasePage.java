package CityRailPage;

import Framework.OurAutomationDriver;

public class BasePage {
	public OurAutomationDriver ourAutomationDriver = new OurAutomationDriver();
	
	public void OpenCityRailHomePage()
	{
		ourAutomationDriver.navigate().to("http://www.cityrail.info");
	}
	
	public void CloseCityRail()
	{
		ourAutomationDriver.close();
	}
} 
