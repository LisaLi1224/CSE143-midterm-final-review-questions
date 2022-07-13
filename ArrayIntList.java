// ArrayIntList can be used to store a list of integers.
public class ArrayIntList {
    int[] elementData; // list of integers
    int size; // current number of elements in the list

    // Constructs an empty list
    public ArrayIntList() {
        elementData = new int[10];
        size = 0;
    }

    // appends the given value to the end of the list
    public void add(int value) {
        elementData[size] = value;
        size++;
    }
    
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }

    public void collapse() {
      if (size % 2 == 0) {
         for (int i = 0; i < size; i = i + 2) {
            elementData[i/2] = elementData[i]+elementData[i+1];
         }
         size = size / 2;
      } else {
         for (int i = 0; i < size - 1; i = i + 2) {
            elementData[i / 2] = elementData[i] + elementData[i + 1];
         } 
         elementData[size / 2] = elementData[size - 1];
         size = size / 2 + 1;
      }
    }
    
    public int[] copyMultiple(int[] elementData, int timesToCopy) {
      if (timesToCopy < 1) {
         throw new IllegalArgumentException();
      }    
      int[] number = new int[size * timesToCopy];
      for (int i = 0; i < timesToCopy; i++) {
         for (int j = 0; j < size; j++) {
            number[i * size + j] = elementData[j];
         }
      }
      return number;
    }
    
    public ArrayIntList fromCounts() {
      ArrayIntList list = new ArrayIntList();
      int size1 = 0;
      for (int i = 0; i < size; i = i+2) {
         int times = elementData[i];
         for (int j = 0; j < times; j++) {
            list.elementData[size1]=elementData[i+1];
            size1++;
         } 
      }
      list.size = size1;
      return list;
    }  
    
    
    public void removeRange(int start, int end){
      if (start <0 || end > size|| start > end){
         throw new IllegalArgumentException();
      }
      int delta = end - start;
      for (int i = end; i < size; i++){
         
         elementData[i-delta]=elementData[i];
         
      }
      size = size - delta;
    }
}