import java.util.*;
import java.io.File;

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
        ArrayList<String> l = wordLists[a.length()];
        ArrayList list = (ArrayList) l.clone();


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
        findLadderForce(a, b, list);
        System.out.println();
        findLadderA(a, b, l);
        System.out.println();
    }


    /**
     * Display the word ladder from a to b
     * Copy the wordList of the appropriate length so that you can delete a word when its
     * used.
     * @param a starting word
     * @param b ending word
     */
    public void findLadderForce(String a, String b, ArrayList list) {

        System.out.println("Seeking a solution from " + a + " -> " + b + " Size of List " + list.size());
        list.remove(a);
        int totalEnqueue = 0;
        LadderInfo start = new LadderInfo(a, 0, a, 0);
        Queue partialSolutions = new Queue();
        partialSolutions.enqueueItem(start);
        totalEnqueue ++;
        Character[] alphabet = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        boolean done = false;

        try {
            while (!done) {
                LadderInfo currLadder = (LadderInfo) partialSolutions.dequeueItem().data;
                String currentStep = currLadder.lastWord;
                char[] myChars = currentStep.toCharArray();
                char[] myCharsOg = myChars.clone();
                for (int i = 0; i < myChars.length; i++) {
                    if (i > 0) {
                        myChars[i - 1] = myCharsOg[i - 1];
                    }
                    for (char letter : alphabet) {
                        myChars[i] = letter;
                        String next = String.valueOf(myChars);
                        if (list.contains(next)) {
                            list.remove(next);
                            String[] split = currLadder.ladder().split(" ");
                            LadderInfo step = new LadderInfo(next, split.length, currLadder.ladder() + " " + next, 0);
                            if (next.equals(b)) {
                                String result = step.toString();
                                System.out.println("Solution found!");
                                System.out.printf("Moves: %d   Ladder: %s  Total enqueues: %d \n", step.moves, result, totalEnqueue);
                                done = true;
                            }
                            totalEnqueue++;
                            partialSolutions.enqueueItem(step);
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Solution not found.");
        }
    }

    public void findLadderA(String a, String b, ArrayList list){
        Dictionary<String, Integer> position= new Hashtable<>();
        System.out.println("Seeking an A* solution from " + a + " -> " + b + " Size of List " + list.size());
        int totalEnqueue = 0;
        LadderInfo start = new LadderInfo(a, 0, a, 1+a.toCharArray().length);
        AVLTree<LadderInfo> solutionTree = new AVLTree<>();
        solutionTree.insert(start);
        totalEnqueue ++;
        Character[] alphabet = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        boolean done = false;
        try {
            while (!done) {
                LadderInfo currLadder = solutionTree.findMin();
                solutionTree.deleteMin();
                String currentStep = currLadder.lastWord;
                char[] myChars = currentStep.toCharArray();
                char[] myCharsOg = myChars.clone();
                for (int i = 0; i < myChars.length; i++) {
                    if (i > 0) {
                        myChars[i - 1] = myCharsOg[i - 1];
                    }
                    for (char letter : alphabet) {
                        myChars[i] = letter;
                        String next = String.valueOf(myChars);
                        if (list.contains(next)) {
                            int cost = 0;
                            char[] goal = b.toCharArray();
                            for (int step=0; step<myChars.length; step++){
                                if (myChars[step] != goal[step]){
                                        cost++;
                                }
                            }
                            String[] split = currLadder.ladder().split(" ");
                            int priority = split.length+cost ;
                            LadderInfo step = new LadderInfo(next, split.length, currLadder.ladder() + " " + next, priority);
                            if (position.isEmpty() || position.get(next)==null || position.get(next) < split.length+1){
                                position.put(next, split.length + 1);
                                totalEnqueue++;
                                solutionTree.insert(step);
                            }
                            if (next.equals(b)) {
                                String result = step.toString();
                                System.out.println("Solution found!");
                                System.out.printf("Moves: %d   Ladder: %s  Total enqueues: %d \n", step.moves, result, totalEnqueue);
                                done = true;
                            }

                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("Solution not found.");
        }
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
        String[] source = {"kiss", "cock", "jura", "stet", "rums",  "ride"};
        String[] dest = {"woof", "numb", "such", "whey", "numb", "ands"};

        // This organization allows the dictionary to be read in only once.
        LadderGameSolution g = new LadderGameSolution("dictionary.txt");
        for (int i = 0; i < source.length; i++) {
            g.play(source[i], dest[i]);
        }
/*
        int RANDOMCT = 8;
        for (int i = 4; i <= RANDOMCT; i++)
            g.play(i);
*/
    }

}
