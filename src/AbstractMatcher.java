import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class AbstractMatcher {

    protected File[] fileList = new File("sample_text").listFiles();

    protected HashMap<File, Integer> countMap = new HashMap<>();

    protected long timeElapsed;

    public abstract void findMatches(String searchToken) throws FileNotFoundException;

    protected ArrayList<String> getTokens(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        ArrayList<String> tokenList = new ArrayList<>();
        while (s.hasNext()) {
            tokenList.add(s.next());
        }

        s.close();

        return tokenList;
    }

    public void printResults() {
        System.out.println("Results: ");
        sortCountMap();
        for (Map.Entry<File, Integer> set : countMap.entrySet()) {
            System.out.println(set.getKey().getName() + " - " + set.getValue() + " matches");
        }

        System.out.println("Elapsed Time: " + timeElapsed);
    }

    private void sortCountMap() {
        List<Map.Entry<File, Integer>> list
                = new LinkedList<>(
                countMap.entrySet());

        Collections.sort(
                list,
                (i1,
                 i2) -> i2.getValue().compareTo(i1.getValue()));

        HashMap<File, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<File, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        countMap = temp;
    }
}
