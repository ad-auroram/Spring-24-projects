import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestSched {


    public static void readTasks(String filename,
                          ArrayList<Task> task1, ArrayList<Task> task2,
                                 ArrayList<Task> task3) {
        // Create lists where base type is different

    }

    public static void main(String args[]) {
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
