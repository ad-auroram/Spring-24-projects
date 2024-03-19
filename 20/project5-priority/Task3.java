public class Task3 extends Task{
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }

    //priority is start times, deadlines if tied
    //compares deadline, then duration if tied
    public int compareTo(Task t2) {
        //System.out.println("Using Task2 compareTo");
        int timeNeeded=duration-t2.duration;
        int done = deadline-t2.deadline;
        if (done>=0) return timeNeeded;
        return done;
    }
}
