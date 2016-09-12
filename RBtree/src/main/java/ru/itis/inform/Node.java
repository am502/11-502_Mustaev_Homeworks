package ru.itis.inform;

public class Node {
    private int value;
    private int key;
    private Node left;
    private Node right;
    private Node parent;
    private boolean isRed;

    public Node(int key, int value, Node parent) {
        this.key = key;
        this.value = value;
        this.isRed = true;
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node parent){
        this.parent =  parent;
    }

    public int getValue(){
        return value;
    }

    public int getKey(){
        return key;
    }

    public void setRed(boolean red){
        this.isRed = red;
    }

    public boolean getRed(){
        return isRed;
    }
}