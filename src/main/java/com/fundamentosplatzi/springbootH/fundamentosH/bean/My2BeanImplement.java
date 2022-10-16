package com.fundamentosplatzi.springbootH.fundamentosH.bean;

public class My2BeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación 2 propia del Bean");
    }
}
