/**
 * This class creates WordInfo objects which allows the program
 * to keep track of words, their ladder, and number of moves previous to the word.
 */
public class LadderInfo implements Comparable<LadderInfo> {
    public String lastWord;   // last word of ladder
    public int moves;         // number of moves in ladder
    public String ladder;     // series of words in current word ladder
    public Integer priority;      // number of previous moves + cost to reach solution

    public LadderInfo(String word, int moves, String ladder, int priority){
        this.lastWord = word;
        this.moves = moves;
        this.ladder = ladder;
        this.priority = priority;
    }

    public String toString2(){
       return "Word " + lastWord    + " Moves " +moves  + " Ladder ["+ ladder +"]";
    }
    public String toString(){
        return "["+ ladder +"]";
    }

    public String ladder(){
        return this.ladder;
    }

    public String getLast(){
        return lastWord;
    }

    public int compareTo(LadderInfo l2){
        return (this.priority.compareTo(l2.priority));
    }
}

