package com.fundamentosplatzi.springbootH.fundamentosH.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación propia del Bean");
    }
}
