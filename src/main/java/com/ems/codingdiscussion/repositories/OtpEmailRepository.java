//package com.ems.codingdiscussion.repositories;
//
//import java.util.Optional;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.ems.codingdiscussion.entities.OtpEmail;
//
//@Repository
//public interface OtpEmailRepository extends MongoRepository<OtpEmail, Integer> {
//
//	//@Query(nativeQuery = true, value = "select * from otp_email where email = :email ORDER BY otp_requested_time desc limit 1")
//	//Optional<OtpEmail> findLatestByEmail(@Param("email") String email);
//}
