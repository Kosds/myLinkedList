package com.company;

public class Main {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        for(int i = 0; i< 15; i++ ){
            list.add(i);
        }
        list.display();
        list.set(4,100);
        list.display();
    }
}
