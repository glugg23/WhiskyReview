package dev.leonhardt.whiskyreview.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "regions")
@ToString
@RequiredArgsConstructor
public class Region {
    @Id
    @Getter
    private int id;
    @Getter
    @Setter
    private String name;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Region region = (Region) o;

        return Objects.equals(id, region.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}
