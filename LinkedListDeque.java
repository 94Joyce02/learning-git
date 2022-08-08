package project1B;

public class LinkedListDeque<T> implements Deque<T> {
    //int size to record how many items in the List.
    private int size = 0;
    private Node sentinel = new Node<>(-1, null, null);//Sentinel node is used to handle specialcase
    //设置头节点表示链表开端，指向链表第一个数据（对象）
    private Node first;
    //设置，指向链表最后一个数据（对象）
    private Node last;
    //use sentinel node to handle special case

    //定义Node 节点，包含数据和两个指针（pre point references to the previous Node, next point references to next Node)
    private static class Node<T> {
        private Object item;// stores real data content
        private Node pre;
        private Node next;

        public Node(Object item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item=" + item +
                    '}';
        }
    }


    //add Node(item) to the beginning
    public void addFirst(T item) {
        first = new Node<>(item, sentinel, first);
        sentinel.next = first;
        size++;
    }

    //add Node(item) to the last
    public void addLast(T item) {
        last = new Node<>(item, last, sentinel);
        sentinel.pre = last;
        size++;
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

    public void printDeque() {
        Node temp = sentinel;
        while (temp.next != null) {
            System.out.print(temp.next);
            temp = temp.next;
        }
    }

    public T removeFirst() {
        Node temp = sentinel;
        if (temp.next != null) {
            temp = temp.next;
            size--;
            return (T) (temp.item);
        }
        return null;
    }

    public T removeLast() {
        Node temp = sentinel;
        if (sentinel.pre != null) {
            temp = temp.pre;
            size--;
            return (T) (temp.item);
        }
        return null;
    }

    @Override
    public T get(int index) {
        Node temp = sentinel;
        if (size == 0 || index >= size) {
            return null;
        }
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return (T) temp.item;
    }

    public T getRecursive(int index){
        if(index >= size){
            return null;
        }
      return (T) RecursiveHelp(index).item;
    }
    public Node<T> RecursiveHelp(int index){
        if (index==0){
            return sentinel.next;
        }
        return RecursiveHelp(index-1).next;
    }
}