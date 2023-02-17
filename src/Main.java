import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringList arrayList = new StringArrayList(4);
        arrayList.add("abcd");

//        arrayList.remove("abc");
//        System.out.println(arrayList);
        arrayList.add(1,"efgh");
//      //  System.out.println(arrayList);
        arrayList.add(2, "qwer");
        System.out.println(arrayList);
//        arrayList.remove("qwer");
//        arrayList.remove(1);
//        System.out.println(arrayList);
//        System.out.println(arrayList.contains("abc"));
        StringList otherList = new StringArrayList(5);
        otherList.add("abcd");
        otherList.add(1,"efgh");
        otherList.add(2, "qwer");
        otherList.add("tyui");
        System.out.println(otherList);
        System.out.println(arrayList.equals(otherList));
//        otherList.clear();
//        System.out.println(otherList);
    }
}
