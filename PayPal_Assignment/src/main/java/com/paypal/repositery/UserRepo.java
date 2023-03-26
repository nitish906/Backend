package com.paypal.repositery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.entity.Task;
import com.paypal.entity.User;



@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

}
