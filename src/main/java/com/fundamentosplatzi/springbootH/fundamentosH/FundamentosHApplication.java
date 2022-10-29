package com.fundamentosplatzi.springbootH.fundamentosH;

import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBean;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springbootH.fundamentosH.component.ComponentDependency;
import com.fundamentosplatzi.springbootH.fundamentosH.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosHApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosHApplication.class);

	//Inicio inyección de dependencia con constructor
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;

	@Autowired
	public FundamentosHApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
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
	public void run(String... args) { //codigo que se ejecutara al iniciar la aplicación
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " - " + userPojo.getPassword());
		try{
			//error
			int value = 10/0;
			LOGGER.debug("Mi valor: " + value);
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir por cero " + e.getMessage());
		}
	}
}
