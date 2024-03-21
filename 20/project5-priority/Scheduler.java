import java.util.ArrayList;

public class Scheduler {

    public void makeSchedule(String title, ArrayList taskList){
        // go one unit of time at a time. subtract from duration and add back into queue.
        //add to queue only when start time is met
        System.out.println(title);
        Queue<Task> scheduler = new Queue<>();
        boolean done = false;
        int time = 1;
        int late = 0;
        int lateMins = 0;
        while (!done){
            //find every task that starts now
            for (int item = 0; item<taskList.size(); item++){
                Task task = (Task) taskList.get(item);
                if (task.start==time){
                    scheduler.insert(task);
                }
            }
            //find the highest priority task
            Task currTask = scheduler.delete();
            currTask.duration-=1;
            System.out.printf("Time %d: %s", time, currTask);
            if (currTask.duration ==0){
                if(time>currTask.deadline){
                    late +=1;
                    lateMins+= time-currTask.deadline;
                    System.out.printf("** Late: %d \n", time-currTask.deadline);
                }else{
                    System.out.println("**");
                }
            }else{
                System.out.println();
                scheduler.insert(currTask);
            }
            //check if we're done scheduling
            if (scheduler.isEmpty()) {
                System.out.printf("Tasks late: %d.  Total minutes late: %d", late, lateMins);
                System.out.println();
                done = true;
            }
            time+=1;
        }
    }
}
