package ru.itis.inform;

import java.util.*;

public class RBtree {
    private Node root;
    private Node inRoot;

    public void insertNotRB(int key, int value) {
        this.root = insertNode(this.root, key, value, null);
    }

    private Node insertNode(Node root, int key, int value, Node parent) {
        if (root == null) {
            root = new Node(key, value, parent);
            inRoot = root;
        }
        else if (key <= root.getKey()) {
            root.setLeft(insertNode(root.getLeft(), key, value, root));
        }
        else {
            root.setRight(insertNode(root.getRight(), key, value, root));
        }
        return root;
    }

    private void insert_case1(Node n){
        if (n.getParent() == null){
            n.setRed(false);
        }else{
            insert_case2(n);
        }
    }

    private void insert_case2(Node n){
        if (!n.getParent().getRed()){
            return;
        }else{
            insert_case3(n);
        }
    }

    private void insert_case3(Node n){
        Node u = uncle(n);
        Node g;
        if ((u != null) && (u.getRed()) && (n.getParent().getRed())){
            n.getParent().setRed(false);
            u.setRed(false);
            g = grandparent(n);
            g.setRed(true);
            insert_case1(g);
        }else{
            insert_case4(n);
        }
    }

    private void insert_case4(Node n){
        Node g = grandparent(n);
        if ((n == n.getParent().getRight())&&(n.getParent() == g.getLeft())) {
            leftRotate(n.getParent());
            n = n.getLeft();
        }else if ((n == n.getParent().getLeft())&&(n.getParent() == g.getRight())){
            rightRotate(n.getParent());
            n = n.getRight();
        }
        insert_case5(n);
    }

    private void insert_case5(Node n){
        Node g = grandparent(n);
        n.getParent().setRed(false);
        g.setRed(true);
        if ((n == n.getParent().getLeft())&&(n.getParent() == g.getLeft())){
            rightRotate(g);
        }else{
            leftRotate(g);
        }
    }

    private Node grandparent(Node n){
        if ((n != null) && (n.getParent() != null)){
            return n.getParent().getParent();
        }else{
            return null;
        }
    }

    private Node uncle(Node n){
        Node g = grandparent(n);
        if (g == null){
            return null;
        }
        if (n.getParent() == g.getLeft()){
            return g.getRight();
        }else{
            return g.getLeft();
        }
    }

    public void leftRotate(Node n) {
        Node pivot = n.getRight();
        pivot.setParent(n.getParent());
        if (n.getParent() != null) {
            if (n.getParent().getLeft() == n) {
                n.getParent().setLeft(pivot);
            } else {
                n.getParent().setRight(pivot);
            }
        }else{
            this.root = pivot;
        }

        n.setRight(pivot.getLeft());
        if (pivot.getLeft() != null){
            pivot.getLeft().setParent(n);
        }
        n.setParent(pivot);
        pivot.setLeft(n);
    }

    public void rightRotate(Node n) {
        Node pivot = n.getLeft();
        pivot.setParent(n.getParent());
        if (n.getParent() != null){
            if(n.getParent().getLeft() == n){
                n.getParent().setLeft(pivot);
            }else{
                n.getParent().setRight(pivot);
            }
        }else{
            this.root = pivot;
        }

        n.setLeft(pivot.getRight());
        if (pivot.getRight() != null){
            pivot.getRight().setParent(n);
        }

        n.setParent(pivot);
        pivot.setRight(n);
    }

    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.getKey());

            showRec(root.getLeft(), level + 1);
        }
    }

    public void insert(int key, int value) {
        this.root = insertNode(this.root, key, value, null);
        insert_case1(inRoot);
    }

    public void show() {
        showRec(root, 0);
    }

    private void inOrder(Node root, ArrayList<Integer> array) {
        if (root != null) {
            inOrder(root.getLeft(), array);
            array.add(root.getValue());
            inOrder(root.getRight(), array);
        }
    }

    public void inOrderPrint() {
        ArrayList<Integer> array = new ArrayList<Integer>();
        inOrder(this.root, array);

        for(int i = 0; i < array.size(); i++)
            System.out.print(array.get(i) + " ");
    }

    public void BFS() {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node x = q.poll();
            if (x.getLeft() != null)
                q.add(x.getLeft());
            if (x.getRight() != null)
                q.add(x.getRight());
            System.out.println(x.getRed());
        }
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
}