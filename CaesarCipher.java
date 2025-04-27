import java.util.Scanner;
public class CaesarCipher {
    static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c); 
            }
        }
        return result.toString();
    }
    static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter message: ");
        String message = scanner.nextLine();
        System.out.print("Enter shift (key): ");
        int key = scanner.nextInt();
        String encrypted = encrypt(message, key);
        System.out.println("Encrypted (Sender Side): " + encrypted);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted (Receiver Side): " + decrypted);
        scanner.close();
    }
}

