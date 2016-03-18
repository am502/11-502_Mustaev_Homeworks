package ru.itis.inform;

public class LexSorter {
    public LinkedList LexSort(LinkedList<Human> list) {
        ArrayList<LinkedList<Human>> array = new ArrayList<LinkedList<Human>>(123);
        Human human = (Human) list.getHead().getData();
        int length = human.getName().length();

        for(int i = length - 1; i >= 0; i--){
            list = sortByIndex(list, i);
        }
        return list;
    }

    public LinkedList sortByIndex(LinkedList list, int index){
        ArrayList<LinkedList<Human>> array = new ArrayList<LinkedList<Human>>(123);
        Node<Human> node = list.getHead();

        while(node != null){
            Human human = node.getData();
            char ch;
            ch = human.getName().charAt(index);
            int number = (int) ch;

            setArrayElement(array, number, human);

            node = node.getNext();
        }
        return array.toLinkedList();
    }

    private void setArrayElement(ArrayList<LinkedList<Human>> array, int number, Human human){
        if(array.get(number) == null){
            LinkedList<Human> element = new LinkedList<Human>();
            element.add(human);
            array.set(number, element);
        }
        else{
            LinkedList<Human> element = array.get(number);
            element.add(human);
        }
    }
}
