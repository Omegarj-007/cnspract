import java.math.BigInteger;
import java.security.SecureRandom;
public class DiffieHellman {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("23"); 
        BigInteger g = new BigInteger("5");  
        SecureRandom rand = new SecureRandom();
        BigInteger a = new BigInteger("6");  
        BigInteger b = new BigInteger("15"); 
        BigInteger A = g.modPow(a, p); 
        BigInteger B = g.modPow(b, p);
        BigInteger sharedKeyA = B.modPow(a, p);
        BigInteger sharedKeyB = A.modPow(b, p); 

        System.out.println();
        System.out.println("Alice's Public Key (A): " + A);
        System.out.println("Bob's Public Key (B): " + B);
        System.out.println("Shared Key computed by Alice: " + sharedKeyA);
        System.out.println("Shared Key computed by Bob: " + sharedKeyB);
    }
}
