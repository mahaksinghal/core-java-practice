package com.app.utils;

import java.util.ArrayList;
import java.util.List;

import com.app.core.Emp;

public interface GenericUtils {

//	static double computeSum(List <? extends Emp> emps) {
//		double sum = 0;
//		for(Emp e: emps) {
//			sum += e.computeSalary();
//		}
//		return sum;
//	}

	static <T extends Emp> double computeSum(List<T> emps) {
		double sum = 0;
		for (Emp e : emps) {
			sum += e.computeSalary();
		}
		return sum;
	}

//	static void findMax(List<? extends >)

	static <T extends Comparable<? super T>> T findMax(List<T> list)
	// T must implement COMPARABLE i/f
	// Type of the comparable must be either - T or any of its super type
	// ChronoLocalDate - i/f
	// LocalDate - implementation Class
	{
		T max = list.get(0);
		for (T i : list) {
			if (i.compareTo(max) > 0)
				max = i;
		}
		return max;
	}
}
