import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StringMatch extends AbstractMatcher {

    @Override
    public void findMatches(String searchToken) throws FileNotFoundException {
        int matches = 0;
        long startTime = System.currentTimeMillis();
        for( File file: fileList ){
            ArrayList<String> tokens = getTokens(file);
            for(String token: tokens){
                if( searchToken.equals(token)){
                    matches++;
                }
            }
            countMap.put(file, matches);
            matches = 0;
        }
        timeElapsed = System.currentTimeMillis() - startTime;

    }
}
