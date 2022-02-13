import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Please enter a search term: ");
            String searchTerm = input.nextLine();
            System.out.println("Choose a search method: 1) String Match 2) Regular Expression 3) Indexed");
            int searchMethod = input.nextInt();

            if (searchMethod == 1) {

                StringMatch search = new StringMatch();
                search.findMatches(searchTerm);
                search.printResults();

            } else if (searchMethod == 2) {

                RegularExpressionMatch search = new RegularExpressionMatch();
                search.findMatches(searchTerm);
                search.printResults();

            } else if (searchMethod == 3) {

                IndexMatch search = new IndexMatch();
                search.findMatches(searchTerm);
                search.printResults();

            } else {

                System.out.println("Invalid Search Method chosen");

            }

            input.close();

        } catch (Exception e){
            System.out.println("Error generating results.");
        }

    }
}
