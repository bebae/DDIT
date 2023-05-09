package scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Quartz02 implements Job {
    public void execute(JobExecutionContext context) {
        try {
            String fileName = "output.txt";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fileContent = "File saved at " + dateFormat.format(new Date());

            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(fileContent + "\n");
            fileWriter.close();

            System.out.println("File saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SchedulerException {
        JobDetail job = JobBuilder.newJob(Quartz02.class)
                .withIdentity("fileSaverJob", "group1")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("fileSaverTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(5)
                        .repeatForever())
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }
}

