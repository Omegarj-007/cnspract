import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LetterFrequency {
    public static void main(String[] args) {
        int[] freq = new int[26];
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();

                for (char ch : line.toCharArray()) {
                    if (ch >= 'a' && ch <= 'z') {
                        freq[ch - 'a']++;
                    }
                }
            }
            scanner.close();
            System.out.println("Letter frequencies in file:");
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    System.out.println((char) (i + 'a') + " : " + freq[i]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure 'input.txt' exists.");
        }
    }
}
