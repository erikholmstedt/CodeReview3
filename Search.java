import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Search {

    public List<String> searchMatchedLines(String pattern, String file) throws FileNotFoundException{
        
        List<String> result = new java.util.ArrayList<>();

        // Use try-with-resources so the Scanner is closed automatically.
        Pattern p = Pattern.compile("\\b" + Pattern.quote(pattern) + "\\b");

        // Read with UTF-8 explicitly and use hasNextLine()/nextLine() to avoid token issues.
        try (Scanner s = new Scanner(new File(file), StandardCharsets.UTF_8.name())) {
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (p.matcher(line).find()) {
                    result.add(line);
                }
            }
        }

        return result;
    }
    public static void main(String[] args){
        String pattern = args[0];
        String file = args[1];

        Search search = new Search();

        try {
            search.searchMatchedLines(pattern, file)
                .forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file);
            System.exit(2);
        }
    }
}
