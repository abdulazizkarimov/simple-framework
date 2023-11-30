package util;

import model.Email;
import java.util.Random;

public class RandomUtil {
    private static Random rand = new Random();

    public static String getValidPassword() {
        String token = "A2aя";
        return getRandomString(10) + token;
    }

    public static String getInvalidPassword() {
        return getRandomString(5);
    }

    public static Email getValidEmail(){
        String username;

        do {
            username = getRandomString(15).toLowerCase();
        } while (!username.contains("a"));

        String domain = getRandomString(4).toLowerCase();
        int tld = rand.nextInt(11) + 1;

        return new Email(username, domain, tld);
    }

    private static String getRandomString(int n) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int) (str.length() * Math.random());
            sb.append(str.charAt(index));
        }

        return sb.toString();
    }
}
