package com.smartchip.academy.repository;


import com.smartchip.academy.dao.Superadmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuperadminRepository extends JpaRepository<Superadmin,Long> {
}
