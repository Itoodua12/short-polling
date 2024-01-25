package itoodua12.shortpolling.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PollController {

    private final Map<String, Integer> jobs = new HashMap<>();

    @PostMapping("/submit")
    public String submitJob() {
        String jobId = "job:" + System.currentTimeMillis();
        jobs.put(jobId, 0);
        updateJob(jobId, 0);
        return "\n\n" + jobId + "\n\n";
    }

    @GetMapping("/checkstatus/{jobId}")
    public String checkJobStatus(@PathVariable String jobId) {
        System.out.println(jobs.get(jobId));
        return "\n\nJobStatus: " + jobs.getOrDefault(jobId, 0) + "%\n\n";
    }

    private void updateJob(String jobId, int prg) {
        jobs.put(jobId, prg);
        System.out.println("Updated " + jobId + " to " + prg);
        if (prg == 100) return;
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                updateJob(jobId, prg + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
