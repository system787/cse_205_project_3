//**************************************************************************************************
// CLASS: Searcher (Searcher.java)
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring B 2019
// Project Number: 3
//
// AUTHOR: Vincent Hoang, vnhoang, vnhoang@asu.edu
//**************************************************************************************************

import java.util.ArrayList;

/**
 * The searcher class searches through an ArrayList of Student objects to find a specific student by last name.
 * Searching is done via binary search.
 */
public class Searcher {

    // Iterative because why not?
    //public static int search(ArrayList<Student> pList, String pKey) {
    //    int low = 0;
    //    int high = pList.size() - 1;
    //    while (low < high) {
    //        int middle = (low + high) / 2;
    //        int comparison = pKey.compareToIgnoreCase(pList.get(middle).getLastName());
    //        if (comparison == 0) {
    //            return middle;
    //        } else if (comparison < 0) {
    //            high = middle - 1;
    //        } else {
    //            low = middle + 1;
    //        }
    //    }
    //    return -1;
    //}

    // Recursive

    /**
     * search()
     * <p>
     * Searches through the ArrayList of Students provided to search for last names compared against the input
     * last name via binary search
     *
     * @param pList the ArrayList of Students to search through
     * @param pKey  the last name of the student to search for
     * @param pLow  the lower bound of the search (initially 0)
     * @param pHigh the upper bound of the search (initially the last element of the list, or list.size() - 1)
     * @return If the key was found, the index of the found element is returned. If the key was not found,
     * -1 is returned.
     */
    public static int search(ArrayList<Student> pList, String pKey, int pLow, int pHigh) {
        if (pLow > pHigh) {
            return -1;
        }

        int middle = (pLow + pHigh) / 2;

        int comparison = pKey.compareToIgnoreCase(pList.get(middle).getLastName());

        if (comparison == 0) {
            return middle;
        } else if (comparison < 0) {
            return search(pList, pKey, pLow, middle - 1);
        } else {
            return search(pList, pKey, middle + 1, pHigh);
        }
    }

    // Overloaded method declaration for recursive method

    /**
     * search()
     * <p>
     * Overloaded method declaration so that the search can be initiated with only the ArrayList and search key
     * as the parameters
     *
     * @param pList the ArrayList of Students to search through
     * @param pKey  the last name of the student to search for
     * @return If the key was found, the index of the found element is returned. If the key was not found,
     * -1 is returned.
     */
    public static int search(ArrayList<Student> pList, String pKey) {
        return search(pList, pKey, 0, pList.size() - 1);
    }
}
