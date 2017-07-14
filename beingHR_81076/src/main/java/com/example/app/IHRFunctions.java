package com.example.app;

import java.util.List;

public interface IHRFunctions {
	
	public String[] employeeList(String[] listOfEmployees);
	
	public String[] topPerformers(String[] listOfEmployees, List<int[]> parameters);
	
	public String parameterTopper(String[] listOfEmployees, List<int[]> parameters, String parameterType);
	
	public String[] lazyEmployees(String[] listOfEmployees, int[] attendenceList);
}
