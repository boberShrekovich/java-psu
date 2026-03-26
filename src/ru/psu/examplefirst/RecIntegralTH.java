/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.psu.examplefirst;

/**
 *
 * @author Asus
 */
public class RecIntegralTH implements Runnable {
    private final RecIntegral integral;
    private double result;
    
    public RecIntegralTH(double botLimit, double topLimit, double step) throws InvalidValueException{
        this.integral = new RecIntegral(botLimit, topLimit, step);
    }
    
    @Override
    public void run(){
        this.result = integral.Integral();
    }
    
    public double getResult(){
        return result;
    }
    
}
