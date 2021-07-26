package dev.leonhardt.whiskyreview.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reviews")
@ToString
@RequiredArgsConstructor
public class Review {
    @Id
    @Getter
    private int id;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "whisky_id")
    private Whisky whisky;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "reviewer_id")
    private Reviewer reviewer;
    @Getter
    @Setter
    @OneToOne
    @JoinColumn(name = "tasting_type_id")
    private TastingType tastingType;
    @Getter
    @Setter
    private int score;
    @Getter
    @Setter
    private String comment;
    @Getter
    @Setter
    private Date date;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Review review = (Review) o;

        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.whisky, this.reviewer, this.tastingType, this.score, this.comment, this.date);
    }
}
