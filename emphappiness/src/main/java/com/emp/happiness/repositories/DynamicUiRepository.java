package com.emp.happiness.repositories;

import com.emp.happiness.entities.DynamicUiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DynamicUiRepository extends JpaRepository<DynamicUiEntity,Long> {

}
