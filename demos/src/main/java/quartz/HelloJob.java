package quartz;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        // 接收属性，并打印
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();

        String jobSays = jobDataMap.getString("jobSays");
        float myFloatValue = jobDataMap.getFloat("myFloatValue");

        System.err.println("Instance " + jobKey + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);

        System.out.println("Hello Job " + System.currentTimeMillis());
    }
}
