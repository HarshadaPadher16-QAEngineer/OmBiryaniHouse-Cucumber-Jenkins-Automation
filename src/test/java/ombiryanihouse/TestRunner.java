package ombiryanihouse;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", // Feature files kuthe aahet
        glue = "ombiryanihouse",                  // Java code kuthe aahe
        plugin = {
                "pretty",                          // Console var vyavasthit mahiti disnyasathi
                "html:target/cucumber-reports.html" // HTML report banvnyasathi
        },
        monochrome = true                          // Output neat disnyasathi
)
public class TestRunner {
    // Ha class rikamaach rahto, fakt varti dilele @Annotations mhatvache aahet.
}