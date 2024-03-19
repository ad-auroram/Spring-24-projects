import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestSched {


    public static void readTasks(String filename, ArrayList<Task> task1, ArrayList<Task> task2, ArrayList<Task> task3) throws FileNotFoundException {
        // Create lists where base type is different
        File taskList = new File(filename);
        Scanner reader = new Scanner(taskList);
        int n=1;
        while (reader.hasNext()){
            String info = reader.nextLine().replaceAll("\\s", "");
            char[] taskInfo = info.toCharArray();
            int start = taskInfo[0]-'0';
            int deadline = taskInfo[1]-'0';
            int duration = taskInfo[2]-'0';

            Task1 one = new Task1(n, start, deadline, duration);
            Task2 two = new Task2(n, start, deadline, duration);
            Task3 three = new Task3(n, start, deadline, duration);

            task1.add(one);
            task2.add(two);
            task3.add(three);
            n++;
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        Scheduler s = new Scheduler();
        String [] files = {"taskset1.txt","taskset2.txt","taskset3.txt","taskset4.txt","taskset5.txt" };
        for (String f : files) {
            ArrayList<Task> t1 = new ArrayList();    // elements are Task1
            ArrayList<Task> t2 = new ArrayList();    // elements are Task2
            ArrayList<Task> t3 = new ArrayList();    // elements are Task3
            readTasks(f, t1, t2, t3);
            s.makeSchedule("Deadline Priority "+ f, t1);
            s.makeSchedule("Startime Priority " + f, t2);
            s.makeSchedule("Wild and Crazy priority " + f, t3);
       }

    }
}
