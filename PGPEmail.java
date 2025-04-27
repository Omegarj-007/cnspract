import java.security.*;
import javax.crypto.Cipher;
import java.util.Base64;

public class PGPEmail {
    public static void main(String[] args) throws Exception {
        // Generate RSA key pair (simulates PGP keys)
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        String emailMessage = "Hello, this is a secure email!";
        // Encrypt the message using public key (simulating sending)
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedBytes = encryptCipher.doFinal(emailMessage.getBytes());
        String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Email:\n" + encryptedMessage);
        // Decrypt the message using private key (simulating receiving)
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encryptedMessage));
        String decryptedMessage = new String(decryptedBytes);
        System.out.println("\nDecrypted Email:\n" + decryptedMessage);
    }
}

