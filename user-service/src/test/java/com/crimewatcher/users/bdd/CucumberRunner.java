package com.crimewatcher.users.bdd;
import io.cucumber.junit.Cucumber;import io.cucumber.junit.CucumberOptions;import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue="com.crimewatcher.users.bdd",plugin={"pretty","summary","html:target/cuke-report.html"})
public class CucumberRunner{}
