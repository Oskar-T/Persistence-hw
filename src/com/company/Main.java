package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        hw_one_five();

    }

    public static void Read(String fname) {
        try (Scanner in = new Scanner(new File(fname))) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(in.nextLine());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void Write(String fname) {
        try (PrintWriter out = new PrintWriter(new File(fname))) {
            for (int i = 0; i < 1000; i++) {
                out.println(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void hw1() {
        String fname = "C:\\Users\\Coder\\Desktop\\hw-1.txt";
        File file = new File(fname);
        if (file.exists()) {
            Read(fname);
        } else {
            Write(fname);
            Read(fname);
        }
    }

    public static void hw_one_four() {
        String fname = "C:\\Users\\Coder\\Desktop\\hw-1.txt";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fname))) {
            for (int i = 0; i < 1000; i++) {
                out.writeInt(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname))) {
            for (int i = 0; i < 1000; i++) {
                System.out.println(in.readInt());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void hw_one_five() {

        String fname = "C:\\Users\\Coder\\Desktop\\hw-1.txt";
        try (RandomAccessFile out = new RandomAccessFile(fname, "rw")) {
            for (int i = 0; i < 1000; i++) {
                out.writeInt(i);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try(RandomAccessFile in = new RandomAccessFile(fname, "r")) {
            for(int i = 100; i != 1000; i+=100) {
                in.seek(i * Integer.BYTES);
                System.out.println(in.readInt());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}





