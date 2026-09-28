import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insertAtFront(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    void insertAtEnd(int data) {
        Node temp = new Node(data);

        if (head == null) {
            head = temp;
            return;
        }

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = temp;
    }

    void deleteAtFront() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        head = head.next;
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node curr = head;

        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;
    }

    void display() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter element to insert at front: ");
        int a = sc.nextInt();
        list.insertAtFront(a);

        System.out.print("Enter element to insert at end: ");
        int b = sc.nextInt();
        list.insertAtEnd(b);

        System.out.println("Linked List:");
        list.display();

        System.out.print("Enter element to insert at front: ");
        int c = sc.nextInt();
        list.insertAtFront(c);

        System.out.println("After insertion at front:");
        list.display();

        System.out.print("Enter element to insert at end: ");
        int d = sc.nextInt();
        list.insertAtEnd(d);

        System.out.println("After insertion at end:");
        list.display();

        list.deleteAtFront();

        System.out.println("After deletion at front:");
        list.display();

        list.deleteAtEnd();

        System.out.println("After deletion at end:");
        list.display();

        sc.close();
    }
}