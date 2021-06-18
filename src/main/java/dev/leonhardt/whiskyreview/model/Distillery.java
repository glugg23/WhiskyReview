package dev.leonhardt.whiskyreview.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Distillery that = (Distillery) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.region);
    }
}
