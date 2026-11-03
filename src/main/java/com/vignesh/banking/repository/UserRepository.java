package com.vignesh.banking.repository;
import com.vignesh.banking.model.User;import org.springframework.data.jpa.repository.JpaRepository;import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long>{Optional<User> findByEmail(String e);}
