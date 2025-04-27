import java.util.*;

public class ColumnarCipher {

    static String encrypt(String message, String key) {
        int columns = key.length();
        int rows = (int) Math.ceil((double) message.length() / columns);
        char[][] grid = new char[rows][columns];
        int index = 0;

        // Fill the grid row-wise
        for (int i = 0; i < rows && index < message.length(); i++) {
            for (int j = 0; j < columns && index < message.length(); j++) {
                grid[i][j] = message.charAt(index++);
            }
        }

        // Prepare column order based on key
        Integer[] order = new Integer[columns];
        for (int i = 0; i < columns; i++) order[i] = i;
        Arrays.sort(order, Comparator.comparingInt(i -> key.charAt(i)));

        // Read columns in key-defined order
        StringBuilder encrypted = new StringBuilder();
        for (int colIndex : order) {
            for (int i = 0; i < rows; i++) {
                if (grid[i][colIndex] != 0)
                    encrypted.append(grid[i][colIndex]);
            }
        }
        return encrypted.toString();
    }

    static String decrypt(String encrypted, String key) {
        int columns = key.length();
        int rows = (int) Math.ceil((double) encrypted.length() / columns);
        char[][] grid = new char[rows][columns];

        // Prepare column order based on key
        Integer[] order = new Integer[columns];
        for (int i = 0; i < columns; i++) order[i] = i;
        Arrays.sort(order, Comparator.comparingInt(i -> key.charAt(i)));

        int index = 0;
        for (int colIndex : order) {
            for (int i = 0; i < rows && index < encrypted.length(); i++) {
                grid[i][colIndex] = encrypted.charAt(index++);
            }
        }

        // Read the grid row-wise to get decrypted message
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0)
                    decrypted.append(grid[i][j]);
            }
        }
        return decrypted.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter message: ");
        String message = sc.nextLine().replaceAll(" ", ""); // Remove spaces

        System.out.print("Enter numeric key (e.g. 4312): ");
        String key = sc.nextLine();

        // Optional: validate key
        if (!key.matches("\\d+") || key.chars().distinct().count() != key.length()) {
            System.out.println("Invalid key. Use a non-repeating digit sequence like '4312'.");
            sc.close();
            return;
        }

        String encrypted = encrypt(message, key);
        System.out.println("Encrypted Message (Sender Side): " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Message (Receiver Side): " + decrypted);

        sc.close();
    }
}
