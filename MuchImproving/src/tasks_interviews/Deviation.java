package tasks_interviews;

import java.util.Arrays;

public class Deviation {

	public static void main(String[] args) {
		assert find_deviation(new Integer[] { 6, 9, 4, 7, 4, 1 }, 3) == 6;
	}

	public static int find_deviation(Integer[] v, Integer d) {
		int[] extremes = getExtremes(0, (int) d, v);
		int min = extremes[0];
		int max = extremes[1];
		int maxDeviation = max - min;
		int currentDeviation = maxDeviation;

		for (int i = 1; i < v.length - d + 1; i++) {
			if (v[i - 1] == min || v[i - 1] == max) {
				extremes = getExtremes(i, (int) d, v);
				min = extremes[0];
				max = extremes[1];
			} else {
				if (v[i + d - 1] > max) {
					max = v[i + d - 1];
				} else if (v[i + d - 1] < min) {
					min = v[i + d - 1];
				}
			}

			currentDeviation = max - min;
			if (currentDeviation > maxDeviation)
				maxDeviation = currentDeviation;
		}
		return maxDeviation;
	}

	private static int[] getExtremes(int startIndex, int d, Integer[] v) {
		int[] sequence = new int[d];
		for (int i = startIndex; i < startIndex + d; i++) {
			sequence[i - startIndex] = v[i];
		}
		Arrays.sort(sequence);
		return new int[] { sequence[0], sequence[d - 1] };
	}
}

// Challenge 1: Deviation
// Given an array of integer elements and an integer d please consider all the
// sequences of d consecutive elements in the array. For each sequence we
// compute the difference between the maximum and the minimum value of the
// elements in that sequence and name it the deviation.
// Your task is to
// write a function that computes the maximum value among the deviations of all
// the sequences considered above
// print the value the standard output (stdout)
// Note that your function will receive the following arguments:
// v
// which is the array of integers
// d
// which is an integer value giving the length of the sequences
// Data constraints
// the array will contain up to 100,000 elements
// all the elements in the array are integer numbers in the following range: [1,
// 231 -1]
// the value of d will not exceed the length of the given array
// Efficiency constraints
// your function is expected to print the result in less than 2 seconds
// Example
// Input Output
// v: 6, 9, 4, 7, 4, 1
// d: 3
// 6
// Explanation
// The sequences of length 3 are:
// 6 9 4 having the median 5 (the minimum value in the sequence is 4 and the
// maximum is 9)
// 9 4 7 having the median 5 (the minimum value in the sequence is 4 and the
// maximum is 9)
// 7 4 1 having the median 6 (the minimum value in the sequence is 1 and the
// maximum is 7)
// The maximum value among all medians is 6
// class MyClass {
// public static void find_deviation(Integer[] v, Integer d) {}

// Challenge 3: City Roads
// You are living in a country with N cities. Each city is identified by an
// unique integer ID in the [1..N] range. The cities are connected by M
// bidirectional roads. All the roads have the same length.
// Given the ID of your home city and the ID of a destination city
// Your task is to
// write a function that prints to the standard output (stdout) the minimum
// number of roads you need to travel in order to reach the destination city.
// the destination city will always be accessible from your home city.
// Note that your function will receive the following arguments:
// N
// which is an integer number giving the number of cities
// home_city
// which is an integer number giving the ID of your home city
// dest_city
// which is an integer number giving the ID of the destination city
// firstCityRoads
// which is an array of integers giving the ID of the first city connected by
// each road
// secondCityRoads
// which is an array of integers giving the ID of the second city connected by
// each road
// The ith road connects the ith city in the firstCityRoad array and the ith
// city in the secondCityRoad array.
// Data constraints
// the number of cities will not exceed 5000
// the number of roads will not exceed 100000
// Efficiency constraints
// your function is expected to print the result in less than 2 seconds
// Example
// Input Output
// N: 7
// home_city: 1
// dest_city: 4
// firstCityRoads: [1, 2, 3, 2, 5]
// secondCityRoads: [3, 3, 4, 4, 6]
// 2
// Explanation
// For the input presented above we have:
// 7 cities identified by IDs=1,2,3,4,5,6,7
// 5 roads connecting the following pairs of cities: (1,3), (2,3), (3,4), (2,4),
// (5,6)
// from your home city ID=1 you can reach the destination city ID=4 taking
// either the 1, 3, 4 route or 1, 3, 2, 4 route
// the 1, 3, 4 route requires you to travel two roads (1,3) and (3,4)
// the 1, 3, 2, 4 route requires you to travel three roads (1,3), (3,2) and
// (2,4)
// the first route is the shortest one requiring you to travel only 2 roads
// public static void find_city(Integer n, Integer home_city, Integer dest_city,
// Integer[] firstCityRoads, Integer[] secondCityRoads) {}
//
//
// Challenge 4: Maximum Difference
// Given an array of integer elements, a subsequence of this array is a set of
// consecutive elements from the array (i.e: given the array v: [7, 8, -3, 5,
// -1], a subsequence of v is 8, -3, 5)
// Your task is to
// write a function that finds a left and a right subsequence of the array that
// satisfy the following conditions
// the two subsequences are unique (they don't have shared elements)
// the difference between the sum of the elements in the right subsequence and
// the sum of the elements in the left subsequence is maximum
// print the difference to the standard output (stdout)
// Note that your function will receive the following arguments:
// v
// which is the array of integers
// Data constraints
// the array has at least 2 and at most 1,000,000 numbers
// all the elements in the array are integer numbers in the following range:
// [-1000, 1000]
// Efficiency constraints
// your function is expected to print the result in less than 2 seconds
// Example
// Input Output
// v: 3, -5, 1, -2, 8, -2, 3, -2, 1
// 15
// Explanation
// The left sequence is : -5, 1, -2 and the right sequence is: 8, -2, 3.
// public static void maxdiff(Integer[] v) {}
//
// Challenge 5: Order Task
// You are given a set of tasks which are uniquely identified by integer IDs and
// a set of dependencies that define which tasks must be executed prior to
// others.
// Your task is to
// write a function that orders the tasks so that all dependencies are satisfied
// print to the standard output (stdout) all ordered task IDs separated by a
// white space (on a single line)
// Note that your function will receive the following arguments:
// dependencyFirst
// which is an array of integers giving the ID of the task that needs to be
// executed first in each dependency
// dependencySecond
// which is an array of integers giving the ID of the task that needs to be
// executed second in each dependency
// totalNumTasks
// which is an integer value giving the total number of tasks in the set
// The ith dependency is described as follows: the ith task in dependencyFirst
// must be executed prior to the ith task in dependencySecond.
// Data constraints
// the number of tasks in each collection will not be higher than 10,000
// within a collection of N tasks all the IDs are integers in the [1,N] range
// for a given set of tasks there may be multiple ways of ordering it to satisfy
// the dependencies and any of them is accepted as a correct solution
// Efficiency constraints
// your function is expected to print the result in less than 2 seconds
// Example
// Input Output
// dependencyFirst: 3, 1, 2
// dependencySecond: 2, 2, 4
// num_total_tasks: 6
// 3 1 5 2 4 6
// Explanation
// The set contains 6 tasks and they will be identified by IDs=1,2,3,4,5,6
// Task 3 must be executed prior to task 2, task 1 must be executed prior to
// task 2 and task 2 must be executed prior to task 4
// One order that satisfies the three dependencies is: 3, 1, 5, 2, 4, 6
// public static void order_tasks(Integer[] dependencyFirst, Integer[]
// dependencySecond, Integer totalNumTasks) {}