import com.demoqa.FormTest;
import guru.qa.FileTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

//@SelectPackages({"com.github.allure"})
@SelectClasses(FormTest.class)
@Suite
public class AllTests {
}
