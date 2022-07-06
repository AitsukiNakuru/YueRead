package BinInteger;
import java.math.BigInteger;
import java.security.MessageDigest;

public class MyBigInteger {
    public static void main(String[] args) {
        String str = System.currentTimeMillis()+"111111111111111111111111111111111111111111111111111111111111111111111111111";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            System.out.println("md.digest():"+md.digest());
            BigInteger bigInteger = new BigInteger(1, md.digest());
            System.out.println("bigInteger:"+bigInteger);
            String result = bigInteger.toString(16);
            System.out.println(result);
        } catch (Exception e) {

        }

    }
}
