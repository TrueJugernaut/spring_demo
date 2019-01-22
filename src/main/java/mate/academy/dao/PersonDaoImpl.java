package mate.academy.dao;

import mate.academy.model.Person;
import mate.academy.model.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Repository
public class PersonDaoImpl implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    public PersonDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Person getById(Integer id) {
        String sqlFindById = "select * from persons where id = ?";

        return jdbcTemplate.queryForObject(sqlFindById, new Object[] {id}, new PersonMapper());
    }

    public Integer createUser(String firstName, String lastName, Integer age) {
        String sqlCreateUser = "insert into developers.persons (`first_name`, `last_name`, `age`) values (?, ?, ?)";

        return jdbcTemplate.update(sqlCreateUser,firstName, lastName, age);
    }
}
