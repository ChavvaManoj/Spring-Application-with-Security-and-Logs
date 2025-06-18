package com.example.SpringBootRest.service;

import com.example.SpringBootRest.model.JobPost;
import com.example.SpringBootRest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JobService {



    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost){
        repo.save(jobPost);

    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postID) {
        return (repo.findById(postID).orElse(new JobPost()));
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postID) {
        repo.deleteById(postID);
    }


    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "Java Developer", "Nice Background", 3, Collections.singletonList("python")),
                new JobPost(2, "Python Developer", "Nice Background", 3, Collections.singletonList("python")),
                new JobPost(3, ".Net Developer", "Nice Background", 3, Collections.singletonList("python")),
                new JobPost(4, "Coding Developer", "Nice Background", 3, Collections.singletonList("python"))

        ));
        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);

    }
}

