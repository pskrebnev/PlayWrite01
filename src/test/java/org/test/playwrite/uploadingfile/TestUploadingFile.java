package org.test.playwrite.uploadingfile;

import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUploadingFile extends Launch {
    Path currentWorkingDir = Paths.get("").toAbsolutePath();
    File folder = new File(currentWorkingDir.normalize() + "/resources/files");
    String url = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple";
    File[] listOfFiles = folder.listFiles();
    String submitBtn = "//input[@type='submit']";
    String filesList = "//div[contains(@class, 'container')]";

    @Test
    public void testUploadingSingleFile() {
        page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(listOfFiles[0].toPath());
        page.frameLocator("#iframeResult").locator(submitBtn).click();

        String uploadedFiles = page.frameLocator("#iframeResult").locator(filesList).innerText();

        boolean isLoaded =
        uploadedFiles.contains(listOfFiles[0].getName());

        System.out.println("File is loaded? " + (isLoaded ? "YES!" : "NO!") + " --> " + uploadedFiles);
    }

    @Test
    public void testPrintingFileNames() {
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.println("File '" + listOfFile.getName() + "'");
            } else if (listOfFile.isDirectory()) {
                System.out.println("Directory '" + listOfFile.getName() + "'");
            }
        }
        System.out.println("And the first file is = '" + listOfFiles[0].getName() + "'");
    }

    @Test
    public void testUploadingMultipleFiles() {

            page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(new Path[] {

                    Paths.get("./src/test/resources/files/IMG-6873.jpg"),
                    Paths.get("./src/test/resources/files/IMG-6874.jpg")});



    }

    @BeforeClass
    public void set() {
        prepare();
        page.navigate(url);
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
