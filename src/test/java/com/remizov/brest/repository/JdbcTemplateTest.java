package com.remizov.brest.repository;

import com.remizov.brest.IntegrationTestBase;
import com.remizov.brest.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class JdbcTemplateTest extends IntegrationTestBase {

    public static final String SQL_INSERT_PERSON ="insert into person (name, password) values(?,?);";

    public static final String SQL_DELETE_AND_RETURN_PERSON ="delete from person where name = ? returning *;";


    @Autowired
    private JdbcOperations jdbcOperations;

    @Test
    void testInsert(){
        int result = jdbcOperations.update(SQL_INSERT_PERSON,"Alekhno Aleksey","1233488");
        assertEquals(1,result);
    }

    @Test
    void testDeleteAndReturn(){
        String personName = "Alekhno Aleksey";
        String password = "1233488";
        int result = jdbcOperations.update(SQL_INSERT_PERSON,personName,password);
        assertEquals(1,result);
        List<Person> personList= jdbcOperations.query(SQL_DELETE_AND_RETURN_PERSON, new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Person.builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .password(rs.getString("password"))
                        .build();
            }
        },personName);

        assertTrue(personList.size() == 1);
        assertEquals(personName,personList.get(0).getName());
        assertTrue(personList.stream().anyMatch(p -> p.getName().equals(personName)));


    }
}
