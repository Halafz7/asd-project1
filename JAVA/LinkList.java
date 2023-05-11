package JAVA;

import java.util.*;
import java.io.*;
import java.lang.*;

class Mahasiswa {
    private String nama;
    private String prodi;
    private int tinggi;
    private int berat;
    private String hobby;

    public Mahasiswa(String nama, String prodi, int tinggi, int berat, String hobby) {
        this.nama = nama;
        this.prodi = prodi;
        this.tinggi = tinggi;
        this.berat = berat;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return this.nama + " " + this.prodi + " " + this.tinggi + " " + this.berat + " " + this.hobby;
    }

    public Object getNama() {
        return null;
    }

    public Object getProdi() {
        return null;
    }
}

class Node {
    private Mahasiswa data;
    private Node next;

    public Node(Mahasiswa data) {
        this.data = data;
        this.next = null;
    }

    public Mahasiswa getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setData(Mahasiswa data) {
        this.data = data;
    }
    public void setNext(Node nextValue) {
        next = nextValue;
}

public class LinkList {
    private Node head;

    public LinkList() {
        this.head = null;
    }

    public void insert(Mahasiswa data) {
        Node new_node = new Node(data);

        if (this.head == null) {
            this.head = new_node;
        } else {
            Node current_node = this.head;
            while (current_node.getNext() != null) {
                current_node = current_node.getNext();
            }
            current_node.setNext(new_node);
        }
    }

    public void printList() {
        Node current_node = this.head;
        while (current_node != null) {
            System.out.println(current_node.getData());
            current_node = current_node.getNext();
        }
    }

    public List<Mahasiswa> findName(String name) {
        List<Mahasiswa> result = new ArrayList<>();
        Node current_node = this.head;
        while (current_node != null) {
            if (current_node.getData().getNama().equals(name)) {
                result.add(current_node.getData());
            }
            current_node = current_node.getNext();
        }
        return result;
    }

    public List<Mahasiswa> findProdi(String prodi) {
        List<Mahasiswa> result = new ArrayList<>();
        Node current_node = this.head;
        while (current_node != null) {
            if (current_node.getData().getProdi().equals(prodi)) {
                result.add(current_node.getData());
            }
            current_node = current_node.getNext();
        }
        return result;
    }

    public void deleteNode(String name) {
        Node current_node = this.head;
        Node previous_node = null;
        while (current_node != null) {
            if (current_node.getData().getNama().equals(name)) {
                if (previous_node == null) {
                    this.head = current_node.getNext();
                } else {
                    previous_node.setNext(current_node.getNext());
                }
                break;
            }
            previous_node = current_node;
            current_node = current_node.getNext();
        }
    }
}

public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(new FileReader("D:/Afif/UGM/KULIAH LUR/SMT 6/Algoritma dan Struktur Data/Tugas/Setelah UTS/asd-project1/JAVA/dataset.txt"));
    
    String nama, prodi, hobby;
    int tinggi, berat;
    Mahasiswa m;
    Node node;
    
    try{
        while (sc.hasNextLine()) {
            nama = sc.nextLine();
            prodi = sc.nextLine();
            tinggi = Integer.parseInt(sc.nextLine());
            berat = Integer.parseInt(sc.nextLine());
            hobby = sc.nextLine();

            m = new Mahasiswa(nama, prodi, tinggi, berat, hobby);
            node = new Node(m);
        }
        if (sc.hasNextLine()){
            sc.nextLine();
            sc.close();
        }
    }
    catch(Exception error){
        System.out.println("File not Found");
    }
}
}