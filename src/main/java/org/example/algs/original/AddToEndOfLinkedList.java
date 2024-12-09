package org.example.algs.original;


import java.util.ArrayList;
import java.util.List;

/// Ростелеком
/// Написать метод, который будет сохранять элементы в конец списка LinkedList
public class AddToEndOfLinkedList {

    public static void main(String[] args) {
        AddToEndOfLinkedList linkedList = new AddToEndOfLinkedList();
        linkedList.add(4);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(8);
        System.out.println(linkedList.getAllNodes());
    }


    private TreeNode head;
    private TreeNode tail;

    public AddToEndOfLinkedList() {
        this.head = new TreeNode();
        this.tail = head;
    }

    private class TreeNode {
        int value;
        TreeNode prev;
        TreeNode next;
    }



    private void add(int val){
        while (tail.next != null){
            tail = tail.next;
        }
        TreeNode node = new TreeNode();
        node.value = val;
        tail.next = node;
    }

    private List<Integer> getAllNodes(){
        TreeNode tempHead = head.next;
        List<Integer> list = new ArrayList<>();
        while (tempHead.next != null){
            list.add(tempHead.value);
            tempHead = tempHead.next;
        }
        list.add(tempHead.value);
        return list;
    }
}
