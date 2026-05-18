package com.cream.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cream.shop.entity.Fixture;

@Repository
public interface FixtureRepository extends JpaRepository<Fixture, Long> {
}