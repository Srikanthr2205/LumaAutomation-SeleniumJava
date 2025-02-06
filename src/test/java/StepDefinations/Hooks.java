package StepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import PageObjects.BaseClass;

public class Hooks {
    BaseClass base = new BaseClass(); // Load properties

    @Before
    public void setup() {
        System.out.println("Running @Before Hook: Initializing Browser and Opening URL");
        base.initializeBrowser();
        base.openUrl();
    }

    @After
    public void teardown(Scenario scenario) {
        System.out.println("Running @After Hook: Closing Browser");
        base.teardown(scenario); // ✅ Calls teardown from BaseClass
    }
}
