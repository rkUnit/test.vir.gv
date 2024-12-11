package utilities;

import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListner {
	
public ExtentSparkReporter sparkReporter;
public ExtentReports extent;
public ExtentTest test;

String repName;
public void onstart(ITestContext testcontext)
{
String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())
repName="Test-Report"+timeStamp+".html";
sparkReporter=new ExtentSparkReporter(".\\reports\\" +repName);

sparkReporter.config().setDocumentTitle("opencart automation report");
sparkReporter.config().setReportName("opencart functional testing");
sparkReporter.config().setTheme(Theme.DARK);

extent=new ExtentReports();
extent.attachReporter(sparkReporter);
extent.setSystemInfo("application", "opencart");
extent.setSystemInfo("Module", "Admin");


}
}