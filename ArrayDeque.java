public class ArrayDeque<T> {
    private int size;
    private T[] a;
    private int length;
    //index of front item
    private int first;
    //index of last
    private int last;

    public ArrayDeque() {
        this.length = 8;
        a = (T[]) new Object[length];
        this.size = 0;

        first = 4;
        last = 4;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }

    public void addFirst(T t) {

        if(first==-1){
            first = a.length-1;//环形加入
        }
        if (size == length - 1) {
            expand();
        }
        a[first] = t;
        first--;
        size++;
    }

    private void expand() {
        length = 2 * length;
        T[] temp = (T[]) new Object[length];//每次按两倍扩容，在数组前端扩容
        System.arraycopy(a, 0, temp, 0, last+1);
        System.arraycopy(a, last+1, temp, last+length/2, size-last-1);
        a = temp;
        first = first+length/2;
    }

    public void addLast(T t) {
        if(size == length-1){
            expand();
        }
        if (last >= a.length) {
            last = last % (a.length);
        }
        a[last] = t;
        last++;
        size++;
    }

    public T  removeFirst() {
       double prop = size/length;
        if(length>=16 && prop< 0.25){
            reduce();
        }
      if(size==0){
          return null;
      }

      if(first==length-1){
          T temp = a[0];
          first = 0;
          a[first] = null;
          size--;
          return temp;
      }
        T temp = a[first+1];
        a[first+1] = null;
        first++;
        size--;
        return temp;
    }

    public T removeLast(){
        double prop = size/length;
        if(length>=16 && prop< 0.25){
            reduce();
        }
        if(size==0){
            return null;
        }

        if(last == 0){
            T temp = a[length-1];
            a[last-1] = null;
            last = length-1;
            return temp;
        }
        T temp = a[last-1];
        a[last-1] = null;
        last--;
        return temp;
    }
    public void printDeque() {
        for(int i = 0; i< a.length;i++ ){
            if(a[i]!=null) {
                System.out.print(a[i]+" ");
            }
        }
        System.out.println( );
    }
    public T get(int index){
     return a[index];
    }

    private void reduce(){
            T[] temp = (T[]) new Object[length/2];
            System.arraycopy(a,0,temp,0,last+1);
            System.arraycopy(a,0,temp,first,size-last-1);
            first = first - length/2;
    }

}