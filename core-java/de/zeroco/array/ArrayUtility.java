package de.zeroco.array;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

public class ArrayUtility {
	
	public static void main(String[] args) {
		
		int[] clonedArray = copyElements();
		for (int i : clonedArray) {
			System.out.println("Elements of array :" + i);
		}
		System.out.println("sum of elements: " + addElements());
		System.out.println("largest element in array : " + largestElement());
		System.out.println("smallest element in array : " + smallestElement());
		int[] reversedArray = reverseArray();
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.println("Reversed Elements of array: " + reversedArray[i]);
        }
        int[] sortedArray = ascendingOrder();
        for (int i = 0; i < sortedArray.length; i++) {
        	System.out.println("Ascending order : " + sortedArray[i]);
        }
        int[] orderedArray = decendingOrder();
        for (int i = 0; i < orderedArray.length; i++) {
        	System.out.println("descending order : " + orderedArray[i]);
        }
        int[] uniqueArray = removeDuplicates();
        for (int i = 0; i < uniqueArray.length; i++) {
        	System.out.println("Without duplicates : " + uniqueArray[i]);
        }
        int[] shiftedArray = shiftArray();
        for (int i = 0; i < shiftedArray.length; i++) {
        	System.out.println("shifted array : " + shiftedArray[i]);
        }
        int[] mergedArray = mergeArray();
        for (int i = 0; i < mergedArray.length; i++) {
        	System.out.println("merged array : " + mergedArray[i]);
        }
        System.out.println("Get sum Pair : " + getSumPair());
        System.out.println("Duplicate Elements: " + findDuplicate());
        int[] intersectionArray = getIntersectionArray();
        for (int i = 0; i < intersectionArray.length; i++) {
        	System.out.println("Intersection of arrays : " + intersectionArray[i]);
        }
        int[] array = {5, 4, 3, 2, 1};
        int[] updatedArray = updateArray(array, 3, 0);
        System.out.println("Updated array : " + Arrays.toString(updatedArray));
        int[] sortedArray1 = bubbleSort(array);
        System.out.println("sorted array : " + Arrays.toString(sortedArray1));
        
        
	}
	
	/**
	 * This method copy array elements into another array.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int[] The new array containing the same elements as the original array.
	 * @reviwed by Praveen,
	 */
	public static int[] copyElements() {
        int[] array = {1, 2, 3, 4, 5};
        int[] copiedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copiedArray[i] = array[i];
        }
        return copiedArray; 
    }
	
	/**
	 * This method gives summation of all elements in array.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int The sum of all elements in the array..
	 * @reviwed by Praveen,
	 */
	public static int addElements() {
		int[] array = {1, 2, 3, 4, 5};
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	/**
	 * This method finds largest element in array.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int The largest element in the array.
	 * @reviwed by Praveen,
	 */
	public static int largestElement() {
		int[] array = {1, 2, 3, 4, 5};
		int largest = array[0];
		for (int i = 0; i < array.length; i++) {
			 largest = (largest < array[i]) ? array[i] : largest; 
		}
		return largest;
	}
	
	/**
	 * This method finds smallest element in array.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini.
	 * @return int The smallest element in the array.
	 * @reviwed by Praveen,
	 */
	public static int smallestElement() {
		int[] array = {1, 2, 3, 4, 5};
		int smallest = array[array.length - 1];
		for (int i = 0; i < array.length; i++) {
			smallest = (smallest > array[i]) ? array[i] : smallest;
		}
		return smallest;
	}
	
	/**
	 * This method takes an array of integers and returns a new array with the elements reversed.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini.S
	 * @return int[] The reversed array.
	 * @reviwed by Praveen,
	 */
	public static int[] reverseArray() {
		int[] array = {1, 2, 3, 4, 5};
		int[] reversedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
	        reversedArray[i] = array[array.length - 1 - i]; 
	    }
		return reversedArray;
	}
	
	/**
	 * This method sorts an array of integers in ascending order.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini.S
	 * @return int[] The sorted array in ascending order.
	 * @reviwed by Praveen,
	 */
	public static int[] ascendingOrder() {
		int[] array = {5, 4, 3, 2, 1};
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int n;
				if (array[i] > array[j]) {
					n = array[i];
					array[i] = array[j];
					array[j] = n;
				}
			}
		}
		return array;
	}
	
	/**
	 * This method sorts an array of integers in descending order.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini.S
	 * @return int[] The array sorted in descending order.
	 * @reviwed by Praveen,
	 */
	public static int[] decendingOrder() {
		int[] array = {5, 4, 3, 2, 1};
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int n;
				if (array[i] < array[j]) {
					n = array[i];
					array[i] = array[j];
					array[j] = n;
				}
			}
		}
		return array;
	}
	
	/**
	 * This method removes duplicate elements from the given array, 
     * returning a new array containing only the unique elements.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int[] A new array with the duplicate elements removed.
	 * @reviwed by Praveen,
	 */
	public static int[] removeDuplicates() {
		int[] array = {1, 2, 3, 4, 5, 1, 2};
		int[] sortedArray = new int[array.length];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < sortedArray.length; j++) {
				if (array[i] == sortedArray[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (!isDuplicate) {
				sortedArray[index++] = array[i];
			}
		}
		return Arrays.copyOf(sortedArray, index);
	}
	
	/**
	 * This method shifts all elements of the array one position to the right.
     * The last element of the array moves to the first position.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int[] The array after shifting all elements one position to the right.
	 * @reviwed by Praveen,
	 */
	public static int[] shiftArray() {
		int[] array = {1, 2, 3, 4, 5};
		int[] shiftedArray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				shiftedArray[i + 1] = array[i];
			} else {
				shiftedArray[0] = array[array.length - 1];
			}
		}
		return shiftedArray;
	}
	
	/**
	 * This method merges two arrays into a single array.
     * The elements from both arrays are added in sequence: 
     * the first array's elements are followed by the second array's elements.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int[] A new array that contains the elements of both input arrays.
	 * @reviwed by Praveen,
	 */
	public static int[] mergeArray() {
		int[] firstArray = {1, 2, 3, 4, 5};
		int[] secondArray = {6, 7, 8, 9, 10};
		int[] mergedArray = new int[firstArray.length + secondArray.length];
		for (int i = 0; i < firstArray.length; i++) {
			mergedArray[i] = firstArray[i];
		}
		for (int i = 0; i < secondArray.length; i++) {
			mergedArray[(firstArray.length) + i] = secondArray[i];
		}
		return mergedArray;
	}
	
	/**
	 * This method searches for a pair of consecutive elements in the array 
     * whose sum equals 7. It returns the first pair found as a string.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return String The pair of consecutive elements whose sum is 7, or an empty string if no such pair is found.
	 * @reviwed by Praveen,
	 */
	public static String getSumPair() {
		String res = "";
		int[] array = {1, 2, 3, 4, 5};
		for (int i = 0; i <= array.length - 2; i++) {
			if ( (array[i] + array[i + 1] == 7)) {
				res = array[i] + " " + array[i + 1];
				break;
			}
		}
		return res;
	}
	
	/**
	 * This method finds and returns all the duplicate elements in the given array.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini.S
	 * @return String A string containing the duplicate elements, separated by spaces. If no duplicates are found, it returns an empty string.
	 * @reviewed by Praveen.D
	 */
	public static String findDuplicate() {
	    String res = "";
	    int[] array = {1, 2, 3, 4, 5, 1, 2};
	    int[] repeatedElements = new int[array.length];
	    int index = 0;
	    for (int i = 0; i < array.length; i++) {
	        boolean isDuplicate = false;
	        for (int j = 0; j < index; j++) {
	            if (array[i] == repeatedElements[j]) {
	                isDuplicate = true;
	                break;
	            }
	        }
	        if (isDuplicate) {
	            res += array[i] + " "; 
	        } else {
	            repeatedElements[index++] = array[i];
	        }
	    }
	    return res.trim(); 
	}

	/**
	 * This method finds the intersection of two integer arrays, returning an array
     * containing only the elements that are present in both arrays.
	 * 
	 * @since 17-01-2025
	 * @author Tejaswini
	 * @return int[] An array containing the elements present in both arrays.
	 * @reviewed by Praveen,
	 */
	public static int[] getIntersectionArray() {
		int index = 0;
		int[] firstArray = {1, 2, 3, 4, 5};
		int[] secondArray = {2, 3, 4, 5};
		int[] thridArray = new int[firstArray.length + secondArray.length];
		for (int i = 0; i < firstArray.length; i++) {
			boolean isDuplicate = false;
			for (int j = 0; j < secondArray.length; j++) {
				if (firstArray[i] == secondArray[j]) {
					isDuplicate = true;
					break;
				}
			}
			if (isDuplicate) {
				thridArray[index++] = firstArray[i];
			}
		}
		return Arrays.copyOf(thridArray, index);
	}
	
	/**
	 * Updates the specified index of an array with a given value.
	 * 
	 * @since 21-01-2025
	 * @author Tejaswini.S
	 * @param array of int
	 * @param value
	 * @param index
	 * @return a new array with the updated value at the specified index.
	 * @reviewed by 
	 */
	public static int[] updateArray(int[] array, int value, int index) {
		int[] updatedArray = new int[array.length];
		for (int i = 0; i < updatedArray.length; i++) {
			updatedArray[i] = (i == 0) ? value: array[i];
		}
		return updatedArray;
	}
	
	/**
	 * Sorts an array of integers in ascending order using the bubble sort algorithm.
	 * 
	 * @since 21-01-2025
	 * @author Tejaswini.S
	 * @param array of integer
	 * @return a sorted array of integers in ascending order.
	 * @reviewed by Praveen.D
	 */
	public static int[] bubbleSort(int[] array) {
		int holder;
		for (int i = 0; i < array.length - 1 ; i++) {
			 for (int j = 0; j < array.length - i - 1; j++) {
	                if (array[j] > array[j + 1]) {
	                    holder = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = holder;
	                }
		     }
	    }
		return array;
   }
}
