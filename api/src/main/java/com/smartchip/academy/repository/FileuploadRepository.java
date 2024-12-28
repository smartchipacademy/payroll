package com.smartchip.academy.repository;

import com.smartchip.academy.dao.Fileupload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FileuploadRepository extends JpaRepository<Fileupload,Long> {
}
