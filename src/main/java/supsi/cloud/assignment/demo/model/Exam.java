package supsi.cloud.assignment.demo.model;

import javax.persistence.*;

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String subject;

    @Column
    private int attendants;

    public Exam() {
    }

    public Exam(String subject, int attendants) {
        this.subject = subject;
        this.attendants = attendants;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAttendants() {
        return attendants;
    }

    public void setAttendants(int attendants) {
        this.attendants = attendants;
    }
}
