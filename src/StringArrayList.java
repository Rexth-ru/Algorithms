import interfaces.StringList;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class StringArrayList implements StringList {

    private String[] strings;
    private int size;

    public StringArrayList(int capacity) {

        if (capacity > 0){
            this.strings = new String[capacity];
            this.size = 0;
        } else if (capacity < 0){
            this.strings = new String[Math.abs(capacity)];
            this.size = 0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String add(String item) {
        checkItem(item);
        strings[size] = item;
        size++;
        return item;
    }
    @Override
    public String add(int index, String item) {
       checkItem(item);
       if (index >= strings.length|| index<0){
                throw new IllegalArgumentException();
       }
       for (int j=size+1; j>index;j--) {
           strings[j] = strings[j-1];
       }strings[index] = item;
       size++;
       return item;
    }

    @Override
    public String set(int index, String item) {
       checkItem(item);
       if (index >= strings.length|| strings[index]==null){
           throw new IllegalArgumentException();
       }else strings[index] = item;
       return item;
    }
    @Override
    public String remove(String item) {
        checkItem(item);
        int newSize = size;
        for (int i = 0; i < size; i++) {
           if (strings[i].equals(item)&& i!=size-1) {
               for (int j=i; j<size-1;j++) {
                   strings[j] = strings[j + 1];
                   strings[j + 1] = null;
               }
                    newSize = size--;
                    break;
           }
           if (strings[i].equals(item) && i==size-1){
               strings[i]=null;
               newSize = size--;
               break;
           }
           if (size==newSize)
            throw new NoSuchElementException();
        }
        return item;
    }
    @Override
    public String remove(int index) {
        String str = null;
        int newSize = size;
        checkIndex(index);
        for (int i=0; i<size;i++){
            if (i==index && i!=size-1){
                str = strings[i];
                for (int j=i; j<size-1;j++) {
                    strings[j] = strings[j + 1];
                    strings[j + 1] = null;
                }
               newSize = size--;
               break;
            }
            if (i==index && i==size-1){
                str = strings[i];
                strings[i]=null;
               newSize = size--;
               break;
            }
        }
        if (size==newSize)
            throw new NoSuchElementException();
        return str;
    }

    @Override
    public boolean contains(String item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item))return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (strings[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = size-1; i >=0 ; i--) {
            if (strings[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        String[] otherList1 = otherList.toArray();
        if (size!=otherList.size()) {
            return false;
        }
        if (size==otherList.size()) {
            for (int i = 0; i < size; i++) {
                if (!strings[i].equals(otherList1[i]))
                    return false;
                break;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }

    @Override
    public void clear() {
        for(int i =0; i<strings.length;i++){
            strings[i]=null;
        }
    }

    @Override
    public String[] toArray() {
        String[] strings1 = new String[strings.length];
        for (int i = 0; i< strings.length;i++){
            strings1[i]=strings[i];
        }
        return strings1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringArrayList)) return false;
        StringArrayList that = (StringArrayList) o;
        return size == that.size && Arrays.equals(strings, that.strings);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(strings);
        return result;
    }

    @Override
    public String toString() {
        return  Arrays.toString(strings);
    }

    //проверка на null
    public void checkItem(String item){
        try {
            if (item.isEmpty())
                throw new NullPointerException();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    public void checkIndex(int index){
        try {
            if (index>size||index>strings.length)
                throw new IndexOutOfBoundsException();
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
