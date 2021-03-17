package com.burak.doublyLinkedList;

public class doublyLinkedL {

    private Node head;
    private Node tail;
    private int length;

    public doublyLinkedL(int[] arr) {
        this.head = null;
        this.tail = null;
        this.length = 0;
        for (int i=0;i<arr.length;i++)
            this.add(arr[i]);
    }

    public doublyLinkedL() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public doublyLinkedL(int data) {
        this.head = new Node(data);
        this.tail = null;
        this.length = 1;
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public void add(int data)
    {
        Node temp = new Node(data);
        if(head == null)
            head = temp;
        else
        {
            Node iter = head;
            while (iter.next != null)
                iter = iter.next;

            iter.next = temp;
            temp.prev = iter;
            tail = temp;
        }

        this.length++;
    }

    public void display()
    {
        Node iter = head;
        System.out.print("[");
        while(iter != null)
        {
            System.out.print(iter.data+"\t");
            iter = iter.next;
        }
        System.out.println("]");
    }

    public void reverseDisplay()
    {
        Node iter = tail;
        System.out.print("[");
        while(iter != null)
        {
            System.out.print(iter.data+"\t");
            iter = iter.prev;
        }
        System.out.println("]");
    }

    public boolean removeByIndex(int index)
    {
        if (index < 0)
        {
            System.out.println("Out of index");
            return false;
        }
        if (index >= length)
        {
            System.out.println("Out of index");
            return false;
        }

        if (index == length-1)
        {
            tail.prev.next = null;
            tail = tail.prev;
            length--;
            return true;
        }

        Node iter;
        int i;
        if (index == 0)
        {
            head.next.prev = null;
            head = head.next;
            length--;
            return true;
        }

        if (index > this.length / 2)
        {
            iter = tail;
            for (i = this.length-1; i>index;i--)
                iter = iter.prev;

            iter.next.prev = iter.prev;
            iter.prev.next = iter.next;
            length--;
            return true;
        }
        else if (index <= this.length / 2)
        {
            iter = head;
            for(i = 0; i<index;i++)
                iter = iter.next;

            iter.next.prev = iter.prev;
            iter.prev.next = iter.next;
            length--;
            return true;
        }
        return false;

    }

    public boolean insert(int index, int data)
    {
        Node iter;
        Node temp = new Node(data);
        iter = takeNodebyIndex(index);
        if (index == 0)
        {
            temp.next = iter;
            iter.prev = temp;
            head = temp;
        }
        else if (index == length-1)
        {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        else
        {
            temp.next = iter;
            temp.prev = iter.prev;
            iter.prev.next = temp;
            iter.prev = temp;
            return true;
        }
        return false;


    }

    public void selectionSort()
    {

    }
    public void insertionSort()
    {

    }
    public void bubbleSort()
    {

    }
    public void mergeSort()
    {

    }
    public boolean swap(int i, int j)
    {
        if (i == j)
        {
            System.out.println("You cannot swap same node");
            return false;
        }
        int iteratorIndex;
        Node firstIter;
        Node secondIter;

        firstIter = takeNodebyIndex(i);
        secondIter = takeNodebyIndex(j);

        this.insert(j, firstIter.data);
        this.insert(i, secondIter.data);

        this.removeByIndex(i+1);
        this.removeByIndex(j+1);
        return true;







    }

    public Node takeNodebyIndex(int i)
    {
        Node iter;
        int iteratorIndex;
        if (i < this.length-1)
        {
            iteratorIndex = 0;
            iter = head;
            while(iteratorIndex++<i)
                iter = iter.next;

        }
        else {
            iteratorIndex = this.length-1;
            iter = head;
            while(iteratorIndex--<i)
                iter = iter.prev;
        }
        return iter;
    }

    public doublyLinkedL subList(int end)
    {
        Node iter = head;
        doublyLinkedL subList = new doublyLinkedL(iter.data);
        for (int i =0; i<end;i++)
        {
            iter = iter.next;
            subList.add(iter.data);
        }
        return subList;
    }

    public doublyLinkedL subList(int start, int end)
    {
        Node iter = takeNodebyIndex(start);
        doublyLinkedL subList = new doublyLinkedL(iter.data);
        for (int i =0; i<end-start;i++)
        {
            iter = iter.next;
            subList.add(iter.data);
        }
        return subList;
    }
    public class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        public Node(int data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
            this.next = null;
            this.prev = null;
        }
        public Node(Node prev, Node next) {
            this.next = next;
            this.prev = prev;
        }
    }



}
