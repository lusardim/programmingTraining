package mine;


import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportLocator {

    private static final String LOCATION = "C:/Users/Lusardi/Documents/vividseats/" +
            "torpedo-services/src/main/resources/reports";


    public static void main(String... args) throws Exception {
        ReportLocator reportLocator = new ReportLocator();
        reportLocator.run();
    }

    private void run() throws Exception {
        Files.list(Paths.get(LOCATION))
                .parallel()
                .filter(Files::isRegularFile)
                .filter(this::hasCustomerOrVendor)
                .sorted()
                .forEachOrdered(x -> System.out.println(x.getFileName().toString().replace(".json", "")));
    }

    private boolean hasCustomerOrVendor(Path path){
        try {
            String file = Files.readAllLines(path).stream().collect(Collectors.joining());
            JSONArray read = JsonPath.parse(file).read("$.parameters.[?(@.name == 'customer' || @.name == 'vendor')]");

            return !read.isEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
