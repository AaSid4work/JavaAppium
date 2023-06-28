import Tests.ArticleTests;
import Tests.SavedArticlesTests;
import Tests.SearchTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
        ArticleTests.class,
        SavedArticlesTests.class,
        SearchTests.class
})
public class AndroidSuite {
}
