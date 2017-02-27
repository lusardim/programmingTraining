package mine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Base64StringConverter {

    private static final String FILE = "C:/Users/Lusardi/Desktop/test.gif";

    public static void main(String... args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(FILE));
        String value = Base64.getEncoder().encodeToString(bytes);
        System.out.println(value);
    }
}
