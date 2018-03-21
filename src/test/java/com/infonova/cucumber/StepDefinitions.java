package com.infonova.cucumber;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import cucumber.api.java8.En;

public class StepDefinitions implements En {

    static com.infonova.cucumber.PersonRepository SYSTEM = new com.infonova.cucumber.PersonRepository();

    public StepDefinitions() {

        Given("an empty repository", () -> assertEquals(0, SYSTEM.count()));

        Given("a repository", () -> assertTrue(SYSTEM.count() > 0));

        When("I create a new Person named '(.*)' with the system",
                (String name) -> SYSTEM.create(new com.infonova.cucumber.PersonModel(name)));

        Then("I should have Person named '(.*)' in the repository",
                (String name) -> assertNotNull(SYSTEM.read(name)));
    }
}
