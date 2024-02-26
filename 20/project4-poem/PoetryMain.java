
public class PoetryMain {

public static void main(String[] args) throws FileNotFoundException {

    String files[] = {"Lester.txt", "green.txt", "Nose.txt", "Zebra.txt"};
    String startWords[] = {"lester", "sam", "nose", "are"};
    int poemLength[] = {20,30,30,50 };
    boolean printTable []= {true,true,false, true};
    for (int i = 0; i < 1; i++) {
        WritePoetry poem = new WritePoetry(files[i]);
        System.out.println(poem.writePoem(startWords[i], poemLength[i], printTable[i]));
    }
}

}