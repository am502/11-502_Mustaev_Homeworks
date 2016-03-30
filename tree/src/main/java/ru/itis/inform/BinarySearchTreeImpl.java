package ru.itis.inform;

import java.util.*;

public class BinarySearchTreeImpl {

    private  Node root;

    private Node insertNode(Node root, int element) {
        if (root == null) {
            root = new Node(element);
        } else if (element <= root.getData()) {
            root.setLeft(insertNode(root.getLeft(), element));
        } else {
            root.setRight(insertNode(root.getRight(), element));
        }

        return root;
    }

    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.getData());
            root.setLevel(level);

            showRec(root.getLeft(), level + 1);
        }
    }

    public void insert(int element) {
        this.root = insertNode(this.root, element);
    }

    public void show() {
        showRec(root, 0);
    }

    private void inOrder(Node root, ArrayList<Integer> array) {
        if (root != null) {
            inOrder(root.getLeft(), array);
            array.add(root.getData());
            inOrder(root.getRight(), array);
        }
    }

    public void inOrderPrint() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        inOrder(this.root, array);

        for(int i = 0; i < array.size(); i++)
            System.out.print(array.get(i) + " ");

    }

    public void change(){
        root.getLeft().setData(16);
    }

    public boolean isBinarySearchTree(){
        boolean check = true;

        ArrayList<Integer> array = new ArrayList<Integer>();
        inOrder(root, array);

        for(int i = 0; i < array.size() - 1; i++)
            if(array.get(i) > array.get(i + 1))
                check = false;

        return check;
    }

    public boolean sumator(){
        Queue<Node> q = new LinkedList<Node>();
        boolean b = true;
        LinkedList<Node> list = new LinkedList<Node>();

        q.add(root);

        while(! q.isEmpty()){

            Node x = q.poll();

            if(x.getLeft() != null)
                q.add(x.getLeft());

            if(x.getRight() != null)
                q.add(x.getRight());

            list.add(x);

            //System.out.println(x.toString());
        }

        int maxlevel = list.get(list.size() - 1).getLevel();
        int sumator = 0;

        LinkedList<Integer> sum = new LinkedList<Integer>();

        for(int i = 0; i <= maxlevel; i++){
            sumator = 0;
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getLevel() == i){
                    sumator += list.get(j).getData();
                }
            }
            sum.add(sumator);
        }

        for(int i = 0; i < sum.size() - 1; i++){
            if(sum.get(i) > sum.get(i + 1))
                b = false;
        }

        return b;
    }
}