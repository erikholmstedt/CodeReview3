import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;

public class Search {

    public List<String> searchMatchedLines(String pattern, String file) throws FileNotFoundException{
        
        List<String> result = new java.util.ArrayList<>();

        Scanner scan = new Scanner(new File(file));

        //Used to only add lines with the word and not lines where the word is a part of another word 
        Pattern p = Pattern.compile("\\b" + Pattern.quote(pattern) + "\\b");

        while (scan.hasNext()){
            String line = scan.nextLine();
            if (p.matcher(line).find()) {
                result.add(line);
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
