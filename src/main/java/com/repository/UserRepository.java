package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{

//	Optional<UserEntity> findByFirstName(String firstName);
//	
//	List<UserEntity> findByfirstName(String firstName);
	

	List<UserEntity> findByfirstName(String firstName);
	
//	List<UserEntity> findBylastName(String lastName);
	
//	@Query(value = "select * from users1 where first_name like :firstName" , nativeQuery = true)
//	List<UserEntity> searchByFirstName(String firstName);

}
