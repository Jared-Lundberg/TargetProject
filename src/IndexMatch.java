import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class IndexMatch extends AbstractMatcher {

    HashMap<File, HashMap<String, Integer>> fileMap = new HashMap<>();

    public IndexMatch() throws FileNotFoundException {
        HashMap<String, Integer> tokenMap;
        for( File file: fileList ){
            tokenMap = new HashMap<>();
            Scanner s = new Scanner(file);
            while(s.hasNext()){
                String token = s.next();
                if( tokenMap.containsKey(token) ){
                    tokenMap.replace(token, tokenMap.get(token) + 1 );
                }else{
                    tokenMap.put(token, 1);
                }
            }
            fileMap.put(file, tokenMap);
            s.close();
        }
    }



    @Override
    public void findMatches(String searchToken) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        for( File file: fileList ){

            countMap.put(file, fileMap.get(file).getOrDefault(searchToken, 0));

        }
        timeElapsed = System.currentTimeMillis() - startTime;
    }

}
