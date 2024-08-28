import java.security.NoSuchAlgorithmException; // Import exception for unsupported cryptographic algorithms
import java.security.spec.InvalidKeySpecException; // Import exception for invalid key specifications
import java.security.spec.KeySpec; // Import KeySpec for specifying key generation parameters
import java.util.Base64; // Import Base64 for encoding and decoding data
import javax.crypto.SecretKeyFactory; // Import SecretKeyFactory for creating secret keys
import javax.crypto.spec.PBEKeySpec; // Import PBEKeySpec for password-based key generation specifications

/**
 * Utility class for hashing and verifying passwords using PBKDF2 with
 * HmacSHA256 algorithm.
 */
public class PasswordHashing {
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256"; // Algorithm for password hashing
    private static final int ITERATIONS = 65536; // Number of iterations for the key derivation function
    private static final int KEY_LENGTH = 256; // Length of the generated key in bits
    private static final String SALT = "0DoVej"; // Salt used for hashing the password

    /**
     * Hashes a given password using PBKDF2 with HmacSHA256.
     *
     * @param password The password to be hashed.
     * @return The hashed password encoded in Base64.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeySpecException  If the key specification is invalid.
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Create a KeySpec with the provided password, salt, iterations, and key length
        KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), ITERATIONS, KEY_LENGTH);
        // Create a SecretKeyFactory for the specified algorithm
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        // Generate the hashed password
        byte[] hash = factory.generateSecret(spec).getEncoded();
        // Encode the hash to a Base64 string and return it
        return Base64.getEncoder().encodeToString(hash);
    }

    /**
     * Verifies if the provided password matches the hashed password.
     *
     * @param password       The password to be verified.
     * @param hashedPassword The hashed password to compare against.
     * @return True if the passwords match, otherwise false.
     * @throws NoSuchAlgorithmException If the specified algorithm is not available.
     * @throws InvalidKeySpecException  If the key specification is invalid.
     */
    public static boolean verifyPassword(String password, String hashedPassword)
            throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Hash the provided password and compare it with the hashed password
        String hashToVerify = hashPassword(password);
        return hashToVerify.equals(hashedPassword);
    }
}
