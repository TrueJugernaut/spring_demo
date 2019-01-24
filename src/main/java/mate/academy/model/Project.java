package mate.academy.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "projectId")
@Entity
@Table(name = "projects")
public class Project {

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "projects_companies",
            joinColumns = { @JoinColumn(name = "companyId") },
            inverseJoinColumns = { @JoinColumn(name = "projectId") })
    private Set<Company> companies;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "developers_projects",
            joinColumns = { @JoinColumn(name = "projectId") },
            inverseJoinColumns = { @JoinColumn(name = "developerId") })
    private Set<Developer> developers;
}
