package com.fundamentosplatzi.springbootH.fundamentosH;

import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBean;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springbootH.fundamentosH.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosHApplication implements CommandLineRunner {
	//Inicio inyección de dependencia con constructor
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;

	@Autowired
	public FundamentosHApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
	}
	//Fin inyección de dependencia con constructor

	//Inicio inyección de dependencia por medio de atributo
	/*@Autowired
	@Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;*/
	//Fin inyección de dependencia por medio de atributo

	public static void main(String[] args) {
		SpringApplication.run(FundamentosHApplication.class, args);
	}

	//implementación de la dependencia inyectada (llamar la funcion de la dependencia)
	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
	}
}
