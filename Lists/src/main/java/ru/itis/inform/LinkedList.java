package ru.itis.inform;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public void add(T element){  
        Node a = new Node(element);
        a.data = element;
        if (tail == null){
            head = a;              
            tail = a;
        }
        else{
            tail.next = a;
            tail = a;
        }
        this.length++;
    }

    public void show(){
        Node t = head;       
        while (t != null){
            System.out.print(t.data + " "); 
            t = t.next;                
        }
    }

    public void remove(T element){
        if(head == null)
            return;

        if(head == tail){
            head = null;       
            tail = null;
            return;  
        }

        if(head.data == element){
            head = head.next;   
            return;               
        }
        Node t = head;
        while(t.next != null){
            if(t.next.data == element){
                if(tail == t.next){
                    tail = t;         
                }
                t.next = t.next.next;
                return;             
            }
            t = t.next;
        }
        this.length--;
    }

    public int getLength(){
        return length;
    }

    public void append(LinkedList<T> list) {
        Node check = list.head;
        while(check != null){
            this.tail.setNext(check);
            tail = tail.getNext();
            check = check.getNext();
            this.length++;
        }
    }

    public Node getHead(){
        return head;
    }

    public ArrayList toArrayList(){
        ArrayList array = new ArrayList(this.length);
        Node node = getHead();
        while(node != null){
            array.add(node.getData());
            node = node.getNext();
        }
        return array;
    }

    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(head);
    }

    public static <T extends Comparable<T>> LinkedList<T> mergeSort(LinkedList<T> list) {
        ArrayList<T> arrayList = list.toArrayList();

        LinkedList<T> result = new LinkedList<T>();

        T v1;
        T v2;

        for(int i = 0; i < arrayList.getCount() - 1; i++){
            for(int j = 0; j < arrayList.getCount() - i - 1; j++){
                v1 = arrayList.get(j);
                v2 = arrayList.get(j + 1);

                if(v1.compareTo(v2) == 1){
                    arrayList.set(j, v2);
                    arrayList.set(j + 1, v1);
                    T temp = v1;
                    v1 = v2;
                    v2 = temp;
                }
            }
        }
        result = arrayList.toLinkedList();

        return result;
    }

    public static <T extends  Comparable<T>> LinkedList<T> merge(LinkedList<T> first, LinkedList<T> second){
        int lengthOfFirst = first.getLength();
        int lengthOfSecond = second.getLength();

        ArrayList<T> array1 = first.toArrayList();
        ArrayList<T> array2 = second.toArrayList();

        T v1;
        T v2;

        int indexOf1 = 0;
        int indexOf2 = 0;

        ArrayList<T> array = new ArrayList<T>(lengthOfFirst + lengthOfSecond);

        int max = Math.max(lengthOfFirst, lengthOfSecond);

        while(lengthOfFirst != 0 && lengthOfSecond != 0){
            v1 = array1.get(indexOf1);
            v2 = array2.get(indexOf2);
            if(v1.compareTo(v2) == 0){
                indexOf1++;
                indexOf2++;
                array.add(v1);
                array.add(v2);
                lengthOfFirst--;
                lengthOfSecond--;
            }
            else if(v1.compareTo(v2) == -1){
                indexOf1++;
                array.add(v1);
                lengthOfFirst--;
            }
            else if(v1.compareTo(v2) == 1){
                indexOf2++;
                array.add(v2);
                lengthOfSecond--;
            }
        }

        int index = 0;

        if(lengthOfFirst != 0 && lengthOfSecond == 0)
            index = max - lengthOfFirst;
        else if(lengthOfSecond != 0 && lengthOfFirst == 0)
            index = max - lengthOfSecond;
        else if(lengthOfFirst == 0 && lengthOfSecond == 0)
            index = max;

        while(index < max) {
            if(index - lengthOfFirst == index)
                array.add(array2.get(index));
            else if(index - lengthOfSecond == index)
                array.add(array1.get(index));
            index++;
        }

        return array.toLinkedList();
    }
}
