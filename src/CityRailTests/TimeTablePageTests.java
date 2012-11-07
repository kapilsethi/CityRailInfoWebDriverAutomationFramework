package CityRailTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CityRailPage.BasePage;
import CityRailPage.TimeTablePage;

public class TimeTablePageTests
{
	private BasePage basePage = new BasePage();
	
	@BeforeTest
	public void SetUp()
	{
		basePage.OpenCityRailHomePage();
	}
	
	@AfterTest
	public void TearDown()
	{
		basePage.CloseCityRail();
	}
	
	@Test
	public void SearchTrainTimeTable()
	{
		String lineName = "Northern Line";
		String direction = "City to Hornsby or Epping";
		
		new TimeTablePage().SelectLine(lineName).SelectDirection(direction).SelectLeaveAfterOrArriveBefore("Leave").
		SelectTravelDay("Tomorrow").SelectTravelHour("09").SelectTravelMinute("15").SelectDayPart("pm").
		ClickOnViewTimeTable().VerifySearchResult(lineName, direction).VerifyLastStationNameInSearchResult("hornsby");
	}
}
