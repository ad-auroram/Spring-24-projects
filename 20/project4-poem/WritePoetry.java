import java.util.ArrayList;

public class WritePoetry {
    public String poem;

    public WritePoetry(String poem) {
        this.poem = poem;

    }

    public String writePoem(String startWord, int i, boolean b) {
        return startWord+" poem, length: "+i+" printing table?: "+b;
    }
}
