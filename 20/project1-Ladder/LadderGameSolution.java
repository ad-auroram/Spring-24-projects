import java.util.Scanner;
        import java.util.Random;
        import java.io.File;
        import java.util.ArrayList;

/**
 * This class holds all of the functions needed for the ladder game to run successfully.
 */
public class LadderGameSolution {
    static int MaxWordSize = 15;
    ArrayList<String>[] wordLists;  // Array of ArrayLists of words of each length.
    Random random;

    /**
     * This function reads the dictionary and makes an array list of arraylists for words of each length.
     */

    /**
     * Divide the dictionary into wordLists of different length words
     * @param filename Name of file containing dictionary of legal words
     */
    public LadderGameSolution(String filename) {
        random = new Random();
        wordLists = new ArrayList[MaxWordSize];
        for (int i = 0; i < MaxWordSize; i++) {
            wordLists[i] = new ArrayList<>();
        }
        File file = new File(filename);
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String word = reader.next();
                if (word.length() < MaxWordSize) {
                    wordLists[word.length()].add(word);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * make sure a and b are legal words before calling FindLadder
     * @param a starting word of word ladder
     * @param b endsing word of word ladder
     */
    public void play(String a, String b) {
        if (a.length() >= MaxWordSize) {
            return;
        }



        // Verify that provided words are valid
        if (a.length() != b.length()) {
            System.out.println("No solution: Given words are not the same length");
            System.out.println();
            return;
        } else if (!list.contains(a) || !list.contains(b)) {
            System.out.println("No solution: " + a + " or " + b + " are not words in the dictionary");
            System.out.println();
            return;
        }

        // Solve the word ladder problem
        findLadder(a, b);
        System.out.println();
    }


    /**
     * Display the word ladder from a to b
     * Copy the wordList of the appropriate length so that you can delete a word when its
     * used.
     * @param a starting word
     * @param b ending word
     */
    public void findLadder(String a, String b) {
        ArrayList<String> l = wordLists[a.length()];
        ArrayList list = (ArrayList) l.clone();
        System.out.println("Seeking a solution from " + a + " -> " + b + " Size of List " + list.size());
    }

    /**
     * Generate two random words of length len for a word ladder problem.
     * @param len Length of the source and target words
     */

    public void play(int len) {
        if (len >= MaxWordSize) {
            return;
        }
        ArrayList<String> list = wordLists[len];
        String a = list.get(random.nextInt(list.size()));
        String b = list.get(random.nextInt(list.size()));
        play(a, b);
    }

    /**
     *
     * Notice that the main program just sets up the problem.  All the code to solve the problem is outside of main.
     */
    public static void main(String[] args) {
        String[] source = {"irk", "hit", "toes", "oops", "toes",  "ride", "happily", "slow", "stone", "biff", "unabated", "basket"};
        String[] dest = {"yuk", "hog", "tied", "tots", "tied", "ands", "angrily", "fast", "money", "axal", "notified", "doughy"};

        // This organization allows the dictionary to be read in only once.
        LadderGameSolution g = new LadderGameSolution("dictionary.txt");
        for (int i = 0; i < source.length; i++) {
            g.play(source[i], dest[i]);
        }

        int RANDOMCT = 8;
        for (int i = 4; i <= RANDOMCT; i++)
            g.play(i);

    }
}
