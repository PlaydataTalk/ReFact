package pdt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pdt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
