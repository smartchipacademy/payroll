package com.example.Super.Admin.Repository;

import com.example.Super.Admin.dao.Superadmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuperadminRepository extends JpaRepository<Superadmin,Long> {
}
