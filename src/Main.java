import interfaces.IntegerList;
import interfaces.StringList;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        IntegerList integerList = new IntegerArrayList(5);
//        integerList.add(6);
//        integerList.add(3);
//        integerList.add(9);
//        integerList.add(2);
//        integerList.add(7);
//        System.out.println(integerList);
//        integerList.remove(1);
//        integerList.remove((Integer) 9);
//        System.out.println(integerList);
//        System.out.println(integerList.contains((Integer) 11));
//        System.out.println(integerList.indexOf((Integer) 2));
//        System.out.println(integerList.lastIndexOf((Integer) 7));
//        System.out.println(integerList.get(2));
//        IntegerList integerList1 = new IntegerArrayList(7);
//        integerList1.add(6);
//        integerList1.add(3);
//        integerList1.add(9);
//        integerList1.add(2);
//        integerList1.add(7);
//        System.out.println(integerList1.equals(integerList));
        int[] arr = new int[10];
        IntegerList integerList = printRandomIntegerArrayList(arr, 0, 10);
        System.out.println(integerList);
        System.out.println(integerList.contains(11));
        System.out.println(integerList);

    }
//        System.out.println(Arrays.toString(arr));
//        int[] arr1 = arr.clone();
//        System.out.println(Arrays.toString(arr1));
//        int[] arr2 = arr.clone();
//        long start = System.currentTimeMillis();
//        sortSelection(arr);
//        sortInsertion(arr1);
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(Arrays.toString(arr1));
//    }
//
//    public static void swapElements(int[] ar, int indexA, int indexB) {
//        int tmp = ar[indexA];
//        ar[indexA] = ar[indexB];
//        ar[indexB] = tmp;
//    }
//
//    private static void sortSelection(int[] arrs) {
//        for (int i = 0; i < arrs.length - 1; i++) {
//            int minElementIndex = i;
//            for (int j = i + 1; j < arrs.length; j++) {
//                if (arrs[j] < arrs[minElementIndex]) {
//                    minElementIndex = j;
//                }
//            }
//            swapElements(arrs, i, minElementIndex);
//        }
//    }
//
//    public static void sortInsertion(int[] integers) {
//        for (int i = 0; i < integers.length; i++) {
//            int tmp = integers[i];
//            int j = i;
//            while (j > 0 && integers[j - 1] >= tmp) {
//                integers[j] = integers[j - 1];
//                j--;
//            }
//            integers[j] = tmp;
//        }
//    }
public static IntegerList printRandomIntegerArrayList(int[]arr, int min, int max) {
    Random random = new Random();
    IntegerList integerList = new IntegerArrayList(arr.length);
    for (int i = 0; i < arr.length; i++) {
        arr[i] = random.nextInt(max - min + 1) + min;
        integerList.add(arr[i]);
    }
    return integerList;
}
}









//        StringList arrayList = new StringArrayList(4);
//        arrayList.add("abcd");
//
////        arrayList.remove("abc");
////        System.out.println(arrayList);
//        arrayList.add(1,"efgh");
////      //  System.out.println(arrayList);
//        arrayList.add(2, "qwer");
//        System.out.println(arrayList);
////        arrayList.remove("qwer");
////        arrayList.remove(1);
////        System.out.println(arrayList);
////        System.out.println(arrayList.contains("abc"));
//        StringList otherList = new StringArrayList(5);
//        otherList.add("abcd");
//        otherList.add(1,"efgh");
//        otherList.add(2, "qwer");
//        otherList.add("tyui");
//        System.out.println(otherList);
//        System.out.println(arrayList.equals(otherList));
////        otherList.clear();
////        System.out.println(otherList);
////    }
//}
