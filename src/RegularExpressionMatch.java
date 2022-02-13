import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatch extends AbstractMatcher {
    @Override
    public void findMatches(String searchToken) throws FileNotFoundException {
        int matches = 0;
        long startTime = System.currentTimeMillis();
        Pattern pattern = Pattern.compile(searchToken);
        for (File file : fileList) {
            ArrayList<String> tokens = getTokens(file);
            for (String token : tokens) {
                Matcher matcher = pattern.matcher(token);
                if (matcher.find()) {
                    matches++;
                }
            }
            countMap.put(file, matches);
            matches = 0;
        }
        timeElapsed = System.currentTimeMillis() - startTime;
    }
}
