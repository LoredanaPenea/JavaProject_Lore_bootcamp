package tests;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pages.FileDownloadPage;
import pages.MainPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileDownloadTests extends BaseTest {

    @Test
    void fileCanBeDownloadedWithCorrectName() {
        MainPage mainPage = new MainPage(page);
        mainPage.fileDownloadLink.click();

        FileDownloadPage fileDownloadPage = new FileDownloadPage(page);
        assertThat(fileDownloadPage.heading).isVisible();
        assertThat(fileDownloadPage.fileLinks.first()).isVisible();
        String fileName = fileDownloadPage.fileLinks.first().innerText().trim();

        Download download = page.waitForDownload(() -> fileDownloadPage.fileLink(fileName).click());
        try {
            assertNull(download.failure(), "Expected the download to complete successfully");
            assertEquals(fileName, download.suggestedFilename());
            assertTrue(Files.isRegularFile(download.path()), "Expected a downloaded file on disk");
        } finally {
            download.delete();
        }
    }

    @Test
    void downloadedFileCanBeSaved(@TempDir Path downloadDirectory) throws IOException {
        MainPage mainPage = new MainPage(page);
        mainPage.fileDownloadLink.click();

        FileDownloadPage fileDownloadPage = new FileDownloadPage(page);
        assertThat(fileDownloadPage.fileLinks.first()).isVisible();

        Download download = page.waitForDownload(() -> fileDownloadPage.fileLinks.first().click());
        try {
            Path savedFile = downloadDirectory.resolve("downloaded-file");
            download.saveAs(savedFile);

            assertNull(download.failure(), "Expected the download to complete successfully");
            assertTrue(Files.isRegularFile(savedFile), "Expected the saved file to exist");
            assertEquals(-1L, Files.mismatch(download.path(), savedFile),
                    "Expected the saved file to match the downloaded bytes");
        } finally {
           download.delete();
        }
    }
}
