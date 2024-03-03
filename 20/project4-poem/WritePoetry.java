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

    public void writePoem(String startWord, int i, boolean b) {
        readPoem();
        /*
        for (int j=0; j<i; j++){
            System.out.println(startWord);
        }
         */
        System.out.println(startWord+" poem, length: "+i+" printing table?: "+b);
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
            WordFreqInfo info = new WordFreqInfo(word, count);
            for (int i=0; i<words.size(); i++) {
                if (word.equals(words.get(i))) {
                    count += 1;
                    if (!(i == words.size() - 1)) {
                        info.updateFollows(words.get(i + 1));
                    }
                }
            }
            info.occurCt=count;
            if (!hash.contains(word)) {
                hash.insert(word, info);
            }

        }
        System.out.println(hash.toString(50));
    }
}
