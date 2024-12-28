package com.smartchip.academy.repository;


import com.smartchip.academy.dao.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VideosRepository extends JpaRepository<Videos,Long> {
}
