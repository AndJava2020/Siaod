package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueBranch {
    ArrayList<Queue> queues;
    int maxElem=(int)(Math.random()+1)*20;
    int [][] allNumbers;
    QueueBranch(int value){
        queues=new ArrayList<>();
        allNumbers = new int[value][];

        for (int i = 0; i < value ; i++) {
            allNumbers[i]=new int[maxElem];//инициализируем cтолбцы массива для каждой очереди
        }
        for (int i = 0; i < value ; i++) {
            Queue ex= new Queue(maxElem);
            ex.create();
            queues.add(ex);
        }

        for (int i = 0; i < queues.size() ; i++) {//заполняем массив
            int j=0;
            while(!queues.get(i).isEmpty()){

                allNumbers[i][j]= queues.get(i).pull();
                j++;
            }
        }
    }

    public void out(){
        for (int i = 0; i < queues.size() ; i++) {
            System.out.print(i+1+": ");
            for (int j = 0; j < allNumbers[i].length ; j++) {
                System.out.print(allNumbers[i][j] +" ");
            }
            System.out.println();
        }
    }

    private int [] BranchSort(int[] input){
        int[]b= Arrays.copyOf(input,input.length);

        ArrayList<Integer>[] branches = new ArrayList[10]; //куда подвешивать числа
        for (int i = 0; i < branches.length; i++) {
            branches[i] = new ArrayList<Integer>();
        }
        int  divisor = 1,max=0;//делитель
        for (int i = 0; i < b.length ; i++) {
            max=Integer.max(b[i],max);
        }
        label:
        while (true) {
            for (int i=0; i<b.length;i++) {
                int tmp = b[i] / divisor;
                branches[tmp % 10].add(b[i]);//подвешимаем числа
            }
            for (int l = 0,k=0; l < 10; l++) {
                for (int i : branches[l]) { //проходим по числам с разрядами 0,1,2,...
                    b[k++] = i; //сортируем исходный массив по соотвествующим разрядам
                }
                if(branches[0].size()==b.length && max/divisor==0) break label; // если все числа подвешены к 0
                branches[l].clear();
            }
            divisor *= 10;
        }
        return b;
    }
    public void sort(){
        for (int i = 0; i < allNumbers.length; i++) {
            allNumbers[i]=BranchSort(allNumbers[i]);
        }
    }

}
