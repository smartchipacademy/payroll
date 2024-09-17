package com.example.Super.Admin.Repository;

import com.example.Super.Admin.dao.Superuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SuperuserRepository extends JpaRepository<Superuser,Long> {
}
