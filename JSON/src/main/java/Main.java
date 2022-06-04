import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Student student = mapper.readValue(
                    new File("JSON/src/main/resources/sample-full.json"),
                    Student.class);

            System.out.println("\n" + student);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
