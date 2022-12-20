package demo.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
public class ScheduledTasksController {


    @Scheduled(fixedRate = 9000L)
    @GetMapping("/tasks")
    public String scheduleATask(){
        String random = new Random().toString();
        System.out.println("Task executed " + random);
        return "Schedule a task";
    }

    @Scheduled(fixedDelay = 9000L)
    @GetMapping("/delays")
    public String delayATask(){
        Date date = new Date();
        System.out.println("Task delayed " + date.toString());
        return "Delayed a task";
    }


}
