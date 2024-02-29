import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class WritePoetry {
    public String poem;
    public HashTable<String, WordFreqInfo> hash;

    public WritePoetry(String poem) {
        this.poem = poem;
        this.hash = new HashTable<>();
    }

    public String writePoem(String startWord, int i, boolean b) {
        readPoem();
        /*
        for (int j=0; j<i; j++){
            System.out.println(startWord);
        }
         */
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
        for (String word : words) {
            int count = 0;
            for (String w : words) {
                if (word.equals(w)) count += 1;
            }
            if (!hash.contains(word)) {
                WordFreqInfo info = new WordFreqInfo(word, count);
                hash.insert(word, info);
            }
        }
        System.out.println(hash.toString(50));
    }
}
