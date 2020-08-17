package com.Kayak.Listener;

import org.junit.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import com.Kayak.StepDefinitions.Stepdefinition;
import com.Kayak.poFlight.poFlight;

public class TestRunner{

  public static void main(String args[]) {
   System.out.println("TESTRUNNER");
	  JUnitCore runner = new JUnitCore();
	runner.addListener(new Listener());
	runner.run(Stepdefinition.class);
	    }
	
	 /*public TestRunner(Class<?> klass) throws InitializationError {
	        super(klass);
	    }
	 
	    @Override
	    public void run (RunNotifier notifier){
	        System.out.println("Executing run()");
	        //Add Listener. This will register our JUnit Listener.
	        notifier.addListener(new Listener());
	 
	        //Get each test notifier
	        EachTestNotifier testNotifier = new EachTestNotifier(notifier,
	                getDescription());
	        try {
	            //In order capture testRunStarted method
	            //at the very beginning of the test run, we will add below code.
	            //Invoke here the run testRunStarted() method
	            notifier.fireTestRunStarted(getDescription());
	            Statement statement = classBlock(notifier);
	            statement.evaluate();
	        } catch (AssumptionViolatedException e) {
	            testNotifier.fireTestIgnored();
	        } catch (StoppedByUserException e) {
	            throw e;
	        } catch (Throwable e) {
	            testNotifier.addFailure(e);
	        }
	    }*/

}
