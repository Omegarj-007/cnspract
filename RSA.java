public class RSA {
    public static void main(String[] args) {
        int p = 3;  
        int q = 11; 
        int n = p * q; 
        int phi = (p - 1) * (q - 1); 
        int e = 7; 
        int d = 3;
        int msg = 4; 
        int enc = (int)Math.pow(msg, e) % n;
        int dec = (int)Math.pow(enc, d) % n;
        System.out.println("Original Message: " + msg);
        System.out.println("Encrypted Message: " + enc);
        System.out.println("Decrypted Message: " + dec);
    }
}
 
