package JAVA;

import java.util.*;
import java.io.*;
import java.lang.*;

class Mhs {
    String nama, prodi, hobby;
    int tinggi, berat;

    public Mhs(String nama, String prodi, int tinggi, int berat, String hobby) {
        this.nama = nama;
        this.prodi = prodi;
        this.tinggi = tinggi;
        this.berat = berat;
        this.hobby = hobby;
    }

    public void display() {
        System.out.println(this.nama + " " + this.prodi +
                " " + this.tinggi + " " + this.berat + " " + this.hobby);
    }

}

public class LinkedList {
    static class Node {
        Mhs info;
        Node next;

        public Node(Mhs info) {
            this.info = info;
            next = null;
        }

        public Node(Mhs info, Node node) {
            this.info = info;
            next = node;
        }
    }

    static class LList {
        Node head, tail;

        public LList() {
            head = tail = null;
        }

        public void addToTail(Node node) {
            if (head == null) {
                head = tail = null;
                return;
            }
            tail.next = node;
            tail = node;
        }

        public void addToHead(Node node) {
            if (head == null) {
                head = tail = null;
                return;
            }
            node.next = head;
            head = node;
        }

        public void printAll() {
            Node temp = head;
            while (temp != null) {
                temp.info.toString();
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new FileReader("dataset.txt"));
        LList list = new LList();

        String nama, prodi, hobby;
        int tinggi, berat;
        Mhs m;
        Node node;

        while (sc.hasNext()) {
            nama = sc.nextLine();
            prodi = sc.nextLine();
            tinggi = sc.nextInt();
            berat = sc.nextInt();
            hobby = sc.nextLine();

        }
    }
}
