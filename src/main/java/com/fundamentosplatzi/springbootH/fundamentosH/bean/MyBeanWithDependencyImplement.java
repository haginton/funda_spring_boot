package com.fundamentosplatzi.springbootH.fundamentosH.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    //Inyectamos una dependencia dentro de esta clase que tambien sera una dependencia
    private MyOperation myOperation;

    @Autowired
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos ingresado al metodo printWithDependency");
        int number = 1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operación es: " + number);
        //Imprimimos la implmenetación de la dependencia inyectada
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde la implementación de un Bean con dependencia");
    }
}
