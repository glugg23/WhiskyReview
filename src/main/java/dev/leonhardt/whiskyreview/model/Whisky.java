package dev.leonhardt.whiskyreview.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "whiskies")
@ToString
@RequiredArgsConstructor
public class Whisky {
    @Id
    @Getter
    private int id;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "distillery_id")
    private Distillery distillery;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private String name;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Whisky whisky = (Whisky) o;

        return Objects.equals(id, whisky.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.distillery, this.type, this.country, this.age);
    }
}
