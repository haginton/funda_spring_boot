package com.fundamentosplatzi.springbootH.fundamentosH;

import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBean;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springbootH.fundamentosH.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springbootH.fundamentosH.component.ComponentDependency;
import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import com.fundamentosplatzi.springbootH.fundamentosH.pojo.UserPojo;
import com.fundamentosplatzi.springbootH.fundamentosH.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@SpringBootApplication
public class FundamentosHApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosHApplication.class);

	//Inicio inyección de dependencia con constructor
	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;

	@Autowired
	public FundamentosHApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
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
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("Usuario con el metodo findByUserEmail" + userRepository.findByUserEmail("marco@domain.com")
				.orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
		userRepository.findAndSort("user", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usuario con metodo sort " + user));

		userRepository.findByName("John")
				.stream()
				.forEach(user -> LOGGER.info("Usuario con query method " + user));

		LOGGER.info("Usuario con query method findByEmailAndName: " + userRepository.findByEmailAndName("daniela@domain.com","Daniela")
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado")));

		LOGGER.info("El usuario a partir del named parameter es: " +
				userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 9, 8), "daniela@domain.com")
				.orElseThrow(() ->
						new RuntimeException("No se encontro el usuario a partir del named parameter")));

	}

	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
		User user2 = new User("John", "marco@domain.com", LocalDate.of(2021, 12, 8));
		User user3 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
		User user4 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
		User user5 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
		User user6 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
		User user7 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
		User user8 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
		User user9 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));
		User user10 = new User("user10", "user10@domain.com", LocalDate.of(2021, 5, 03));
		User user11 = new User("user11", "user11@domain.com", LocalDate.of(2021, 6, 11));
		User user12 = new User("user12", "user12@domain.com", LocalDate.of(2021, 7, 30));
		List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
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
