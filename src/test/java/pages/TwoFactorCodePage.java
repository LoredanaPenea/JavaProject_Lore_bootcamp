package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TwoFactorCodePage extends BasePage {

    public TwoFactorCodePage(Page page) {
        super(page);
    }

    public Locator otpCode = page.locator("#otp-code");
    public Locator codeInput = page.locator("input[name='code']");
    public Locator verifyButton = page.locator("form[action='/two_factor/verify'] button[type='submit']");
    public Locator successFlashMessage = page.locator("#flash").getByText("You logged in with two-factor authentication!");

}
