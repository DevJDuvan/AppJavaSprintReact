package com.example.easynotes.servicesimplement;
import EncryptServices.EncryptService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import com.example.easynotes.repository.UsersRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncryptServicesImplement implements EncryptService {
	@Autowired
	private UsersRepository personaRepository;
    @Override
    public String EncryptPassword(String passwordUser) {
      return BCrypt.hashpw(passwordUser, BCrypt.gensalt());
    }

    @Override
    public boolean veryfyPassword(String originalPassword, String hasshPassword) {
        return false;
    }
}
