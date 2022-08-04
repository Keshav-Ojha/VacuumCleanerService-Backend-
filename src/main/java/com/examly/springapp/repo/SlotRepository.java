package com.examly.springapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.entity.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
}
