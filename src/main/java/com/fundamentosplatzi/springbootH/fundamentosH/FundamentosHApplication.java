package com.fundamentosplatzi.springbootH.fundamentosH;

import com.fundamentosplatzi.springbootH.fundamentosH.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosHApplication implements CommandLineRunner {
	//Inicio inyección de dependencia con constructor
	/*private ComponentDependency componentDependency;

	@Autowired
	public FundamentosHApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency){
		this.componentDependency = componentDependency;
	}*/
	//Fin inyección de dependencia con constructor

	//Inicio inyección de dependencia por medio de atributo
	@Autowired
	@Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;
	//Fin inyección de dependencia por medio de atributo

	public static void main(String[] args) {
		SpringApplication.run(FundamentosHApplication.class, args);
	}

	//implementación de la dependencia inyectada
	@Override
	public void run(String... args) {
		componentDependency.saludar();
	}
}
