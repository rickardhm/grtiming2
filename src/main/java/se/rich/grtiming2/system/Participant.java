package se.rich.grtiming2.system;

import jakarta.persistence.*;

@Entity
@Table(name="Participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Long start_number;
    private String status;

    public Participant() {
    }

    public Participant(Long user_id, Long start_number, String status) {
        this.user_id = user_id;
        this.start_number = start_number;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getStart_number() {
        return start_number;
    }

    public void setStart_number(Long start_number) {
        this.start_number = start_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", start_number=" + start_number +
                ", status='" + status + '\'' +
                '}';
    }
}
