package com.ozidi.cqrsev.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozidi.cqrsev.domains.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public Map<String, User> store = new HashMap();

}
