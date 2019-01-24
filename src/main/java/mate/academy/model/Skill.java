package mate.academy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "skillId")
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skillId;

    private String name;
    private String skill;
    private Level level;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "developers")
    private Set<Developer> developer;

    private enum Level {
        JUNIOR,
        STRONG_JUNIOR,
        MIDDLE,
        STRONG_MIDDLE,
        SENIOR,
        ARCHITECTOR
    }

}
