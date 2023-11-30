package com.ems.codingdiscussion.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ems.codingdiscussion.entities.User;


@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	Optional<User> findFirstByEmail(String email);

	@Query("{_id: ?0}")
	@Update("{'$set': {'isAdmin' : true}}")
	void makeAdmin(Long userId);
//
	@Query("{_id: ?0}")
	@Update("{'$set': {'isLocked' : ?1}}")
	void toggleUserAccess(Long userId,boolean isLocked);
}
