import java.util.Arrays;

/**
  * @author Vadim Yastrebov
 * @version 2017.07.31
 */
public class TestMergeSort {
    public static void main(String[] args) {
        TestMergeSort test = new TestMergeSort();
        String[] arr = {"Lisa", "Adam", "John", "Vicky", "George", "Beth", "Kate", "Aaron", "Jinny"};
        System.out.print("Input ARRRRRRRR: \n");
        for(String s : arr){
            System.out.print(s + ", ");
        }
        mergeSort(arr);
        System.out.println("\n");
        for(String s : arr){
            System.out.print(s + ", ");
        }
    }

    /**
     * mergeSort algorithm
     * @param theArray is the input array of strings
     */
    public static void mergeSort(String[] theArray) {
        if (theArray.length > 1) {
//            String[] temp = new String[theArray.length];
            String[] lArr = Arrays.copyOfRange(theArray, 0, theArray.length / 2);
            String[] rArr = Arrays.copyOfRange(theArray, theArray.length / 2, theArray.length);
            mergeSort(lArr);
            mergeSort(rArr);
            int lIndex = 0;
            int rIndex = 0;
            for (int i = 0; i < theArray.length; i++) {
                if (lIndex >= lArr.length) {
                    theArray[i] = rArr[rIndex++];
                } else if (rIndex >= rArr.length) {
                    theArray[i] = lArr[lIndex++];
                } else {
                    if (lArr[lIndex].compareTo(rArr[rIndex]) > 0) {
                        theArray[i] = rArr[rIndex++];
                    } else if (lArr[lIndex].compareTo(rArr[rIndex]) < 0) {
                        theArray[i] = lArr[lIndex++];
                    } else {
                        theArray[i] = rArr[rIndex++];
                        theArray[++i] = lArr[lIndex++];
                    }
                }
            }

//            lval.compareTo(rval);
        }

    }
}
