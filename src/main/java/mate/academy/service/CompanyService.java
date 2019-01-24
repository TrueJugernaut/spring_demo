package mate.academy.service;

import mate.academy.model.Company;
import mate.academy.model.Project;

import java.util.List;

public interface CompanyService {
    Company create(Company company);

    Company get(Long id);

    List<Company> getCompanyProject(Project project);
}
