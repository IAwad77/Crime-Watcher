package com.crimewatcher.reports.bdd;
import io.cucumber.junit.Cucumber;import io.cucumber.junit.CucumberOptions;import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",glue="com.crimewatcher.reports.bdd",plugin={"pretty","summary","html:target/cuke-report.html"})

public class CucumberRunner{}
