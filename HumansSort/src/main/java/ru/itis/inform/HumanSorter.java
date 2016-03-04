package ru.itis.inform;

public class HumanSorter {
    public LinkedList sort(LinkedList<Human> humans){
        ArrayList<LinkedList<Human>> HumasnArray = new ArrayList<LinkedList<Human>>();

        Node<Human> node = humans.getFirst();

        while(node != null){
            Human human = node.getValue();
            int currentAge = human.getAge();
            if(HumasnArray.get(currentAge) == null){
                LinkedList<Human> e = new LinkedList<Human>();
                e.add(human);
                HumasnArray.set(currentAge, e);
            }
            else{
                LinkedList<Human> e = (LinkedList<Human>) HumasnArray.get(currentAge);
                e.add(human);
            }
            node.getNext();
        }

        LinkedList<Human> resultList = HumasnArray.toLinkedList();

        return resultList;
    }
}
