package EncryptServices;

public interface EncryptService {
    //encrypt password user
    String EncryptPassword (String passwordUser);
    // verify pssowrd is equal to password add
    boolean veryfyPassword(String originalPassword,String hasshPassword);
}
