package com.api.rest.biblioteca.servicesimplement;
import EncryptServices.EncryptService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncryptServicesImplement implements EncryptService {

    @Override
    public String EncryptPassword(String passwordUser) {
      return BCrypt.hashpw(passwordUser, BCrypt.gensalt());
    }

    @Override
    public boolean veryfyPassword(String originalPassword, String hasshPassword) {
        boolean isAuthenticated = BCrypt.checkpw(originalPassword, hasshPassword);
if (isAuthenticated){
    return  true;
}

        return false;
    }
}
