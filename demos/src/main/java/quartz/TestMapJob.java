package quartz;

import lombok.Setter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

@Setter
public class TestMapJob implements Job {

    private String key;

    private String value;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("current key is " + this.key + " current value is " + this.value);
    }
}
