package tests;

import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import pages.FileUploadPage;
import pages.MainPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUploadTests extends BaseTest {

    @Test
    void fileCanBeUploaded(@TempDir Path uploadDirectory) throws IOException {
        Path uploadFile = Files.createTempFile(uploadDirectory, "codex-upload-", ".txt");
        Files.writeString(uploadFile, "File upload test content.");

        MainPage mainPage = new MainPage(page);
        mainPage.fileUploadLink.click();

        FileUploadPage fileUploadPage = new FileUploadPage(page);
        assertThat(fileUploadPage.heading).isVisible();
        fileUploadPage.fileInput.setInputFiles(uploadFile);
        fileUploadPage.uploadBtn.click();

        assertThat(fileUploadPage.successHeading).isVisible();
        assertThat(fileUploadPage.uploadedFiles).hasText(uploadFile.getFileName().toString());
    }

    @Test
    void fileWithSpacesInNameCanBeUploadedUsingFileChooser(@TempDir Path uploadDirectory) throws IOException {
        Path uploadFile = Files.createTempFile(uploadDirectory, "codex upload with spaces ", ".txt");
        Files.writeString(uploadFile, "File chooser upload test content.");

        MainPage mainPage = new MainPage(page);
        mainPage.fileUploadLink.click();

        FileUploadPage fileUploadPage = new FileUploadPage(page);
        assertThat(fileUploadPage.heading).isVisible();
        FileChooser fileChooser = page.waitForFileChooser(() -> fileUploadPage.fileInput.click());
        fileChooser.setFiles(uploadFile);
        fileUploadPage.uploadBtn.click();

        assertThat(fileUploadPage.successHeading).isVisible();
        assertThat(fileUploadPage.uploadedFiles).hasText(uploadFile.getFileName().toString());
    }

    @Test
    void uploadWithoutFileShowsServerError() {
        MainPage mainPage = new MainPage(page);
        mainPage.fileUploadLink.click();

        FileUploadPage fileUploadPage = new FileUploadPage(page);
        assertThat(fileUploadPage.heading).isVisible();
        assertThat(fileUploadPage.fileInput).hasValue("");

        // Do not select a file; click Upload directly.
        fileUploadPage.uploadBtn.click();

        assertThat(fileUploadPage.successHeading).not().isVisible();
        assertThat(fileUploadPage.errorHeading).isVisible();
        assertThat(fileUploadPage.uploadedFiles).not().isVisible();
    }
}
