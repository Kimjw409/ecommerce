package com.knife.shop.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Transactional
    @Query(value = "SELECT setval(pg_get_serial_sequence('item', 'id'), COALESCE(MAX(id), 1)) FROM item", nativeQuery = true)
    void syncIdentitySequence();

}
