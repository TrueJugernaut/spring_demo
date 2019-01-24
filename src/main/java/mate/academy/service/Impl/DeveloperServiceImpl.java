package mate.academy.service.Impl;

import mate.academy.model.Developer;
import mate.academy.repository.DeveloperRepository;
import mate.academy.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    private DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }
    public Developer create(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer get(Long id) {
        return developerRepository.getOne(id);
    }

    public List<Developer> getDeveloperSalaryGt(Integer salary) {
        return developerRepository.findAllBySalaryGreaterThan(salary);
    }
}
