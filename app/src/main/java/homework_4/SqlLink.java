package homework_4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SqlLink {
    public String toLink(String initDbFilename){
        String sql = null;
        try {
            sql = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(initDbFilename)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }
}
