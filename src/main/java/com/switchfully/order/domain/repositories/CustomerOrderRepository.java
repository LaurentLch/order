package com.switchfully.order.domain.repositories;

import com.switchfully.order.domain.entities.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Long> {
}
