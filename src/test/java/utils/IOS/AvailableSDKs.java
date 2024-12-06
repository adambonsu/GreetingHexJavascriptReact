package utils.IOS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Refactor into CommandLine class
public class AvailableSDKs {
    private static final Logger logger = LoggerFactory.getLogger(AvailableSDKs.class);
    public static String[] getAvailableSDKs() {
        try {
            Process process = Runtime.getRuntime().exec(new String[] {
                "bash", "-c", "xcrun simctl list runtimes | grep iOS | awk '{print $2}' | sort -V"
            });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();

            if (exitCode != 0) {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                StringBuilder errorOutput = new StringBuilder();
                while ((line = errorReader.readLine()) != null) {
                    errorOutput.append(line).append("\n");
                }
                String errorMessage = "Command failed with exit code " + exitCode + ": " + errorOutput.toString();
                logger.error(errorMessage);
                throw new RuntimeException(errorMessage);
            }
            return output.toString().trim().split("\n");
        } catch (Exception e) {
            logger.error("Exception occurred while fetching available SDKs: {}", e);
            e.printStackTrace();
            return new String[]{"Error occurred: " + e.getMessage()};
        }
    }
}
