import java.util.ArrayList;

public class Searcher {

    // Iterative
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
    public static int search(ArrayList<Student> pList, String pKey) {
        return search(pList, pKey, 0, pList.size() - 1);
    }
}
