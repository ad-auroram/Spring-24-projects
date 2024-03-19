public class Task2 extends Task{
    public Task2(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }

    //priority is start times, deadlines if tied
    public int compareTo(Task t2) {
        //System.out.println("Using Task2 compareTo");
        int startTime = start-t2.start;
        if (startTime==0) return deadline-t2.deadline;
        return start-t2.start;
    }
}
