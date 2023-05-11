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
        Scanner sc = new Scanner(new FileReader("D:/Afif/UGM/KULIAH LUR/SMT 6/Algoritma dan Struktur Data/Tugas/Setelah UTS/asd-project1/JAVA/dataset.txt"));
        
        String nama, prodi, hobby;
        int tinggi, berat;
        Mhs m;
        Node node;
        
        try{
            while (sc.hasNextLine()) {
                nama = sc.nextLine();
                prodi = sc.nextLine();
                tinggi = Integer.parseInt(sc.nextLine());
                berat = Integer.parseInt(sc.nextLine());
                hobby = sc.nextLine();
    
                m = new Mhs(nama, prodi, tinggi, berat, hobby);
                node = new Node(m);
            }
            if  (sc.hasNextLine())
                sc.nextLine();
                sc.close();
        }
        catch(Exception error){
            System.out.println("File not Found");
        }
    }
}
