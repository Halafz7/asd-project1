import math
import random

# class data
class Mahasiswa:
    def __init__(self, nama, prodi, tinggi, berat, hobby):
        self.nama = nama
        self.prodi = prodi
        self.tinggi = tinggi
        self.berat = berat
        self.hobby = hobby

    def __str__(self):
        return f"{self.nama} {self.prodi} {self.tinggi} {self.berat} {self.hobby}"

class Node:
    def __init__(self, data: Mahasiswa):
        self.data = data
        self.next = None
    
    def getData(self):
        return self.data
    
    def getNext(self):
        return self.next
    
    def setData(self, data):
        self.data = data

class LinkedList:
    def __init__(self):
        self.head = None

    def insert(self, data):
        new_node = Node(data)
        
        if self.head is None:
            self.head = new_node
        else:
            current_node = self.head
            while current_node.getNext() is not None:
                current_node = current_node.getNext()
            current_node.next = new_node

    def print_list(self):
        current_node = self.head
        while current_node is not None:
            print(current_node.getData())
            current_node = current_node.getNext()

    def find_name(self, name) -> list:
        result = []
        current_node = self.head
        while current_node is not None:
            if current_node.getData().nama == name:
                result.append(current_node.getData())
            current_node = current_node.getNext()
        return result
    
    def find_prodi(self, prodi) -> list:
        result = []
        current_node = self.head
        while current_node is not None:
            if current_node.getData().prodi == prodi:
                result.append(current_node.getData())
            current_node = current_node.getNext()
        return result
    
    def delete_node(self, name):
        current_node = self.head
        previous_node = None
        while current_node is not None:
            if current_node.getData().nama == name:
                if previous_node is None:
                    self.head = current_node.getNext()
                else:
                    previous_node.next = current_node.getNext()
                break
            previous_node = current_node
            current_node = current_node.getNext()


# main program
if __name__ == "__main__":
    
    # Read file
    try:
        with open("D:/Afif/UGM/KULIAH LUR/SMT 6/Algoritma dan Struktur Data/Tugas/Setelah UTS/asd-project1/Python/dataset.txt", "r") as file:
            lines = file.readlines()
            lines = [line.strip() for line in lines]
            lines = [line.split(",") for line in lines]
            data_mahasiswa = [[line[0].capitalize(), line[1].title(), line[2], line[3], line[4].title()] for line in lines]
            data_mahasiswa = [Mahasiswa(*data) for data in data_mahasiswa]
    except FileNotFoundError:
        print("File not found")
        exit(1)

    # Create linked list
    linked_list = LinkedList()
    for data in data_mahasiswa:
        linked_list.insert(data)

    # Print linked list
    linked_list.print_list()
    print("====================================================\n")

    # Search linked list

    # Cari Mahasiswa dengan program studi Ilmu Komputer
    print("1. Cari Mahasiswa dengan program studi Ilmu Komputer\n")
    result = linked_list.find_prodi("Ilmu Komputer")
    for data in result:
        print(data)

    print("====================================================\n")

    # Cari Mahasiswa dengan tinggi badan lebih dari 170 cm
    print("2. Cari Mahasiswa dengan tinggi badan lebih dari 170 cm\n")
    current_node = linked_list.head
    while current_node is not None:
        if int(current_node.getData().tinggi) > 170:
            print(current_node.getData())
        current_node = current_node.getNext()

    print("====================================================\n")

    # Cari Mahasiswa yang memiliki hobby bermain musik dan basket
    print("3. Cari Mahasiswa yang memiliki hobby bermain musik dan basket\n")
    current_node = linked_list.head
    while current_node is not None:
        if current_node.getData().hobby == "Bermain Musik" or current_node.getData().hobby == "Basket":
            print(current_node.getData())
        current_node = current_node.getNext()