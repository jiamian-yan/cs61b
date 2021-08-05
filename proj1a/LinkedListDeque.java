public class LinkedListDeque<T> {
    public static class Node<T>{
        Node prev;
        T item;
        Node next;

        public Node(Node p, T i, Node n){
            this.prev = p;
            this.item = i;
            this.next = n;
        }
    }

    /** invariants:
     * senF.prev == null  &&  senF.item == 0;
     * senF.next is the first node(if it exists) of LinkedListDeque
     * senB.prev is the last node(if it exists) of LinkedListDeque
     * senB.item == 0 && senB.next == null
     * **/
    private final Node senF;
    private int size;
    private final Node senB;

    public LinkedListDeque(){
        this.senF = new Node(null, 0, null);
        this.senB = new Node(null, 0, null);
        this.senF.next = this.senB;
        this.senB.prev = this.senF;
        this.size = 0;
    }



    public void addFirst(T item){
        this.size += 1;
        Node temporaryNode = this.senF.next;
        this.senF.next = new Node(senF, item, temporaryNode);
        temporaryNode.prev = this.senF.next;
    }



    public void addLast(T item){
        this.size += 1;
        Node temporaryNode = this.senB.prev;
        this.senB.prev = new Node(temporaryNode, item, senB);
        temporaryNode.next = this.senB.prev;
    }



    public boolean isEmpty(){
        if(this.size == 0)
            return true;
        return false;
    }


    public int size(){
        return size;
    }



    public void printDeque(){
        Node p = this.senF.next;
        for(int i = 0; i < size; i++){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println('\n');
    }



    public T removeFirst(){
        if(size == 0){
            return null;
        }
        else{
            size -= 1;
            T result = (T) senF.next.item;
            senF.next = senF.next.next;
            senF.next.prev = senF;
            return result;
        }
    }



    public T removeLast(){
        if(size == 0){
            return null;
        }
        else{
            size -= 1;
            T result = (T) senB.prev.item;
            (senB.prev) = (senB.prev).prev;
            (senB.prev).next = senB;
            return result;
        }
    }



    public T get(int index){
        if(index < 0 || index >= this.size){
            return null;
        }
        Node pointer = this.senF.next;
        for(int i = 0; i < index; i++){
            pointer = pointer.next;
        }
        return (T)pointer.item;
    }

    private T getRecursiveHelp(Node n, int index){
        if(index == 0)
            return (T)n.item;
        return (T)getRecursiveHelp(n.next, index-1);
    }

    public T getRecursive(int index){
        if(index < 0 || index >= this.size){
            return null;
        }
        return (T)getRecursiveHelp(this.senF.next, index);
    }

}
