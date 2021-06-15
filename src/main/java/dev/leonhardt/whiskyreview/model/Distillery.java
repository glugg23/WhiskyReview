package dev.leonhardt.whiskyreview.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "distilleries")
@ToString
@RequiredArgsConstructor
public class Distillery {
    @Id
    @Getter
    private int id;
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
