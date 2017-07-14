package com.example.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HR implements IHRFunctions {

	public String[] employeeList(String[] listOfEmployees) {
		String[] clone = listOfEmployees.clone();
		Arrays.sort(clone, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		});
		return clone;
	}

	public String[] topPerformers(String[] listOfEmployees, List<int[]> parameters) {
		String topPerformers[] = new String[3];

		String[] performanceParameters = App.performanceParameters;
		Map<String, Integer> scores = new HashMap<String, Integer>();
		for (int i = 0; i < performanceParameters.length; i++) {
			String[] parameterToppers = parameterToppers(listOfEmployees, parameters, performanceParameters[i],
					listOfEmployees.length);

			for (int scoreIndex = 0; scoreIndex < parameterToppers.length; scoreIndex++) {
				Integer integer = scores.get(parameterToppers[scoreIndex]);
				if (integer == null) {
					integer = 0;
				}
				integer += (topPerformers.length - scoreIndex);
				scores.put(parameterToppers[scoreIndex], integer);
			}
		}
		ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(scores.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> v1, Entry<String, Integer> v2) {
				return v1.getValue() > v2.getValue() ? -1 : v1.getValue() < v2.getValue() ? +1 : 0;
			}
		});
		int i = 0;
		for (Entry<String, Integer> entry : list) {
			if (i < topPerformers.length) {
				topPerformers[i] = entry.getKey();
				i++;
			} else {
				break;
			}
		}

		return topPerformers;
	}

	private int getParameterIndex(String parameterType) {
		String[] performanceParameters = App.performanceParameters;
		for (int i = 0; i < performanceParameters.length; i++) {
			if (parameterType.equals(performanceParameters[i])) {
				return i;
			}
		}
		return -1;
	}

	private String[] parameterToppers(String[] listOfEmployees, List<int[]> parameters, String parameterType,
			int count) {
		Map<String, Integer> employeeDetails = new TreeMap<String, Integer>();
		int parameterIndex = getParameterIndex(parameterType);
		if (parameterIndex < 0) {
			return null;
		}
		for (int i = 0; i < listOfEmployees.length; i++) {
			employeeDetails.put(listOfEmployees[i], parameters.get(i)[parameterIndex]);
		}
		List<Map.Entry<String, Integer>> sorted = new ArrayList<Map.Entry<String, Integer>>(employeeDetails.entrySet());
		Collections.sort(sorted, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> v1, Entry<String, Integer> v2) {
				return v1.getValue() > v2.getValue() ? -1 : v1.getValue() < v2.getValue() ? +1 : 0;
			}
		});

		String topPerformers[] = new String[count];
		int i = 0;
		for (Entry<String, Integer> entry : sorted) {
			if (i < count) {
				topPerformers[i] = entry.getKey();
				i++;
			} else {
				break;
			}
		}

		return topPerformers;
	}

	public String parameterTopper(String[] listOfEmployees, List<int[]> parameters, String parameterType) {
		return parameterToppers(listOfEmployees, parameters, parameterType, 1)[0];
	}

	public String[] lazyEmployees(String[] listOfEmployees, int[] attendenceList) {
		Map<String, Integer> employeeDetails = new TreeMap<String, Integer>();
		for (int i = 0; i < listOfEmployees.length; i++) {
			employeeDetails.put(listOfEmployees[i], attendenceList[i]);
		}
		Set<Map.Entry<String, Integer>> sorted = new TreeSet<Map.Entry<String, Integer>>(
				new Comparator<Map.Entry<String, Integer>>() {

					public int compare(Entry<String, Integer> v1, Entry<String, Integer> v2) {
						return v1.getValue() < v2.getValue() ? -1 : v1.getValue() > v2.getValue() ? +1 : 0;
					}
				});
		sorted.addAll(employeeDetails.entrySet());
		String topPerformers[] = new String[3];
		int i = 0;
		for (Entry<String, Integer> entry : sorted) {
			if (i < topPerformers.length) {
				topPerformers[i] = entry.getKey();
				i++;
			} else {
				break;
			}
		}
		return topPerformers;
	}

}
