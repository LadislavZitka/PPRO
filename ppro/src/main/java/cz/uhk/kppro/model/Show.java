package cz.uhk.kppro.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String startTime;
    private String endTime;     

    @OneToMany(mappedBy = "show")
    private List<Seat> seats;

}
