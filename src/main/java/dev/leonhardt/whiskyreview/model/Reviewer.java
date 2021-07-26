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
@Table(name = "reviewers")
@ToString
@RequiredArgsConstructor
public class Reviewer {
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
        Reviewer reviewer = (Reviewer) o;

        return Objects.equals(id, reviewer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }
}
