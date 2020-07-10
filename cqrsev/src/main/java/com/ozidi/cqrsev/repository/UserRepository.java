package com.ozidi.cqrsev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ozidi.cqrsev.domains.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
