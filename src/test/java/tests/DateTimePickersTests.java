package tests;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DateTimePickersPage;
import pages.MainPage;

public class DateTimePickersTests extends BaseTest{
    @Test
    public void dateTimePickersTests(){
        MainPage mainPage = new MainPage(page);
        mainPage.datetimePickersLink.click();

        DateTimePickersPage datetimePickersPage = new DateTimePickersPage(page);
        PlaywrightAssertions.assertThat(datetimePickersPage.heading).isVisible();

        datetimePickersPage.dateInput.fill("2027-04-15");
        datetimePickersPage.timeInput.fill("13:45");
        datetimePickersPage.dateTimeInput.fill("2026-11-10T15:36");
        datetimePickersPage.monthInput.fill("2026-10");
        datetimePickersPage.weekInput.fill("2026-W46");

        PlaywrightAssertions.assertThat(datetimePickersPage.dateInput).hasValue("2027-04-15");
        PlaywrightAssertions.assertThat(datetimePickersPage.timeInput).hasValue("13:45");
        PlaywrightAssertions.assertThat(datetimePickersPage.dateTimeInput).hasValue("2026-11-10T15:36");
        PlaywrightAssertions.assertThat(datetimePickersPage.monthInput).hasValue("2026-10");
        PlaywrightAssertions.assertThat(datetimePickersPage.weekInput).hasValue("2026-W46");

        PlaywrightAssertions.assertThat(datetimePickersPage.nativeResult)
                .hasText("date: 2027-04-15, time: 13:45, datetime: 2026-11-10T15:36, month: 2026-10, week: 2026-W46");

    }

    @Test
    public void dateTimePickersCalendarTests(){
        MainPage mainPage = new MainPage(page);
        mainPage.datetimePickersLink.click();

        DateTimePickersPage datetimePickersPage = new DateTimePickersPage(page);
        PlaywrightAssertions.assertThat(datetimePickersPage.heading).isVisible();

        PlaywrightAssertions.assertThat(datetimePickersPage.appointmentInput).isVisible();
        PlaywrightAssertions.assertThat(datetimePickersPage.appointmentInput).not().isEditable();

        datetimePickersPage.openCalendarButton.click();
        PlaywrightAssertions.assertThat(datetimePickersPage.calendar).isVisible();
        PlaywrightAssertions.assertThat(datetimePickersPage.calendarMonth).hasText("November 2026");
        PlaywrightAssertions.assertThat(datetimePickersPage.previousMonthButton).isVisible();
        PlaywrightAssertions.assertThat(datetimePickersPage.nextMonthButton).isVisible();
        datetimePickersPage.calendarDays.locator("button[data-date='2026-11-15']").click();
        PlaywrightAssertions.assertThat(datetimePickersPage.appointmentInput).hasValue("2026-11-15");
        PlaywrightAssertions.assertThat(datetimePickersPage.calendar).isHidden();
        //System.out.println(datetimePickersPage.openCalendarButton.getAttribute("aria-expanded"));
       //PlaywrightAssertions.assertThat(datetimePickersPage.openCalendarButton).hasAttribute("aria-expanded", "false");
    }
}
