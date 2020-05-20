/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.model;

import java.io.Serializable;

/**
 *
 * @author thanh
 */
public class Model implements Serializable{
    public Model(){
    }
    
    public double Addition(double a, double b){
        return a+b;
    }
    public double Subtraction(double a, double b){
        return a-b;
    }
    public double Multiplication(double a, double b){
        return a*b;
    }
    public double Division(double a, double b){
        return a/b;
    }
}
