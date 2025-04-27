import java.security.*;
public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        // Generate RSA Key Pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
        // Message to sign
        String message = "Hello, this is a message!";
        // Sign the message (hash + encrypt hash with private key)
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());
        byte[] signature = sign.sign();
        System.out.println("Signature created!");
        // Verify the signature using public key
        Signature verifySign = Signature.getInstance("SHA256withRSA");
        verifySign.initVerify(publicKey);
        verifySign.update(message.getBytes());
        boolean isCorrect = verifySign.verify(signature);
        System.out.println("Signature valid? " + isCorrect);
    }
}

