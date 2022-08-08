package project1B;

public class ArrayDeque<T> implements Deque<T> {
    public int size;
    public  T[] a;
    public int length;
    //index of front item
    public int first;
    //index of last
    public int last;

    public ArrayDeque() {
        this.length = 8;
        a = (T[]) new Object[length];
        this.size = 0;

        first = 4;
        last = 4;
    }


    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    @Override
    public int size() {
        return size;
    }
    //minusOne help to return index of first item;
    private int minusOne(int index){
        if(index==0){
            return length-1;
        }
        return index-1;
    }

    //plusOne help to return index of last item;
    private int plusOne(int index, int length){
        index = index%length;
        if(index==length-1){
            return 0;
        }
        return index+1;
    }
    @Override
    public void addFirst(T t) {
        if (size == length - 1) {
            grow();
        }
        first = minusOne(first);
        a[first] = t;
        size++;
    }

    private void grow() {
       T[] newArray = (T[]) new Object[2*length];
       int temp1 = first;
       int temp2 = length;
       while(temp1 != last){
           newArray[temp2] = a[temp1];
           temp1 = plusOne(temp1,length);
           temp2 = plusOne(temp2,2*length);
       }
       last = temp2;
       first = length;
       length *= 2;
       a=newArray;


    }
    @Override
    public void addLast(T t) {
        if(size == length-1){
            grow();
        }
        a[last] = t;
        last = plusOne(last,length);
        size++;
    }
    @Override
    public T  removeFirst() {
        if( length>=16 && length/size >= 4){
            shrink();
        }
      if(size==0){
          return null;
      }
      T temp = a[first];
      first = plusOne(first,length);
      size--;
      return temp;
    }
    @Override
    public T removeLast(){
        if( length>=16 && length/size >= 4){
          shrink();
        }
        if(size==0){
            return null;
        }
        last = minusOne(last);
        size--;
        return a[last];

    }
    @Override
    public void printDeque() {
      int temp = first;
      while(temp!=last){
          System.out.print(a[temp]+" ");
          temp = plusOne(temp,length);
      }
    }
    @Override
    public T get(int index) {
        if (index >= length) {
         return null;
        }
        int temp = first;
        for(int i = temp; i < index ; i++){
            temp = plusOne(temp,length);
        }
        return a[temp];
    }

     private void shrink(){
               T[] newArray = (T[]) new Object[length / 2];
               int temp1 = first;
               int temp2 = length / 4;
               while (temp1 != last) {
                   newArray[temp2] = a[temp1];
                   temp1 = plusOne(temp1, length);
                   temp2 = plusOne(temp2, length / 2);
               }
               first = length/4;
               last = temp2;
               length /= 2;
               a = newArray;
           }
    }
