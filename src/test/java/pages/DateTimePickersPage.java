package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DateTimePickersPage extends BasePage{
    public DateTimePickersPage(Page page){
        super(page);
    }
    public Locator heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Date & Time Pickers").setExact(true));
    public Locator dateInput = page.locator("input[type='date']");
    public Locator timeInput = page.locator("input[type='time']");
    public Locator dateTimeInput = page.locator("input[type='datetime-local']");
    public Locator monthInput = page.locator("input[type='month']");
    public Locator weekInput = page.locator("input[type='week']");
    public Locator appointmentInput = page.locator("#widget-date");
    public Locator nativeResult = page.locator("#native-result");

    public Locator openCalendarButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Open calendar").setExact(true));
    public Locator calendar = page.locator("#calendar");
    public Locator calendarMonth = page.locator("#calendar-month");
    public Locator previousMonthButton = page.locator("#previous-month");
    public Locator nextMonthButton = page.locator("#next-month");
    public Locator calendarDays = page.locator("#calendar-days");

}
