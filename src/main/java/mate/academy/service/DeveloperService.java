package mate.academy.service;

import mate.academy.model.Developer;

import java.util.List;

public interface DeveloperService {
    Developer create(Developer developer);

    Developer get(Long id);

    List<Developer> getDeveloperSalaryGt(Integer salary);
}
