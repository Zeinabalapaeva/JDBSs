package java12.ServiseImple;

import java12.Servise.JobServise;
import java12.dao.JobDao;
import java12.imple.JobDaoImple;
import java12.model.Job;

import java.util.List;

public class JobSErviseImple implements JobServise {

    JobDao jobDao = new  JobDaoImple();


    @Override
    public void createJobTable() {
        jobDao.createJobTable();

    }

    @Override
    public void addJob(Job job) {
        jobDao.addJob(job);

    }

    @Override
    public Job getJobById(Long jobId) {

        return jobDao.getJobById(jobId);
    }

    @Override
    public List<Job> sortByExperience(String ascOrDesc) {

        return jobDao.sortByExperience(ascOrDesc);
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {

        return jobDao.getJobByEmployeeId(employeeId);
    }

    @Override
    public void deleteDescriptionColumn() {
        jobDao.deleteDescriptionColumn();

    }
}
