package mate.academy.dao;

import mate.academy.model.Developer;

public interface DeveloperDao {
    Developer createDev(String name, Integer age, Double salary);


}
