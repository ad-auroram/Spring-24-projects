public class Task3 extends Task{
    public Task3(int ID, int start, int deadline, int duration) {
        super(ID,start,deadline,duration);
    }

    //compares duration, deadline if tied
    public int compareTo(Task t2) {
        int timeNeeded=duration-t2.duration;
        int done = deadline-t2.deadline;
        if (timeNeeded==0) return done;
        return timeNeeded;
    }
}
