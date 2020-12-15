package com.company;

import java.util.Arrays;
import java.util.Random;

public class Queue {
    private int [] queue_mass;
    private int elements=0;
    private int begin;
    private int end;

    Queue(int value){
        queue_mass=new int[value];
        begin=-1;
        end=-1;
    }

    public void create(){
        Random rand = new Random();
        while(!isFull()){
            add(Math.abs(rand.nextInt())%1000);
        }
    }

    public void add(int element){
        if(!isFull()) {
            elements++;
            end = (end + 1) % queue_mass.length;
            queue_mass[end % queue_mass.length] = element;
        }
        else{
            System.out.println("queue is full");
        }
    }
    public int pull(){
        elements--;
        begin=(begin+1)%queue_mass.length;
        return queue_mass[begin];
    }

    public void delete(){
        elements--;
        begin=(begin+1)%queue_mass.length;
    }

    public boolean isFull(){
        if(elements!=queue_mass.length) return false;
        else return true;
    }

    public boolean isEmpty(){
        if(elements==0) return true;
        else return false;
    }

    public int ValueOfElements(){
        return elements;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queue_mass=" + Arrays.toString(queue_mass) +
                ", begin=" + (begin+1)%queue_mass.length +
                ", end=" + end +
                ", isFull=" + isFull() +
                ", isEmpty=" + isEmpty() +
                ", elements=" + elements +
                '}';
    }
}
