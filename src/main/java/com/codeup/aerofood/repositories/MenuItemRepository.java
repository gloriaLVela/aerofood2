package com.codeup.aerofood.repositories;

import com.codeup.aerofood.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {
}
