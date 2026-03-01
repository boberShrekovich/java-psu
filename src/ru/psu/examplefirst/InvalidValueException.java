/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.psu.examplefirst;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class InvalidValueException extends Exception {
    public InvalidValueException(String description){
        JOptionPane.showMessageDialog(null, description, "ERROR!!!", JOptionPane.ERROR_MESSAGE);
    }
}
