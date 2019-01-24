package mate.academy.repository;

import mate.academy.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAll();
    List<Company> findAllByProject();
}

