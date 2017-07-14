package com.example.app;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	
	@Test
	public void testEmployeeList() {
		HR obj = new HR();
		Assert.assertArrayEquals(new String[] { "Arun", "Kuldeep", "Monti", "Shalini", "Varun" }, obj.employeeList(App.listOfEmployees));
	}

	@Test
	public void testTopPerformers() {
		HR obj = new HR();
		ArrayList<int[]> parameters = new ArrayList<int[]>();
		parameters.add(App.Varun);
		parameters.add(App.Monti);
		parameters.add(App.Shalini);
		parameters.add(App.Kuldeep);
		parameters.add(App.Arun);
		String[] topPerformers = obj.topPerformers(App.listOfEmployees, parameters);
		Assert.assertArrayEquals(new String[] { "Monti", "Varun", "Kuldeep" }, topPerformers);
	}

	@Test
	public void testParameterTopper() {
		HR obj = new HR();
		ArrayList<int[]> parameters = new ArrayList<int[]>();
		parameters.add(App.Varun);
		parameters.add(App.Monti);
		parameters.add(App.Shalini);
		parameters.add(App.Kuldeep);
		parameters.add(App.Arun);
		Assert.assertEquals("Monti",
				obj.parameterTopper(App.listOfEmployees, parameters, App.performanceParameters[0]));
	}

	@Test
	public void testLazyEmployees() {
		HR obj = new HR();
		String[] lazyEmployees = obj.lazyEmployees(App.listOfEmployees, App.attendenceList);
		
		Assert.assertArrayEquals(new String[] { "Monti", "Kuldeep", "Shalini" },
				lazyEmployees);
	}

}
