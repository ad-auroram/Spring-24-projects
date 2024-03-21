import java.util.ArrayList;

public class Scheduler {

    public void makeSchedule(String title, ArrayList taskList){
        // go one unit of time at a time. subtract from duration and add back into queue.
        //add to queue only when start time is met
        System.out.println(title);
        System.out.println(taskList);
        boolean done = false;
        int time = 1;
        while (!done){
            for (int item = 0; item<taskList.size(); item++){
                Task task = (Task) taskList.get(item);
                System.out.println(task.toStringL());
            }
            done = true;
        }
    }
}
