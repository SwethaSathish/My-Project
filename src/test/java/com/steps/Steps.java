package com.steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	int a;
	int b;
	int sum;
	
	@Given("I have two  numbers {int} and {int}")
	public void i_have_two_numbers_and(Integer int1, Integer int2) {
	   a = int1;
	   b = int2;
	}

	@When("I added both number")
	public void i_added_both_number() {
	   sum = a + b;
	}

	@Then("I verify result is {int}")
	public void i_verify_result_is(Integer int1) {
		Assert.assertEquals(sum, int1);
	}

	
	@Given("I am background")
	public void i_am_background() {
	    System.out.println("I am background");
	}


}
