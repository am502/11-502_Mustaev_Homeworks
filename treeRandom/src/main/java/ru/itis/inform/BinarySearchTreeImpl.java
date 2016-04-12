package ru.itis.inform;

import java.util.*;

public class BinarySearchTreeImpl {
    Random rand = new Random();
    private  Node root;
    private int size;

    private Node insertNode(Node root, int element) {
        int r = rand.nextInt(getSize() + 1);

        if (root == null) {
            root = new Node(element);
            size++;
        }
        else if(root != null && r % (getSize() + 1) == 0){
            root = insertAsRoot(root, element);
            size++;
        }
        else if (element <= root.getData()) {
            root.setLeft(insertNode(root.getLeft(), element));
        } else {
            root.setRight(insertNode(root.getRight(), element));
        }

        return root;
    }

    public int getSize(){
        return size;
    }


    public Node insertAsRoot(Node root, int x) {
        if(root == null) {
            return new Node(x);
        }
        if(root.getData() > x){
            root.setLeft(insertAsRoot(root.getLeft(), x));
            root = rotateRight(root);
        }
        else {
            root.setRight(insertAsRoot(root.getRight(), x));
            root = rotateLeft(root);
        }

        return root;
    }

    public Node rotateRight(Node p) {
        if(p == null || p.getLeft() == null) {
            return p;
        }
        Node q = p.getLeft();
        p.setLeft(q.getRight());
        q.setRight(p);

        return q;
    }

    public Node rotateLeft(Node p) {
        if(p == null || p.getRight() == null) {
            return p;
        }
        Node q = p.getRight();
        p.setRight(q.getLeft());
        q.setLeft(p);

        return q;
    }

    public void setLevels(Node root, int level){
        if (root != null) {
            setLevels(root.getRight(), level + 1);

            root.setLevel(level);

            setLevels(root.getLeft(), level + 1);
        }
    }

    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.getData());

            showRec(root.getLeft(), level + 1);
        }
    }

    public void insert(int element) {
        this.root = insertNode(this.root, element);
        setLevels(root, 0);
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

            System.out.println(x.toString());
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