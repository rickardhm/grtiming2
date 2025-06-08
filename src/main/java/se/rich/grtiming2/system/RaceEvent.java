package se.rich.grtiming2.system;

import jakarta.persistence.*;

@Entity
@Table(name = "race_event")
public class RaceEvent {
    public RaceEvent() {
    }

    public RaceEvent(String name, String description, String fee, String raceDate, String eventLocation) {
        this.name = name;
        this.description = description;
        this.fee = fee;
        this.raceDate = raceDate;
        this.eventLocation = eventLocation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String fee;
    @Column(name = "event_date")
    private String raceDate;

    @Column(name = "event_location")
    private String eventLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    @Override
    public String toString() {
        return "RaceEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", fee='" + fee + '\'' +
                ", raceDate='" + raceDate + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                '}';
    }
}
