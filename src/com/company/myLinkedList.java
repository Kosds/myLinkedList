package com.company;

public class myLinkedList { //TODO: implements List<E>
    private class Node{
        public int data;
        public Node next;
        public Node previous;
        public Node(int data){
            this.data=data;
        }
        public Node(Node next,Node previous){
            this.next = next;
            this.previous = previous;
        }
        public Node(int data, Node next, Node previous){
            this.data=data;
            this.next = next;
            this.previous = previous;
        }
    }

    private Node head,
            end;
    private int numberOfNodes;

    public myLinkedList(){
        head = null;
        end = head;
        numberOfNodes = 0;
    }
    public myLinkedList(int[] array){

    }
    public myLinkedList(myLinkedList list){

    }

    public void add(int data){
        if(numberOfNodes == 0){
            end = head = new Node(data,end,null);
        }
        else {
            end = end.next = new Node(data,null,end);
        }
        numberOfNodes++;
    } //+
    public int get(int index) throws RuntimeException{
        if(index < 0 || index >= numberOfNodes){
            throw new RuntimeException("Неверный индекс");
        } else {
            Node current = head;
            int i = -1;
            while (++i != index) {
                current = current.next;
            }
            return current.data;
        }
    } //+
    public void set(int index, int data){
        checkHead();
        checkIndex(index);
        Node current = head;
        for(int i = 0; i != index; i++){
            current = current.next;
        }
        current.data = data;
    }
    public void insert(int index, int data) throws RuntimeException {
        checkHead();
        checkIndex(index);
        if (index == 0) {
            head = new Node(data,head.next,null);
        } else {
            Node current = head;
            for(int i = 1; i != index; i++){
                current = current.next;
            }
            current.next = new Node(data, current.next, current);
            numberOfNodes++;
        }
    } //+
    public void erase(int index) throws RuntimeException{
        checkHead();
        checkIndex(index);
        if(index == 0){
            head = head.next;
            head.previous = null;
        } else if(index == numberOfNodes - 1){
            end = end.previous;
            end.next = null;
        } else {
            Node current = head.next,
                    previous = current.previous,
                    next = head.next;
            for (int i = 1; i != index; i++) {
                previous = current;
                current = current.next;
                next = current.next;
            }
            previous.next = next;
            next.previous = previous;
        }
    } //+
    public void display() throws RuntimeException{
        checkHead();
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    } //+
    public int length(){
        return numberOfNodes;
    } //+
    public int last() throws RuntimeException {
        checkHead();
        return end.data;
    } //+
    public void reverse() throws RuntimeException{
        checkHead();
        Node current = head;
        while(current != null){
            Node temp = current.next;
            current.next = current.previous;
            current = current.previous = temp;
        }
        Node temp = head;
        head = end;
        end = temp;
    } //+
    /*
    public int isContains(int data){

    }
    public void sort(){
        myLinkedList result = new myLinkedList();

    } // todo: Hoar
    public int indexOf(int data){

    } // todo: binary
    */

    private void checkHead() throws RuntimeException{
        if(head == null){
            throw new RuntimeException("Список пуст");
        }
    }
    private void checkIndex(int index) throws RuntimeException{
        if(index < 0 || index >= numberOfNodes){
            throw new RuntimeException("Неверный индекс");
        }
    }
}