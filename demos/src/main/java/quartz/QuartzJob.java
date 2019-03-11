package quartz;

import org.quartz.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzJob {

    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory stdSchedulerFactory = new org.quartz.impl.StdSchedulerFactory();

        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        scheduler.start();

        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group")
                // 传入属性
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        // Trigger the job to run now, and then every 40 seconds
        SimpleTrigger trigger = newTrigger()
                .withIdentity("myTrigger", "group")
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        JobDetail testJobDetail = newJob(TestMapJob.class)
                .withIdentity("testJobDetail", "group1")
                .usingJobData("key", "11111")
                .usingJobData("value", "2")
                .build();

        // Trigger the job to run now, and then every 40 seconds
        SimpleTrigger testJobTrigger = newTrigger()
                .withIdentity("testJobDetailTrigger", "group1")
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
        scheduler.scheduleJob(testJobDetail, testJobTrigger);

        scheduler.start();
    }
}

