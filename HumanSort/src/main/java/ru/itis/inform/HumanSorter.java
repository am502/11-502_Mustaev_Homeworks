package ru.itis.inform;

import java.util.*;

public class HumanSorter {
    public LinkedList<Human> sort(LinkedList<Human> list) {
        ArrayList<LinkedList<Human>> array = new ArrayList<LinkedList<Human>>(123);

        Node<Human> node = list.getHead();

        while (node != null) {
            Human human = node.getData();
            int age = human.getAge();

            if (array.get(age) == null) {
                LinkedList<Human> element = new LinkedList<Human>();
                element.add(human);
                array.set(age, element);
            } else {
                LinkedList<Human> element = (LinkedList<Human>) array.get(age);
                element.add(human);
            }

            node = node.getNext();
        }
        LinkedList<Human> result = array.toLinkedList();

        return result;
    }
}
