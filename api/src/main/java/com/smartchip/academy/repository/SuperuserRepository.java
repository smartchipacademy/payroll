package com.smartchip.academy.repository;


import com.smartchip.academy.dao.Superuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuperuserRepository extends JpaRepository<Superuser,Long> {
}
