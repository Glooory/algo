package com.glooory.algo.stack;

public class StackBasedOnLinkedList {
    private Node top = null;

    public StackBasedOnLinkedList() {}

    public void push(int value) {
        Node node = new Node(value);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public int pop() {
        if (top == null) {
            return Integer.MIN_VALUE;
        }
        int data = top.value;
        top = top.next;
        return data;
    }

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return this.value;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return next;
        }
    }
}
