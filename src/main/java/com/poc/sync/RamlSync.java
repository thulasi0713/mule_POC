package com.poc.sync;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class RamlSync {

    public static String downloadRaml() {

        try {

            String sourceUrl =
                "https://raw.githubusercontent.com/Hema-0111/Automatic_studio_update/main/student_data.raml";

            // CloudHub-safe temp directory
            String tempDir = System.getProperty("java.io.tmpdir");

            Path targetFile = Paths.get(tempDir, "student_data.raml");

            Files.copy(
                new URL(sourceUrl).openStream(),
                targetFile,
                StandardCopyOption.REPLACE_EXISTING);

            System.out.println("RAML downloaded successfully");
            System.out.println("Downloaded to: " + targetFile.toAbsolutePath());

            return "SUCCESS : " + targetFile.toAbsolutePath();

        } catch (Exception e) {

            e.printStackTrace();

            return "FAILED : " + e.getMessage();
        }
    }
}