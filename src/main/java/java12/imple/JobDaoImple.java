package java12.imple;

import java12.dao.JobDao;
import java12.konfig.jdbsConfig;
import java12.model.Job;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDaoImple  implements JobDao {

    private  final Connection connection = jdbsConfig.getConnection();
    @Override
    public void createJobTable() {

        String query = """
create table if not exists jobs (
                id serial primary key,
                 position varchar,
                 profession varchar,
                 description varchar,
                experience int );
""";
        int execute = 0;
        try{
            Statement statement = connection.createStatement();
            execute= statement.executeUpdate(query);
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println(execute !=0 ? "Error": "Crgekjgk ");
    }

    @Override
    public void addJob(Job job) {
        String query = """
            INSERT INTO job (id, position, profession, description, experience)
            VALUES (?, ?, ?, ?, ?)
            """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, job.getId());
            preparedStatement.setString(2, job.getPosition());
            preparedStatement.setString(3, job.getProfession());
            preparedStatement.setString(4, job.getDescription());
            preparedStatement.setInt(5, job.getExperience());

            preparedStatement.executeUpdate();
            System.out.println("Должность успешно добавлена");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Job getJobById(Long jobId) {
        String query = "SELECT * FROM job WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, jobId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Job job = new Job();
                job.setId(resultSet.getLong("id"));
                job.setPosition(resultSet.getString("position"));
                job.setProfession(resultSet.getString("profession"));
                job.setDescription(resultSet.getString("description"));
                job.setExperience(resultSet.getInt("experience"));
                return job;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Job> sortByExperience(String ascOrDesc) {
        List<Job> jobs = new ArrayList<>();
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            try {
                String queryAsc = "select * from jobs order by experience";
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryAsc)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Job job = new Job();
                        job.setId(resultSet.getLong("job_id"));
                        job.setPosition(resultSet.getString("position_job"));
                        job.setProfession(resultSet.getString("profession_job"));
                        job.setDescription(resultSet.getString("description_job"));
                        job.setExperience(resultSet.getInt("experience"));
                        job.setEmployeeId(resultSet.getInt("employee_id"));
                        jobs.add(job);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            try {
                String queryDesc = "select * from jobs order by experience desc";
                try (PreparedStatement preparedStatement = connection.prepareStatement(queryDesc)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        Job job = new Job();
                        job.setId(resultSet.getLong("job_id"));
                        job.setPosition(resultSet.getString("position_job"));
                        job.setProfession(resultSet.getString("profession_job"));
                        job.setDescription(resultSet.getString("description_job"));
                        job.setExperience(resultSet.getInt("experience"));
                        job.setEmployeeId(resultSet.getInt("employee_id"));
                        jobs.add(job);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else System.out.println("incorrect choice");
        return jobs;
    }

    @Override
    public Job getJobByEmployeeId(Long employeeId) {
        try {
            String query = "select * from jobs where job_id = ?";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){

                preparedStatement.setLong(1,employeeId );
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    Job job = new Job();
                    job.setId(resultSet.getLong("job_id"));
                    job.setPosition(resultSet.getString("position_job"));
                    job.setProfession(resultSet.getString("profession_job"));
                    job.setDescription(resultSet.getString("description_job"));
                    job.setExperience(resultSet.getInt("experience"));
                    job.setEmployeeId(resultSet.getInt("employee_id"));
                    return job;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteDescriptionColumn() {
        try {
            String query = "alter table jobs drop column description_job";
            try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
                int i = preparedStatement.executeUpdate();
                if (i > 0) System.out.println("success dropped column");
                else System.out.println("error");
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
