package com.palladiumgroup.lamiscore;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Slf4j
public class ModuleStarter {

    public void startModule(String moduleFilePath) throws IOException {
        // Ensure the JAR file exists
        File jarFile = new File(moduleFilePath);
        if (!jarFile.exists()) {
            throw new IllegalArgumentException("Module JAR file does not exist.");
        }

        // Prepare the command to start the JAR
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", moduleFilePath);

        // Set the working directory to the directory containing the JAR file
        processBuilder.directory(jarFile.getParentFile());

        // Start the process
        Process process = processBuilder.start();

        // Optionally, you can wait for the process to finish
        try {
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                log.info("Module started successfully.");
            } else {
                log.info("Module failed to start. Exit code: " + exitCode);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
