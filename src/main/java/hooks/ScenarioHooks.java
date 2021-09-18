package hooks;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class ScenarioHooks {

    private static Scenario scenario;
    private Step step;

    @Before(order = 1)
    public void KeepScenario(Scenario scenario) {
        ScenarioHooks.scenario = scenario;
        this.setScenario(scenario);
    }

    public void setScenario(Scenario scenario) {
        ScenarioHooks.scenario = scenario;
    }

    public static Scenario getScenario() {
        return scenario;
    }


    @AfterStep
    public void as(Scenario scenario) throws IOException, InterruptedException {
        scenario.attach(AppManagement.getScreenshot(), "image/png", "screenshot name");
    }
}
