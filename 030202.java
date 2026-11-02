
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {

        // Run JUnit test class
        Result result = JUnitCore.runClasses(TestJunit.class);

        // Display test failures
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Display final result
        System.out.println("Result == " + result.wasSuccessful());
    }
}
