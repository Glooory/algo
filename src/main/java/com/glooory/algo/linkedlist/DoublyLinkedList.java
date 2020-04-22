package com.glooory.algo.linkedlist;

public class DoublyLinkedList {
    private Node head;

    public DoublyLinkedList() {}

    public DoublyLinkedList(Node node) {
        this.head = node;
    }

    public Node head() {
        return this.head;
    }

    public Node insertFirst(Node node) {
        if (node == null) {
            return null;
        }

        if (head == null) {
            head = node;
            return head;
        }

        head.prev = node;
        node.next = head;
        head = node;
        return node;
    }

    public Node insertLast(Node node) {
        if (node == null) {
            return null;
        }

        if (head == null) {
            head = node;
            return node;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        node.prev = curr;
        curr.next = node;
        return node;
    }

    public boolean insertBefore(Node anchorNode, Node nodeToInsert) {
        if (anchorNode == null || nodeToInsert == null) {
            return false;
        }

        // Insert to first
        if (anchorNode == head) {
            anchorNode.prev = nodeToInsert;
            nodeToInsert.next = anchorNode;
            head = nodeToInsert;
            return true;
        }

        Node existNode = find(anchorNode);
        if (existNode != null) {
            anchorNode.prev.next = nodeToInsert;
            nodeToInsert.prev = anchorNode.prev.next;
            nodeToInsert.next = anchorNode;
            anchorNode.prev = nodeToInsert;
            return true;
        }

        return false;
    }

    public boolean insertAfter(Node anchorNode, Node nodeToInsert) {
        if (anchorNode == null || nodeToInsert == null) {
            return false;
        }

        Node existNode = find(anchorNode);
        if (existNode != null) {
            if (anchorNode.next == null) {
                // Insert to last
                nodeToInsert.prev = anchorNode;
                anchorNode.next = nodeToInsert;
            } else {
                anchorNode.next.prev = nodeToInsert;
                nodeToInsert.next = anchorNode.next;
                nodeToInsert.prev = anchorNode;
                anchorNode.next = nodeToInsert;
                return true;
            }
            return true;
        }

        return false;
    }

    public boolean contains(Node node) {
        if (node == null || head == null) {
            return false;
        }

        Node curr = head;
        while (curr != null) {
            if (curr == node) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }

        // Only one piece of data
        if (head.next == null) {
            Node first = head;
            head = null;
            return first;
        }

        Node first = head;
        head.next.prev = null;
        head = head.next;
        return first;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }

        // Only one piece of data
        if (head.next == null) {
            Node last = head;
            head = null;
            return last;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.prev.next = null;
        curr.prev = null;
        return curr;
    }

    public boolean remove(Node node) {
        if (node == null || head == null) {
            return false;
        }

        Node existNode = find(node);
        if (existNode != null) {
            // Only one item
            if (node.prev == null && node.next == null) {
                head = null;
                return true;
            }

            // First one
            if (node.prev == null) {
                node.next.prev = null;
                head = node.next;
                node.next = null;
                return true;
            }

            // Last one
            if (node.next == null) {
                node.prev.next = null;
                node.prev = null;
                return true;
            }

            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
            return true;
        }

        return false;
    }

    private Node find(Node node) {
        Node curr = head;
        while (curr != null) {
            if (curr == node) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }


    public static class Node<T> {
        private T data;
        private Node prev;
        private Node next;

        public Node(T t) {
            this.data = t;
        }

        public T getValue() {
            return this.data;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public Node getNext() {
            return this.next;
        }
    }
}
