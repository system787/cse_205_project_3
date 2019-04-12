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

public class Sorter {

    private static void swap(ArrayList<Student> pList, int pLeftIndex, int pRightIndex) {
        Student temp = pList.get(pLeftIndex);

        pList.set(pLeftIndex, pList.get(pRightIndex));
        pList.set(pRightIndex, temp);
    }

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

    private static void quickSort(ArrayList<Student> pList, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(pList, start, end);

        quickSort(pList, start, pivot);
        quickSort(pList, pivot + 1, end);
    }

    public static void sort(ArrayList<Student> pList) {
        quickSort(pList, 0, pList.size() - 1);
    }
}
