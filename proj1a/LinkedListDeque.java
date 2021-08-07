public class LinkedListDeque<T>  {

    private class Node{
        T value;
        Node prev;
        Node next;

        private Node(T v, Node p, Node n){
            this.value = v;
            this.prev = p;
            this.next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node((T)null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
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
        Node p;
        for(p = sentinel.next; index > 0; index--){
            p = p.next;
        }
        return p.value;
    }
}
