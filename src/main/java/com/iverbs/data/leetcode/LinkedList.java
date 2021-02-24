package com.iverbs.data.leetcode;

public class LinkedList {
    
    Node head;
    
    static class Node {
        Node next;
        int value;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    public static void printList(Node node) {
        while(node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
    
    public static Node reverseList(Node node) {
        Node next=null;
        Node prev=null;
        Node current = node;
        
        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        
        printList(list.head);
        
        list.head = list.reverseList(list.head);
        
        System.out.println("###################################################");
        
        printList(list.head);
        
    }

}
