
public class PoetryMain {

public static void main(String[] args) {

    String files[] = {"green.txt"};//, "Lester.txt", "Nose.txt", "Zebra.txt"};
    String startWords[] = {"sam"};//, "lester", "nose", "are"};
    int poemLength[] = {20,30,30,50 };
    boolean printTable []= {true,true,false,true};
    for (int i = 0; i < 1; i++) {
        WritePoetry poem = new WritePoetry(files[i]);
        poem.writePoem(startWords[i], poemLength[i], printTable[i]);
    }
}

}