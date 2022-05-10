package com.example.accessing_data_mysql_06;

import org.springframework.data.repository.CrudRepository;
import com.example.accessing_data_mysql_06.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
