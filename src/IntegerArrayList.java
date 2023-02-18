import interfaces.IntegerList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
public class IntegerArrayList implements IntegerList {
    Integer[] integers;
    int size;
    public IntegerArrayList(int capacity) {

        if (capacity > 0){
            this.integers = new Integer[capacity];
            this.size = 0;
        } else if (capacity < 0){
            this.integers = new Integer[Math.abs(capacity)];
            this.size = 0;
        } else {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public Integer add(Integer item) {
        checkItem(item);
        for (int i = 0; i < integers.length; i++) {
            if (integers[i]==null){
                integers[i] = item;
                size++;
                break;
            }
        }
        return item;
    }
    @Override
    public Integer add(int index, Integer item) {
        checkItem(item);
        for (int i = 0; i < integers.length; i++) {
            if (index >= integers.length||integers[index]!=null){
                throw new IllegalArgumentException();
            }
            if (i==index) {
                integers[i] = item;
                size++;
                break;
            }
        }
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkItem(item);
        for (int i = 0; i < integers.length; i++) {
            if (index >= integers.length|| integers[index]==null){
                throw new IllegalArgumentException();
            }
            if (i==index) {
                integers[i] = item;
                break;
            }
        }
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        int newSize = size;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(integers[i], item) && i != size - 1) {
                for (int j=i; j<size-1;j++) {
                    integers[j] = integers[j + 1];
                    integers[j + 1] = null;
                }
                newSize = size--;
                break;
            }
            if (Objects.equals(integers[i], item) && i == size - 1) {
                integers[i] = null;
                newSize = size--;
                break;
            }
        }
        if (newSize == size)
                throw new NoSuchElementException();
          return item;
    }
    @Override
    public Integer remove(int index) {
        Integer integer = null;
        int newSize = size;
        checkIndex(index);
        for (int i=0; i<size;i++){
            if (i==index && i!=size-1){
                integer = integers[i];
                for (int j=i; j<size-1;j++) {
                    integers[j] = integers[j + 1];
                    integers[j + 1] = null;
                }
                newSize = size--;
                break;
            }
            if (i==index && i==size-1){
                integer = integers[i];
                integers[i]=null;
                newSize = size--;
                break;
            }
        }
        if (size==newSize)
            throw new NoSuchElementException();
        return integer;
    }
    @Override
    public boolean contains(Integer item) {
        checkItem(item);
        sortInsertion(integers);
        if (binarySearch(integers,item)){
            return true;
        }
        return false;
    }

  @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (integers[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size-1; i >=0 ; i--) {
            if (integers[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return integers[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        Integer[] otherList1 = otherList.toArray();
        if (size!=otherList.size()) {
            return false;
        }
        if (size==otherList.size()) {
            for (int i = 0; i < size; i++) {
                if (!integers[i].equals(otherList1[i]))
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
        for(int i =0; i<integers.length;i++){
            integers[i]=null;
        }
    }
    @Override
    public Integer[] toArray() {
        Integer[] integers1 = new Integer[integers.length];
        for (int i = 0; i< integers.length;i++){
            integers1[i]=integers[i];
        }
        return integers1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof IntegerArrayList))
            return false;
        IntegerArrayList that = (IntegerArrayList) o;
        return size == that.size && Arrays.equals(integers, that.integers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(integers);
        return result;
    }

    @Override
    public String toString() {
        return  Arrays.toString(integers);
    }

    public void checkItem(Integer item){
        try {
            if (item==null)
                throw new NullPointerException();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    public void checkIndex(int index){
        try {
            if (index>size||index>integers.length)
                throw new IndexOutOfBoundsException();
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    private void sortInsertion(Integer[] integers){
        for (int i =0; i<size;i++){
            int tmp = integers[i];
            int j = i;
            while (j>0 && integers[j-1]>=tmp){
                integers[j] = integers[j-1];
                j--;
            }
            integers[j] = tmp;
        }
    }
    private boolean binarySearch(Integer[] integers, int element){
        int min = 0;
        int max = size-1;
        while (min<=max) {
            int mid = (min + max) / 2;
            if (element == integers[mid]) return true;
            if (element < integers[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}

