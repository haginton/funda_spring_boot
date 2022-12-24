package com.fundamentosplatzi.springbootH.fundamentosH.service;

import com.fundamentosplatzi.springbootH.fundamentosH.entity.User;
import com.fundamentosplatzi.springbootH.fundamentosH.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //metodo para guardar información
    @Transactional //anotación para controlar la transacción si hay error realiza rollback de todoas las transacciones de la sesión
    public void saveTransactional(List<User> users){
        users.stream().peek(user -> LOG.info("Usuario insertado " + user))
                .forEach(user -> userRepository.save(user));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
