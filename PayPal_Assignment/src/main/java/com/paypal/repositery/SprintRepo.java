package com.paypal.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paypal.entity.Sprint;

public interface SprintRepo extends JpaRepository<Sprint, Integer> {

}
