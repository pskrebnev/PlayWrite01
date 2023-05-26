package org.test.playwrite.uploadingfile;

import org.test.playwrite.prepare.Launch;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TestUploadingFile extends Launch {
    String filesLocation = "";
    ArrayList<String> multipleFiles = new ArrayList<>();


    @Test
    public void testUploadingSingleFile() {
        Path currentWorkingDir = Paths.get("").toAbsolutePath();
        System.out.println("WD: " + currentWorkingDir.normalize());


        File folder = new File(currentWorkingDir.normalize().toString() + "./resources/files");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

    }

    @Test
    public void testUploadingMultipleFiles() {


    }

    @BeforeClass
    public void set() {
        prepare();
    }

    @AfterClass
    public void down() {
        tierDown();
    }
}
