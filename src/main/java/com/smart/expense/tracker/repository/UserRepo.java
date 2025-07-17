package com.smart.expense.tracker.repository;

import com.smart.expense.tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {



  Optional<User> findByEmail(String email);

  Optional<User> findByUserName(String name);

  @Query(value = "SELECT COUNT(*) > 0 FROM public.exp_users where email_Id= :email", nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);

}
