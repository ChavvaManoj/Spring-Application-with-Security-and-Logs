package com.example.SpringBootRest.repo;

import com.example.SpringBootRest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository <JobPost, Integer>{

//    List<JobPost> findByPostProfileContainingOrpostDescContaining(String postProfile, String postDesc);
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String keyword1, String keyword2);


}
//    public List<JobPost> getAllJobs() {
//        return jobs;
//    }
//
//    public void addJob(JobPost job) {
//        jobs.add(job);
//        System.out.println(jobs);
//    }
//
//    public JobPost getJob(int postID) {
//        for (JobPost job : jobs) {
//            if (job.getPostID() == postID) {
//                return job;
//            }
//        }
//
//        return null;
//    }
//
//    public void updateJob(JobPost jobPost) {
//        for (JobPost jobPost1 : jobs) {
//            if (jobPost1.getPostID() == jobPost.getPostID()) {
//                jobPost1.setPostProfile(jobPost.getPostProfile());
//                jobPost1.setPostDesc(jobPost.getPostDesc());
//                jobPost1.setReqExperience(jobPost.getReqExperience());
//                jobPost1.setPostTechStack(jobPost.getPostTechStack());
//            }
//        }
//    }
//
//    public void deleteJob(int postID) {
//        for (JobPost jobPost1 : jobs) {
//            if (jobPost1.getPostID() == postID) {
//                jobs.remove(jobPost1);
//            }
//        }
//    }