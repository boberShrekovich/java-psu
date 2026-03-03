/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.psu.examplefirst;

/**
 *
 * @author Asus
 */
public class RecIntegral{
    private double botLimit, topLimit, step, result;
    
    public RecIntegral(double botLimit, double topLimit, double step) throws InvalidValueException {
        if (botLimit < 0.000001 || botLimit > 1000000)
            throw new InvalidValueException("The value of the bottom limit of the integral\n must be between 0.000001 and 1000000!!!");
        
        if (topLimit < 0.000001 || topLimit > 1000000)
            throw new InvalidValueException("The value of the top limit of the integral\n must be between 0.000001 and 1000000!!!");
        
        if (step < 0.000001 || step > 1000000)
            throw new InvalidValueException("The value of the step of the integral\n must be between 0.000001 and 1000000!!!");
        
        if (botLimit >= topLimit)
            throw new InvalidValueException("The value of the bottom limit must not be greater than the top limit!!!");
           
        
        
        this.botLimit = botLimit;
        this.topLimit = topLimit;
        this.step = step;
        this.result = 0.0;
    }
    
    private static double Function(double x){
        return java.lang.Math.sqrt(x);
    }

    public double Integral(){
        result = 0.0;
        
        int n = (int)((topLimit - botLimit) / step);
        double last = botLimit + n * step;
        
        for (int i = 0; i < n - 1; i++){
            double x0 = botLimit + i * step;
            double x1 = botLimit + (i + 1) * step;
            result += (Function(x0) + Function(x1)) * step / 2;
        }      
                
        double x = (last < topLimit) ? ((Function(last) + Function(topLimit)) * (topLimit - last) / 2) : 0;
        result += x;
        
        return result;
    }    
    
    public void setBotLimit(double botLimit){
        this.botLimit = botLimit;
    }
    
    public double getBotLimit(){
        return botLimit;
    }
    
    public void setTopLimit(double topLimit){
        this.topLimit = topLimit;
    }
    
    public double getTopLimit(){
        return topLimit;
    }
    
    public void setStep(double step){
        this.step = step;
    }
    
    public double getStep(){
        return step;
    }
    
    public void setResult(double result){
        this.result = result;
    }
    
    public double getResult(){
        return result;
    }
    
}
