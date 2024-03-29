import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WritePoetry {
    public String poem;
    public HashTable<String, WordFreqInfo> hash;

    public WritePoetry(String poem) {
        this.poem = poem;
        this.hash = new HashTable<>();
    }

    public void writePoem(String startWord, int i, boolean b) {
        ArrayList <String> punctuation = new ArrayList<>(Arrays.asList(".",",","?","!"));
        readPoem();
        System.out.print(startWord+ " ");
        String currWord = startWord;
        int count = 1;
        while (true){
            String nextWord = pickNextWord(currWord);
            if (punctuation.contains(nextWord)){
                System.out.println(nextWord);
            }else{
                System.out.print(nextWord+ " ");
            }
            currWord=nextWord;
            count+=1;
            if (punctuation.contains(currWord) && count > i){
                break;
            }
        }

        System.out.println();
        if (b) System.out.println(hash.toString(100));
    }

    private String pickNextWord(String word) {
        ArrayList<Object> entry = hash.find(word);
        WordFreqInfo info = (WordFreqInfo) entry.get(1);
        int count = info.occurCt;

        Random rand = new Random();
        int randInt = rand.nextInt(count + 1);

        int pick = 0;
        ArrayList<WordFreqInfo.Freq> freq = info.followList;

        String nextWord = word;
        for (int i = 0; i < freq.size(); i++) {
            int add = freq.get(i).followCt;
            pick += add;
            if (pick >= randInt) {
                nextWord = freq.get(i).follow;
                break;
            }
        }
        return nextWord;
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
    }
}
