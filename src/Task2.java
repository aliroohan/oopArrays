import java.security.SecureRandom;

public class Task2 {
    public static void main(String[] args) {
        SecureRandom rand = new SecureRandom();
        int face[] = new int[6];
        int percentage[] = new int[6];
        for (int i = 0; i < 1000000; i++) {
            int roll = rand.nextInt(6) + 1;
            ++face[roll - 1];
        }
        for (int i = 0; i < 6; i++) {
            percentage[i] = (face[i] * 100) / 1000000;
        }
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d: %d\n", i + 1, face[i]);
        }
        System.out.println("Percentages");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d: %d%%\n", i + 1, percentage[i]);
        }
    }
}
