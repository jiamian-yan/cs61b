public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int firstPointer;
    private int lastPointer;

    /** Some invariants:
     *  firstPointer always points to the first item.
     *  lastPointer always points to the position after the last item.
     *  items[]: [firstPointer, lastPointer)
     * */

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        firstPointer = 0;
        lastPointer = 0;
    }

    private void resizing(int capacity){
        T[] newItems = (T[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            newItems[i] = items[(firstPointer + i) % items.length];
        }
        firstPointer = 0;
        lastPointer = size;
        this.items = newItems;
    }


    public void addFirst(T item){
        if(size == items.length){
            resizing(2*size);
        }
        firstPointer = (firstPointer + items.length - 1) % items.length;
        this.items[firstPointer] = item;
        size += 1;
    }



    public void addLast(T item){
        if(size == items.length){
            resizing(2*size);
        }
        this.items[lastPointer] = item;
        lastPointer = (lastPointer + 1) % items.length;
        size += 1;
    }


    public boolean isEmpty(){
        return (size == 0);
    }



    public int size(){
        return size;
    }



    public T removeFirst(){
        if(size == 0){
            return null;
        }
        size -= 1;
        T result = items[firstPointer];
        firstPointer = (firstPointer + 1) % items.length;
        return result;
        if(size < items.length / 4){
            resizing(items.length / 2);
        }
    }



    public T removeLast(){
        if(size == 0){
            return null;
        }
        size -= 1;
        lastPointer = (lastPointer + items.length - 1) % items.length;
        T result = items[lastPointer];
        if(size < items.length / 4){
            resizing(items.length / 2);
        }
        return result;
    }



    public T get(int index){
        if(size == 0){
            return null;
        }
        if(index > size - 1){
            return null;
        }
        else{
            return items[(firstPointer + index) % items.length];
        }
    }



    public void printDeque(){
        int i = 0;
        while(i < size){
            System.out.print(items[(firstPointer + i) % items.length]);
            System.out.print(" ");
        }
    }
}
