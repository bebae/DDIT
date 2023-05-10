package scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 파일을 주기적으로 저장하는 Quartz 스케줄러를 구현하는 클래스입니다.
 */
public class Quartz02 implements Job {
    /**
     * Quartz 스케줄러에 의해 주기적으로 실행될 메서드입니다.
     */
    public void execute(JobExecutionContext context) {
        try {
            String inputFileName = "./src/scheduler/Quartz02.java";     // 입력 파일 이름
            String outputFileName = "output.txt";                       // 출력 파일 이름
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 날짜 포맷 지정
            String fileContent = "\n\n파일 저장 시간 : " + dateFormat.format(new Date()) + "\n";  // 저장할 내용

            // 출력 파일의 기존 내용을 읽어옴
            StringBuilder existingContent = new StringBuilder();
            File existingFile = new File(outputFileName);
            if (existingFile.exists()) {
                Scanner scanner = new Scanner(existingFile);
                while (scanner.hasNextLine()) {
                    existingContent.append(scanner.nextLine()).append("\n");
                }
                scanner.close();
            }

            // 새로운 내용을 기존 내용과 합침
            fileContent = existingContent + fileContent;

            // 입력 파일의 내용을 읽어옴
            File inputFile = new File(inputFileName);
            Scanner inputScanner = new Scanner(inputFile);
            StringBuilder inputContent = new StringBuilder();
            while (inputScanner.hasNextLine()) {
                inputContent.append(inputScanner.nextLine()).append("\n");
            }
            inputScanner.close();

            // 입력 파일의 내용을 출력 파일에 추가
            fileContent = fileContent + inputContent;

            // 출력 파일에 업데이트된 내용을 씀
            FileWriter fileWriter = new FileWriter(existingFile);
            fileWriter.write(fileContent);
            fileWriter.close();

            System.out.println("파일을 성공적으로 백업했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 현재 시간을 콘솔에 출력하는 Quartz 작업을 구현하는 클래스.
     */
    public static class PrintTimeJob implements Job {
        /**
         * Quartz 스케줄러에 의해 주기적으로 실행될 메서드입니다.
         */
        public void execute(JobExecutionContext context) throws JobExecutionException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초"); // 날짜 포맷 지정
            String currentTime = dateFormat.format(new Date());
            System.out.println("현재 시간 : " + currentTime);
        }
    }


    /**
     * 메인 메서드입니다. 사용자로부터 입력받은 주기에 따라 Quartz 스케줄러를 설정합니다.
     * @param args 명령행 인수
     * @throws SchedulerException 스케줄러 예외 발생 시
     */
    public static void main(String[] args) throws SchedulerException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("몇 분마다 저장하시겠습니까? : ");
        int minutes = scanner.nextInt();
        System.out.print("몇 초마다 실행하시겠습니까? : ");
        int seconds = scanner.nextInt();

        // 파일 저장 Job 생성
        JobDetail job = JobBuilder.newJob(Quartz02.class)
                .withIdentity("fileSaverJob", "group1")
                .build();

        // 파일 저장 트리거 생성
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("fileSaverTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInMinutes(minutes)
                        .repeatForever())
                .build();

        // Create a job to print current time every 5 seconds
        JobDetail printTimeJob = JobBuilder.newJob(PrintTimeJob.class)
                .withIdentity("printTimeJob", "group1")
                .build();

        // 5초마다 printTimeJob 을 실행하는 트리거 생성
        Trigger printTimeTrigger = TriggerBuilder.newTrigger()
                .withIdentity("printTimeTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(seconds)
                        .repeatForever())
                .build();


        // 스케줄러 팩토리 생성
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // Job 과 Trigger 를 스케줄러에 등록
        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(printTimeJob, printTimeTrigger);

        scanner.close();
    }
}

