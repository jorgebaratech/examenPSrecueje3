/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenpseje3;

/**
 *
 * @author norri
 */
import java.util.Arrays;
import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        
        int[] array = new Random().ints(1, 100).limit(new Random().nextInt(100)).toArray();

       
        System.out.println("Array sin ordenar: " + Arrays.toString(array));

       
        MiThread miThread = new MiThread(array);
        
        miThread.start();
       
        try {
            miThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        int[] resultado = miThread.getResultado();

        System.out.println("Array ordenado: " + Arrays.toString(resultado));
    }
}


class MiThread extends Thread {
    private int[] array;
    private int[] resultado;

    public MiThread(int[] array) {
        
        this.array = array;
    }

    @Override
    public void run() {  
        int[] pares = new int[array.length];
        int indice = 0;
        
        for (int num : array) {
            if (num % 2 == 0) {
                pares[indice++] = num;
            }
        }
        resultado = new int[indice];
        System.arraycopy(pares, 0, resultado, 0, indice);
        Arrays.sort(resultado);
    }

    public int[] getResultado() {
        return resultado;
    }
}