package com.lolitaflamme.coffeefindermysql.repository;

import com.lolitaflamme.coffeefindermysql.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
