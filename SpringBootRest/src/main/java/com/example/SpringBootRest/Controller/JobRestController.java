package com.example.SpringBootRest.Controller;


import com.example.SpringBootRest.model.JobPost;
import com.example.SpringBootRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path = "jobPosts",produces = {"application/json"})
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();

    }

    @GetMapping("jobPost/{postID}")
    public JobPost getJob(@PathVariable("postID") int postID){
        return service.getJob(postID);

    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchbyKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobpost)
    {
        service.addJob(jobpost);
        return service.getJob(jobpost.getPostID());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostID());
    }

    @DeleteMapping("jobPost/{postID}")
    public String deleteJob(@PathVariable("postID") int postID){
        service.deleteJob(postID);
        return "Deleted";

    }

    @GetMapping("Load")
    public String loadData(){
        service.load();
        return "success";

    }
}
