import PJ1.Deque;

public class LinkedListDeque<T>  {

    private class Node{
        T value;
        PJ1.LinkedListDeque.Node prev;
        PJ1.LinkedListDeque.Node next;

        private Node(T v, PJ1.LinkedListDeque.Node p, PJ1.LinkedListDeque.Node n){
            this.value = v;
            this.prev = p;
            this.next = n;
        }
    }

    private PJ1.LinkedListDeque.Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new PJ1.LinkedListDeque.Node((T)null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        PJ1.LinkedListDeque.Node newNode = new PJ1.LinkedListDeque.Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        PJ1.LinkedListDeque.Node newNode = new PJ1.LinkedListDeque.Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = this.sentinel;
        for(int i = 0; i < size; i++){
            System.out.print(p.value + " ");
            p = p.next;
        }
        System.out.println('\n');
    }

    public T removeFirst() {
        if(size == 0){
            return null;
        }
        T result = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return result;
    }

    public T removeLast() {
        if(size == 0){
            return null;
        }
        T result = sentinel.prev.value;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return result;
    }

    public T get(int index) {
        if(index < 0 || index+1 > size ){
            return null;
        }
        PJ1.LinkedListDeque.Node p;
        for(p = sentinel.next; index > 0; index--){
            p = p.next;
        }
        return p.value;
    }
}
