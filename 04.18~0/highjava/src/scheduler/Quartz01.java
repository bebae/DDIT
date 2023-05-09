package scheduler;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz01 {
    public static void main(String[] args) throws Exception {

        // 스케줄러 팩토리 생성
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 실행할 작업(Job)과 실행 조건(Trigger) 생성
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("myJob", "group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
                .withSchedule(org.quartz.SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3)
                        .repeatForever())
                .build();

        // 스케줄러에 작업과 조건 등록
        scheduler.scheduleJob(job, trigger);

        // 스케줄러 시작
        scheduler.start();
    }

    public static class MyJob implements Job {
        @Override
        public void execute(org.quartz.JobExecutionContext context) {
            System.out.println("Quartz job started.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Quartz job finished.");
        }
    }
}