package com.backend.laundarybackend.repository;


import com.backend.laundarybackend.entity.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClothRepository extends JpaRepository<Cloth, UUID>{

}
