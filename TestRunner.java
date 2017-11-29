package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@Cucumber.Options(features= "feature", glue ={"Step Defination"})
public class TestRunner {

}
