package com.smart.expense.tracker.repository;

import com.smart.expense.tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



    public Optional<User> findByEmail(String email);

  public Optional<User> findByUserName(String userName);

  boolean existsByUserName(String name);

}
