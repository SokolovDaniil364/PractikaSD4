/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pr4_sokolovdvTask2;

/**
 *
 * @author Student
 */
public class Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Поток A", 10));
        Thread thread2 = new Thread(new MyRunnable("Поток B", 20));
        Thread thread3 = new Thread(new MyRunnable("Поток C", 30));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyRunnable implements Runnable {
    private final String name;
    private final int delay;

    public MyRunnable(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": сообщение " + i);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(name + " прерван");
            }
        }
    }
}
