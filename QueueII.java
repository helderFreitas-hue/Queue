package Queue;

import java.util.Scanner;

class Order {
    String name;
    String barang;
    int harga;
    int jumlah;

    Order(String n, String b, int h, int j) {
        name = n;
        barang = b;
        harga = h;
        jumlah = j;
    }
}

class Node {
    Order order;
    Node next;
}

class Queue {
    Node front, rear;

    void enqueue(Order ord) {
        Node newNode = new Node();
        newNode.order = ord;

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Order berhasil ditambahkan.");
    }

    void dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong!");
            return;
        }

        System.out.println("\nOrder diproses:");
        System.out.println("Pembeli : " + front.order.name);
        System.out.println("Barang  : " + front.order.barang);
        System.out.println("Harga   : " + front.order.harga);
        System.out.println("Jumlah  : " + front.order.jumlah);

        front = front.next;

        if (front == null) {
            rear = null;
        }
    }

    void view() {
        if (front == null) {
            System.out.println("Antrian kosong!");
            return;
        }

        System.out.println("\n===== DAFTAR ANTRIAN =====");

        int no = 1;
        for (Node temp = front; temp != null; temp = temp.next) {
            System.out.println("Antrian ke-" + no);
            System.out.println("Pembeli : " + temp.order.name);
            System.out.println("Barang  : " + temp.order.barang);
            System.out.println("Harga   : " + temp.order.harga);
            System.out.println("Jumlah  : " + temp.order.jumlah);
            System.out.println("----------------------");
            no++;
        }
    }
}

public class QueueII {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue queue = new Queue();

        int pilih;

        do {
            System.out.println("\n=== PROGRAM ANTRIAN PEMBELIAN BARANG ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Proses Antrian");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilihan : ");
            pilih = sc.nextInt();

            switch (pilih) {

                case 1:
                    sc.nextLine();

                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();

                    System.out.print("Nama Barang  : ");
                    String barang = sc.nextLine();

                    System.out.print("Harga Barang : ");
                    int harga = sc.nextInt();

                    System.out.print("Jumlah Barang: ");
                    int jumlah = sc.nextInt();

                    Order ord = new Order(nama, barang, harga, jumlah);

                    queue.enqueue(ord);
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.view();
                    break;

                case 4:
                    System.out.println("Terima kasih...");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilih != 4);

        sc.close();
    }
}