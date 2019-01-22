package mate.academy.dao;

import mate.academy.model.Person;

public interface PersonDao {
    Person getById(Integer id);
    Integer createUser(String firstName, String lastName, Integer age);
}
