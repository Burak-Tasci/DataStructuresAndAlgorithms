import javax.management.NotificationEmitter;

public class clist {

    Node head;
    Node tail;

    public clist(int data) {
        head = new Node(data);
        head.next = tail;

    }

    public clist() {
        head = null;
        tail = null;
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = newNode;
            tail = newNode;
            tail.next = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }
    public boolean remove(int index)
    {
        Node iter = head;
        if (index == 0)
        {
            head = head.next;
            tail.next = head;
            return true;
        }
        else if (index == this.size()-1)
        {
            do {
                iter = iter.next;
            }while (iter.next != tail);
            tail = iter;
            tail.next = head;
            return true;
        }
        else
        {
            for (int i = 0; i<index-1;i++)
            {
                iter = iter.next;
            }
            iter.next = iter.next.next;
            return true;
        }
    }

    public void display()
    {
        Node iter = head;
        System.out.print("[");
        do {
            System.out.print(iter.data+"\t");
            iter = iter.next;
        }while (iter!=head);
        System.out.print("]\n");
    }

    public int size()
    {
        int i = 0;
        Node iter = head;
        do {
            i++;
            iter = iter.next;
        }while (iter!=head);

        return i;
    }

    public class Node
    {
        Node next;
        int data;

        Node(int data)
        {
            this.data = data;
        }

        public Node() {
        }
    }
}
