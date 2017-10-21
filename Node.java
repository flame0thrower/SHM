package com.company;

public class Node {
    private Object key;
    private Object value;
    private Node nextNode;
    private Node prevNode;

    public Node(Object key, Object value){
        this.key = key;
        this.value = value;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public Object getKey() {
        return key;
    }
}
