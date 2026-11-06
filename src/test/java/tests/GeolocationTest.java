package tests;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.Geolocation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.GeolocationPage;
import pages.MainPage;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GeolocationTest extends BaseTest {
    @Test
    public void displayGeolocationTest()
    {
        double expectedLatitude = 37.7749;
        double expectedLongitude = -122.4194;

        context.grantPermissions(List.of("geolocation"), new BrowserContext.GrantPermissionsOptions()
                        .setOrigin("https://the-internet.herokuapp.com"));
        context.setGeolocation(new Geolocation(expectedLatitude, expectedLongitude));

        MainPage mainPage = new MainPage(page);
        mainPage.geolocationLink.click();

        GeolocationPage geolocationPage = new GeolocationPage(page);
        geolocationPage.whereAmIButton.click();

        assertThat(geolocationPage.latitude).hasText(String.valueOf(expectedLatitude));
        assertThat(geolocationPage.longitude).hasText(String.valueOf(expectedLongitude));

        assertThat(geolocationPage.googleMapsLink).isVisible();
        String mapsUrl = geolocationPage.googleMapsLink.getAttribute("href");
        Assertions.assertTrue(mapsUrl.contains("maps.google.com/"));

        Assertions.assertTrue(mapsUrl.contains(String.valueOf(expectedLatitude)));
        Assertions.assertTrue(mapsUrl.contains(String.valueOf(expectedLongitude)));

    }
}
