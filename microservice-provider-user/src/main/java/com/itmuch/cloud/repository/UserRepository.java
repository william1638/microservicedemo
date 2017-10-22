package com.itmuch.cloud.repository;


import com.itmuch.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by William on 2017/10/22.
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
