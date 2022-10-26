import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Field {
    private enum State {
        EMPTY, FILLED
    }
    private State[][] field;

    public static void main(String[] args) throws IOException {
        List<String> list =  Files.readAllLines(Path.of("Life", args[0]));
    }
}
