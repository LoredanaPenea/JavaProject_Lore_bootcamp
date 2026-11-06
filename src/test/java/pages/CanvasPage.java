package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class CanvasPage extends BasePage{
    public CanvasPage(Page page){
        super(page);
    }

    public Locator canvasHeading = page.getByRole(AriaRole.HEADING,
            new Page.GetByRoleOptions().setName("Canvas"));

    public Locator instructions = page.getByText("Click inside the canvas to draw a dot.");

    public Locator canvas = page.locator(".example canvas");

    public Locator emptyStateText = page.getByText("Nothing yet");
    public Locator canvasLog = page.locator("#canvas-log");
    //public Locator canvasLog = page.getByText("Submitted:");

    public String getCanvasImageData() {
        return (String) canvas.evaluate("(canvas) => canvas.toDataURL()");
    }

    public void drawPointAndTypeText(String text) {
        // Click the canvas to draw a point, then click the point.
        Locator.ClickOptions centerClick = new Locator.ClickOptions().setPosition(100, 75);

        canvas.click(centerClick);
        canvas.click(centerClick);

        page.keyboard().type(text);
        page.keyboard().press("Enter");
    }

}

