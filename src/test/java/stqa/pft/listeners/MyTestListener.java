package stqa.pft.listeners;
import org.openqa.selenium.NoSuchElementException;
import org.testng.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import stqa.pft.appmanager.ApplicationManager;

public class MyTestListener implements ITestListener, IHookable {

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ApplicationManager app = (ApplicationManager) result.getTestContext().getAttribute("app");
        saveScreenshot(app.takeScreenshot());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("ON FINISH ALL TESTS");
        ApplicationManager.generateReports();
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult res) {
        System.out.println("Starting Ihookable");
        callBack.runTestMethod(res);
        if (res.getThrowable() != null) {
            try {
                throw res.getThrowable().getCause();
            } catch (NoSuchElementException e) {
                res.setThrowable(null);
                callBack.runTestMethod(res);
            }catch (Throwable throwable){
                System.out.println("THROWABLE caught some general exception");
            }}
    }
}

