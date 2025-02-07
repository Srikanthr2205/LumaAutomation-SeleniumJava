package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = "target/ExtentReports/ExtentReport.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            // Add System Info
            extent.setSystemInfo("QA Engineer", "Srikanth");
            extent.setSystemInfo("Project Name", "LUMA E-Commerce");
            extent.setSystemInfo("Environment", "QA");
        }
        return extent;
    }
}
