import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\project password\\mini projects\\task.txt";
        List<String> lines = Files.readAllLines(Path.of(filePath));
            System.out.println(lines);
        

    }
}
