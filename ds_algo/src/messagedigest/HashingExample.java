package messagedigest;

import com.sun.javafx.scene.traversal.Algorithm;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashingExample {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String data = "Sun";
        hash(data);
        toBase64(data);

    }

    /**
     * Hashing and Encryption and Decryption are both different
     * @param data
     * @throws NoSuchAlgorithmException
     */
    public static void hash(String data) throws NoSuchAlgorithmException {

        byte b = (byte) 'Z';

        System.out.println(b);
        System.out.println(Integer.toHexString(b));

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] encodeByte = md.digest(data.getBytes());

        String message = new String(encodeByte);
        System.out.println(message);
    }

    public static void toBase64(String data) {

        byte[] byteEncodeData  = Base64.getEncoder().encode(data.getBytes());
        for (byte b : byteEncodeData){
            System.out.print(""+b+",");
        }

        System.out.println("Encoded data: " + new String(byteEncodeData));




    }
}
