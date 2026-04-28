/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.psu.examplefirst;

import java.io.*;
import java.net.*;

/**
 *
 * @author Asus
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {

        String ip = "localhost";
        
        try (Socket socket = new Socket(ip, SixthTask.PORT);
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream())){
            
            double bot = dis.readDouble();
            double top = dis.readDouble();
            double step = dis.readDouble();
            
            int thCount = 6;
            
            RecIntegralTH[] integrals = new RecIntegralTH[thCount];
            Thread[] threads = new Thread[thCount];
                
            double range = (top - bot) / thCount; //6 частей
            
            for (int i = 0; i < thCount; i++){
                //создание и запуск нитей
                double start = bot + i * range;
                double end = (i == thCount - 1) ? top : start + range;

                integrals[i] = new RecIntegralTH(start, end, step);
                threads[i] = new Thread(integrals[i]);
                
                
                threads[i].start();
                               
            }
            
            double result = 0.0;
            for (int i = 0; i < thCount; i++){
                //System.out.println("result of " + (i + 1) + " thread is : " + integrals[i].getResult());
                 
                threads[i].join(); //ожидание окончания работы потока
                result += integrals[i].getResult();
            }
            
            dos.writeDouble(result);
            dos.flush();
            
        } catch (IOException e) {
            
        } catch (InvalidValueException e) {
            
        }
    }    
}
