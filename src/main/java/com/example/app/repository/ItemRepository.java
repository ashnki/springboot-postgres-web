package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
