import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class PasswordHashing {
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private static final String SALT = "0DoVej";
    
    public static String hashPassword(String password) throws NoSuchAlgorithmException,InvalidKeySpecException{
         KeySpec spec = new PBEKeySpec(password.toCharArray(),SALT.getBytes(),ITERATIONS,KEY_LENGTH);
         SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
         byte[] hash = factory.generateSecret(spec).getEncoded();
         return Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyPassword(String password,String hasedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        String hashToVerify = hashPassword(password);
        return hashToVerify.equals(hasedPassword);
    } 
}
