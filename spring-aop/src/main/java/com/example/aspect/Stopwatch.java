package com.example.aspect;

public class Stopwatch {
    private long startTime;
    private long endTime;
    
    public void start() {
        startTime = System.currentTimeMillis();
    }
    
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    
    public void displayElapsedTime(String methodName) {
        double elapsed = (endTime - startTime) / 1000.0;
        System.out.println("Elapsed time for " + methodName + " is " + elapsed + " seconds");
    }
}