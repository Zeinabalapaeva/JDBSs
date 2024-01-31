package java12.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Job {

    private Long id;
    private String position;//("Mentor","Management","Instructor") ушундай маанилер берилсин
    private String profession;//("Java","JavaScript")
    private String description;//("Backend developer","Fronted developer")
    private int experience;//(1,2,3........) опыт работы

    public Job() {
    }

    public Job(String position, String profession, String description, int experience) {
        this.position = position;
        this.profession = profession;
        this.description = description;
        this.experience = experience;
    }

    public Job(String instructor, String it, String backend, int i, int i1) {
    }


    public void setEmployeeId(int employeeId) {
    }
}
