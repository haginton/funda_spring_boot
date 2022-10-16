package com.fundamentosplatzi.springbootH.fundamentosH.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    //Inyectamos una dependencia dentro de esta clase que tambien sera una dependencia
    private MyOperation myOperation;

    @Autowired
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;
        //Imprimimos la implmenetación de la dependencia inyectada
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde la implementación de un Bean con dependencia");
    }
}
