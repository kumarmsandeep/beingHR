package com.example.app;

import java.util.ArrayList;
import com.example.app.*;

public class App 
{	
	public static String[] performanceParameters = {"Creativity","Communication","TechnicalSkills","PersonalHabits","TakeInitiative"};
	
	public static String[] listOfEmployees = {"Varun","Monti","Shalini","kuldeep","Arun"};
	
	public static int[] Varun = {94,97,21,71,80};
	public static int[] Monti = {95,90,11,80,81};
	public static int[] Shalini = {90,91,20,71,72};
	public static int[] Kuldeep = {78,77,18,90,92};
	public static int[] Arun = {71,71,21,78,98};
	
	public static int[] attendenceList = {21,11,20,18,21};
	
	public static ArrayList<int[]> parameters = new ArrayList<int[]>();
	
    public static void main( String[] args ) { 	
    	parameters.add(Varun);
    	parameters.add(Monti);
    	parameters.add(Shalini);
    	parameters.add(Kuldeep);
    	parameters.add(Arun);
    	
        HR hr = new HR();
        
        hr.employeeList(listOfEmployees);
        hr.topPerformers(listOfEmployees, parameters);
        hr.parameterTopper(listOfEmployees, parameters, performanceParameters[0]);
        hr.lazyEmployees(listOfEmployees, attendenceList);
        
    }
}
