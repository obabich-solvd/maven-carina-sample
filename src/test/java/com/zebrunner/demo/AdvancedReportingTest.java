package com.zebrunner.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.CurrentTestRun;
import com.zebrunner.agent.core.registrar.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.nio.file.Paths;

@TestLabel(name = "feature", value = "advanced_reporting")
public class AdvancedReportingTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @BeforeSuite(description = "Example of overriding configuration parameters at runtime")
    public void initSuite() {
        LOGGER.info("Set a build for a test run");
        CurrentTestRun.setBuild("1.0-SNAPSHOT");

        LOGGER.info("Set a locale for a test run");
        CurrentTestRun.setLocale("EN_en");

        LOGGER.info("Set a platform for a test run");
        CurrentTestRun.setPlatform("API");
    }

    @Test
    @Maintainer("hpotter")
    public void testWithSpecificMaintainer() {
        LOGGER.info("Example shows how to attach a maintainer for a specific test");
        LOGGER.info("NOTE: The maintainer username should be a valid Zebrunner username, otherwise it will be set to anonymous");
    }

    @Test
    public void testWithDefaultMaintainer() {
        LOGGER.info("Example shows default test maintainer");
    }

    @Test
    @TestLabel(name = "feature", value = "annotation")
    @TestLabel(name = "app", value = {"reporting-service:v1.0", "reporting-service:v1.1"})
    public void testWithLabelsAddedUsingAnnotation() {
        LOGGER.info("Example shows how to add labels using annotation for a specific test");
    }

    @Test
    public void testWithLabelsAddedUsingJavaAPI() {
        LOGGER.info("Example shows how to add labels using Java API for a specific test and a whole test run");
        Label.attachToTest("feature", "java_api");
        Label.attachToTestRun("browser", "chrome");
    }

    @Test
    public void testWithArtifactAndReference() {
        LOGGER.info("Example shows how to attach artifact and reference for a specific test");
        Artifact.attachToTest("simple.txt", Paths.get("src/test/resources/artifacts/simple.txt"));
        Artifact.attachReferenceToTest("Zebrunner", "https://zebrunner.com");

        LOGGER.info("Attach an artifact for a test run");
        Artifact.attachToTestRun("welcome.png", Paths.get("src/test/resources/artifacts/welcome.png"));

        LOGGER.info("Attach an artifact reference for a test run");
        Artifact.attachReferenceToTestRun("Zebrunner documentation", "https://zebrunner.com/documentation/");
    }
}
