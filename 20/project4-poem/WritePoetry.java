import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WritePoetry {
    public String poem;

    public WritePoetry(String poem) {
        this.poem = poem;

    }

    public String writePoem(String startWord, int i, boolean b) {
        readPoem();
        return startWord+" poem, length: "+i+" printing table?: "+b;
    }

    private String pickNextWord(String word){
        return word;
    }

    public void readPoem(){
        ArrayList<String> words = new ArrayList<>();
        try {
            File file = new File(poem);
            Scanner reader = new Scanner(file);
            while (reader.hasNext()) {
                String word = reader.next();
                word = word.toLowerCase();
                words.add(word);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(words);
    }
}
