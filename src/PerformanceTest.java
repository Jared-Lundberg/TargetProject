import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class PerformanceTest {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> words = getRandomStrings();
        StringMatch stringMatch = new StringMatch();
        long time = System.currentTimeMillis();
        for (String word : words) {
            stringMatch.findMatches(word);
        }
        System.out.println("StringMatch Time: " + (System.currentTimeMillis() - time));

        RegularExpressionMatch expressionMatch = new RegularExpressionMatch();
        time = System.currentTimeMillis();

        for (String word : words) {
            expressionMatch.findMatches(word);
        }
        System.out.println("RegularExpressionMatch Time: " + (System.currentTimeMillis() - time));

        IndexMatch indexMatch = new IndexMatch();
        time = System.currentTimeMillis();

        for (String word : words) {
            indexMatch.findMatches(word);
        }
        System.out.println("IndexMatch Time: " + (System.currentTimeMillis() - time));

    }

    private static ArrayList<String> getRandomWords() throws FileNotFoundException {
        File f = new File("WordList.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> words = new ArrayList<>();
        while (s.hasNext()) {
            words.add(s.next());
        }

        return words;

    }

    private static ArrayList<String> getRandomStrings() {
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            words.add(UUID.randomUUID().toString());
        }
        return words;
    }
}
