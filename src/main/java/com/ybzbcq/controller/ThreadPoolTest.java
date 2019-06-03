package com.ybzbcq.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i =0; i< 5; i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("次数 ：" + 0);
                }
            });

        }

        executor.shutdown();


    }
}
