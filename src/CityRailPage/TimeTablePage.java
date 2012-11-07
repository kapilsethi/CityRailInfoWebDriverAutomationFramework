package CityRailPage;

import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import CityRailPageIds.TimeTablePageIds;

public class TimeTablePage extends BasePage {

	private TimeTablePageIds timeTablePageIds = new TimeTablePageIds(); 

	public TimeTablePage SelectLine(String lineToBeSelected)
	{
		ourAutomationDriver.selectValue(By.id(timeTablePageIds.SelectLine), lineToBeSelected);
		ourAutomationDriver.waitForOptionToGetSelected(timeTablePageIds.SelectLine, lineToBeSelected);
		return this;
	}
	
	public TimeTablePage SelectDirection(String travelDirection)
	{
		ourAutomationDriver.selectValue(By.id(timeTablePageIds.SelectDirection), travelDirection);
		ourAutomationDriver.waitForOptionToGetSelected(timeTablePageIds.SelectDirection, travelDirection);
		return this;
	}
	
	public TimeTablePage SelectLeaveAfterOrArriveBefore(String leaveAfterOrArriveBefore)
	{
		String indexForLeaveAfterOrArriveBefore;
		
		if(leaveAfterOrArriveBefore.equalsIgnoreCase("leave"))
			indexForLeaveAfterOrArriveBefore = "0";
		else
			indexForLeaveAfterOrArriveBefore = "1";

		String idAppenderForLeaveOrArrive = String.format(timeTablePageIds.LeaveArrive) + indexForLeaveAfterOrArriveBefore;
		ourAutomationDriver.findElement(By.id(idAppenderForLeaveOrArrive)).click();
		return this;
	}
	
	public TimeTablePage SelectTravelDay(String travelDay)
	{
		ourAutomationDriver.selectValue(By.id(timeTablePageIds.SelectDay), travelDay);
		return this;
	}
	
	public TimeTablePage SelectTravelHour(String travelHour)
	{
		ourAutomationDriver.selectValue(By.id(timeTablePageIds.SelectHour), travelHour);
		return this;
	}
	
	public TimeTablePage SelectTravelMinute(String travelMin)
	{
		ourAutomationDriver.selectValue(By.id(timeTablePageIds.SelectMin), travelMin);
		return this;
	}
	
	public TimeTablePage SelectDayPart(String travelDayPart)
	{
		ourAutomationDriver.selectValue(By.id(timeTablePageIds.SelectDayPart), travelDayPart);
		return this;
	}
	
	public TimeTablePage ClickOnViewTimeTable()
	{
		ourAutomationDriver.findElement(By.id(timeTablePageIds.TimeTableSearch)).click();
		return this;
	}
	
	public TimeTablePage VerifySearchResult(String lineToBeSelected, String selectedDirection)
	{
		String lineName = "";
		if(lineToBeSelected.equalsIgnoreCase("northern line"))
			lineName = "northern";

		WebElement searchResult = ourAutomationDriver.findElement(By.xpath(String.format(timeTablePageIds.SearchResultHeader, lineName)));
		String expectedSearchHeader = lineToBeSelected + ": " + selectedDirection;
		Assert.assertEquals(expectedSearchHeader, searchResult.getText());
		return this;
	}
	
	public void VerifyLastStationNameInSearchResult(String expectedLastStation)
	{
		WebElement stationNames = ourAutomationDriver.findElement(By.className(timeTablePageIds.StationNames));
		List<WebElement> stationNameTableRows = stationNames.findElements(By.tagName("tr"));
		String actualLastStation = (stationNameTableRows.get(stationNameTableRows.size()-1).getText().toLowerCase());
		Assert.assertEquals(expectedLastStation.toLowerCase(), actualLastStation);
	}
}
