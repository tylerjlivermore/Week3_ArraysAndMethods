package week_3;

import java.text.DecimalFormat;

public class Arrays_and_Methods {

	public static void main(String[] args) {
	//*INITIALIZATION OF VARIABLES (ordered by data type then appearance in code)
		/*	Note: My chosen variable names in first half of assignment ended up being very similar
	  		to the required names in second half of assignment.
			I was not sure what to revise my variables names to that would be distinct yet relevant.
		*/
		int nameLengthsSum = 0;
		//Variable initialization placed outside loops for scope, Double allows decimal for averages
		double agesSum = 0;
		double agesAvg = 0;
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		double namesLengthSum = 0;
		double namesLengthAvg = 0;			
		String namesCombined = "";
		int[] ages = {3, 9, 23, 24, 34, 64, 2, 8, 28, 93}; //1b. new age added: 24
		//Starting array nameLengths with same length as names
		int[] nameLengths = new int[names.length];
	
	//*LOOPS
		//1a. Dynamically subtract first age from last age and print
		int subtractFirstFromLast = (ages[ages.length - 1] - ages[0]); //initialization included here for readability
		System.out.println(subtractFirstFromLast);
		
		//1c. Calculate average of ages
		for (int i = 0; i < ages.length; i++) {
			agesSum += ages[i];
			agesAvg = agesSum / (ages.length);
		}
		System.out.println(agesAvg);
		
		//2a. Find average number of letters in the names
		for (int i = 0; i < names.length; i++) {
			namesLengthSum += names[i].length();
		}
		namesLengthAvg = namesLengthSum / (names.length);;
		//Used decimal formatting to shorten the decimal places of namesLengthAvg
		DecimalFormat df = new DecimalFormat("#.###");
		String formattedAvg = df.format(namesLengthAvg); 
		System.out.println(formattedAvg);  
		
		//2b. Concatenate all the names together, with spaces
		for (int j = 0; j < names.length; j++) {
			namesCombined += " " + names[j]; //could have " " before or after each name
		}
		System.out.println(namesCombined.trim()); //used method trim() to remove leading/trailing space
		
		//5. Iterate through names array and add the lengths of each index to nameLengths array
		for (int k = 0; k < nameLengths.length; k++) {
			nameLengths[k] = names[k].length();
		}
		
		//6. Sum the lengths in nameLengths
		for (int number : nameLengths) {
			nameLengthsSum += number;
		}
		System.out.println(nameLengthsSum);
		
		//These were sample inputs used in method testing
//		System.out.println(concatenateWord("Hello", 4));
//		System.out.println(fullName("Jim", "Rogers"));
//		int[] numRangeTrue = {42, 20, 31, 24};
//		int[] numRangeFalse = {2, 35, 15, 6};
//		System.out.println(sumGreaterThan100(numRangeTrue));
//		System.out.println(sumGreaterThan100(numRangeFalse));
//		double[] arrayToAverage1 = {2.6, 35.45, 15.1, 6.90};
//		System.out.println(averageArrayValues(arrayToAverage1));
//		double[] arrayToAverage2 = {42.78, 20.5, 31.123, 24.9, 11.8, 4.56};
//		System.out.println(compareArrayAverages(arrayToAverage1, arrayToAverage2));
//		System.out.println(willBuyDrink(false, 23.50));
		
		//Input testing for 13. Custom Method:
//		int treeHeight = 52;
//		String treeSpecies = "maple";
//		boolean isTreeOverHouse = false;
//		System.out.println(treesToCut(treeHeight, treeSpecies, isTreeOverHouse));
	}	
	//*METHODS
	//7. Concatenate a string by int number of times
	public static String concatenateWord(String word, int n) {
		int numTimes = 0;
		String newWord = "";
		do {
			newWord += word;
			numTimes++;
		} while (numTimes < n);
		return newWord;
	}
	//8. Create a full name from provided first and last name
	public static String fullName(String firstName, String lastName) {
		String fullName = firstName + " " + lastName;
		return fullName;
	}
	//9. Return TRUE if sum of the array is > 100
	public static boolean sumGreaterThan100(int numRange[]) {
		int sumRange = 0;
		for (int num : numRange) {
			sumRange += num;
		}
		if (sumRange > 100) {
			return true;
		} else {
			return false;
		}
	}
	//10. Average elements of an array
	public static double averageArrayValues(double givenArray[]) {
		double sumOfArray = 0;
		double avgOfArray = 0;
		for (double arrValue : givenArray) {
			sumOfArray += arrValue;
		}
		avgOfArray = sumOfArray / 2;
		return avgOfArray;
	}
	//11. Compares the average of two arrays, greater than
	public static boolean compareArrayAverages(double arr1[], double arr2[]) {
		if (averageArrayValues(arr1) > averageArrayValues(arr2)) { //making use of previously written method
			return true;
		} else {
			return false;
		}
	}
	//12. Determine if a drink can be bought based on if Hot Outside is TRUE and money possessed is > 10.50
	public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		if ( (isHotOutside == true) && (moneyInPocket > 10.50) ) {
			return true;
		} else {
			return false;
		}
	}
	//13. Custom method: Mark trees for removal based on risk to property, species, and height
	public static String treesToCut(int height, String species, boolean overHouse) {
		species.toUpperCase(); //to ignore capitalization the user may use in their input
		String action = "";
		//Conditions ordered to prioritize wishes of the customer
		//If the tree is over the house, must be cut regardless of other factors
		if (overHouse == true) {
			action += "Cut it!";
		//Customer wants to keep birches, if not a danger
		} else if (species.contains("BIRCH")) {
			action += "Leave it.";
		//Anything else over 70ft gets removed
		} else if (height < 70) {
			action += "Leave it.";
		} else {
			action += "Cut it!";
		}
		return action;
	}
}