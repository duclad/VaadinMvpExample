package net.duclad.pets.vaadinspring.service.job;

import java.util.List;

/**
 * Created by ClaudiuDumitrescu on 3/31/2017.
 */
public interface JobService {
    /**
     * Starts new job with given name
     */
    List<Job> startNewJob();

    /**
     * @return List of currently pending jobs
     */
    List<Job> getPendingJobs();

    /**
     * Removes given job from the list of executed jobs.
     *
     * @param job
     */
    void clearJob(Job job);
}
