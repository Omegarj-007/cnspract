import java.math.BigInteger;
public class DiffieHellmanMITM {
    public static void main(String[] args) {
        BigInteger p = new BigInteger("23"); 
        BigInteger g = new BigInteger("5"); 
        BigInteger a = new BigInteger("6");  
        BigInteger b = new BigInteger("15"); 
        BigInteger m1 = new BigInteger("13");
        BigInteger m2 = new BigInteger("7"); 
        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);
        BigInteger M1 = g.modPow(m1, p); 
        BigInteger M2 = g.modPow(m2, p);
        System.out.println("Alice sends A = " + A + " → Intercepted!");
        System.out.println("Bob sends B = " + B + " → Intercepted!");
        System.out.println("Mallory sends M1 to Bob: " + M1);
        System.out.println("Mallory sends M2 to Alice: " + M2);
        BigInteger keyAlice = M2.modPow(a, p); 
        BigInteger keyBob = M1.modPow(b, p); 
        BigInteger keyMalloryWithAlice = A.modPow(m2, p); 
        BigInteger keyMalloryWithBob = B.modPow(m1, p); 
        System.out.println("\nAlice's key: " + keyAlice);
        System.out.println("Bob's key: " + keyBob);
        System.out.println("Mallory Alice key: " + keyMalloryWithAlice);
        System.out.println("Mallory Bob key: " + keyMalloryWithBob);

        if (!keyAlice.equals(keyBob)) {
            System.out.println("\nPossible MITM attack detected! Shared keys mismatch.");
        } else {
            System.out.println("\n No MITM detected. Shared keys match.");
        }
    }
}
