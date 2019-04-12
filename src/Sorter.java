//**************************************************************************************************
// CLASS: Sorter (Sorter.java)
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring B 2019
// Project Number: 3
//
// AUTHOR: Vincent Hoang, vnhoang, vnhoang@asu.edu
//**************************************************************************************************

import java.util.ArrayList;

/**
 * The sorter class provides a static method sort() to sort an ArrayList of Student objects alphabetically
 * by their last names. Sorting is done via quick sort.
 */
public class Sorter {

    /**
     * swap()
     *
     * Swaps element located at pLeftIndex with the element located at pRightIndex
     *
     * @param pList the list to perform the action on
     * @param pLeftIndex the index of the left item to be swapped
     * @param pRightIndex the index of the right item to be swapped
     */
    private static void swap(ArrayList<Student> pList, int pLeftIndex, int pRightIndex) {
        Student temp = pList.get(pLeftIndex);

        pList.set(pLeftIndex, pList.get(pRightIndex));
        pList.set(pRightIndex, temp);
    }


    /**
     * partition()
     *
     * Partitions the elements of the list so that all the elements found in the left partition half is less than those
     * found in the right partition half
     *
     * @param pList the list to perform the action on
     * @param start the starting position of the list (initially index of 0, or first element in list)
     * @param end the starting position of the list (initially index of last element in the list, or list.size() - 1)
     * @return the right index of the partitioned list.
     */
    private static int partition(ArrayList<Student> pList, int start, int end) {
        Student pivot = pList.get(start);

        int leftIndex = start - 1;
        int rightIndex = end + 1;

        while (leftIndex < rightIndex) {
            leftIndex++;

            while (pList.get(leftIndex).compareTo(pivot) < 0) {
                leftIndex++;
            }

            rightIndex--;
            while (pList.get(rightIndex).compareTo(pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex < rightIndex) {
                swap(pList, leftIndex, rightIndex);
            }
        }

        return rightIndex;
    }


    /**
     * quickSort()
     *
     * Performs a quick sort on an ArrayList of Student objects so the list is arranged alphabetically by the students'
     * last names
     *
     * @param pList the list of students to perform quick sort on
     * @param start the starting index (the element at index 0)
     * @param end the end index (the element at the end of the list, or list.size() - 1)
     */
    private static void quickSort(ArrayList<Student> pList, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(pList, start, end);

        quickSort(pList, start, pivot);
        quickSort(pList, pivot + 1, end);
    }

    /**
     * sort()
     *
     * This is the method called to sort a collection of students arranged in an ArrayList alphabetically by last name.
     * Sorting is done in place to the object reference.
     *
     * @param pList the ArrayList of Students to be sorted by last names.
     */
    public static void sort(ArrayList<Student> pList) {
        quickSort(pList, 0, pList.size() - 1);
    }
}
