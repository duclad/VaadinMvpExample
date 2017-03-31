package net.duclad.pets.vaadinspring.ui.job;

import net.duclad.pets.vaadinspring.service.job.Job;
import net.duclad.vaadin.mvp.view.ApplicationView;

import java.util.List;


public interface JobView extends ApplicationView<JobViewPresenter> {

    void populateJobs(List<Job> jobs);
}
