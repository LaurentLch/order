package com.switchfully.order.domain.repositories;

import com.switchfully.order.domain.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
}
