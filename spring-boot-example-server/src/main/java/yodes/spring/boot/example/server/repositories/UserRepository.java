package yodes.spring.boot.example.server.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import yodes.spring.boot.example.server.entities.UserEntity;

/**
 * This is the interface for the user repository. Spring will create a
 * implementation of this at runtime for us and create methods inherited from
 * the {@link CrudRepository}
 * <p>
 * We dont have any tests that directly work with the database as it is a generated class with few possible issues,
 */
public interface UserRepository extends CrudRepository<UserEntity, String> {

	/**
	 * Returns a list of all users
	 * 
	 * @return all users
	 */
	List<UserEntity> findAll();

}
