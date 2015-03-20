package com.steps;

import java.text.ParseException;

import org.junit.Assert;

import com.pages.DatePopupPageObject;
import com.pages.VacationTrackerMainPageObject;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class VacationTrackerSteps extends ScenarioSteps {
	private static final long serialVersionUID = -2554212203016046482L;
	VacationTrackerMainPageObject vacationTrackerMainPageObject;
	DatePopupPageObject datePopup;

	@Step
	public void setStartDate(int day, int month, int year) {
		vacationTrackerMainPageObject.setStartDate(day, month, year);
	}

	@Step
	public void setEndDate(int day, int month, int year) {
		vacationTrackerMainPageObject.setEndDate(day, month, year);
	}

	@Step
	public void checkIfStartDateEquals(int day, int month, int year)
			throws ParseException {
		int selectedDay = vacationTrackerMainPageObject.getStartDay();
		int selectedMonth = vacationTrackerMainPageObject.getStartMonth();
		int selectedYear = vacationTrackerMainPageObject.getStartYear();
		System.out.println("Comparing: " + selectedDay + " to " + day + " and "
				+ selectedMonth + " to " + month + " and " + selectedYear
				+ " to " + year + ".");
		Assert.assertTrue("The start date in the DatePicker is not equal to the date given.", (selectedDay == day) && (selectedMonth == month)
				&& (selectedYear == year));
	}

	@Step
	public void checkIfEndDateEquals(int day, int month, int year)
			throws ParseException {
		int selectedDay = vacationTrackerMainPageObject.getEndDay();
		int selectedMonth = vacationTrackerMainPageObject.getEndMonth();
		int selectedYear = vacationTrackerMainPageObject.getEndYear();
		System.out.println("Comparing: " + selectedDay + " to " + day + " and "
				+ selectedMonth + " to " + month + " and " + selectedYear
				+ " to " + year + ".");
		Assert.assertTrue("The end date in the DatePicker is not equal to the date given.",(selectedDay == day) && (selectedMonth == month)
				&& (selectedYear == year));
	}
}
