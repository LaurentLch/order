package com.switchfully.order.domain.repositories;

import com.switchfully.order.domain.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
