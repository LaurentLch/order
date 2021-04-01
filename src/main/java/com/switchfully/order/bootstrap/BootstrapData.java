package com.switchfully.order.bootstrap;

import com.switchfully.order.domain.entities.Customer;
import com.switchfully.order.domain.entities.CustomerOrder;
import com.switchfully.order.domain.entities.Item;
import com.switchfully.order.domain.repositories.CustomerOrderRepository;
import com.switchfully.order.domain.repositories.CustomerRepository;
import com.switchfully.order.domain.repositories.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    //INSTANCE VARIABLES
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final CustomerOrderRepository customerOrderRepository;


    //CONSTRUCTORS
    public BootstrapData(CustomerRepository customerRepository, ItemRepository itemRepository, CustomerOrderRepository customerOrderRepository) {
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.customerOrderRepository = customerOrderRepository;
    }


    //OVERRIDES
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap...");

        //CREATE
        Customer customer1 = new Customer("John", "Doe", "johndoe@gmail.com", "10 Main Street, NYC", "123456");
        Customer customer2 = new Customer("Jane", "Doe", "janedoe@gmail.com", "10 Main Street, NYC", "567890");
        Item item1 = new Item("Computer","Dell, Intel i5, 16RAM, 500GB HDD", 1299.99,3);
        Item item2 = new Item("Computer","HP, Intel i7, 32RAM, 1000GB HDD", 1599.99, 4);
        CustomerOrder customerOrder1 = new CustomerOrder();

        //SAVE CREATION
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        itemRepository.save(item1);
        itemRepository.save(item2);
        customerOrderRepository.save(customerOrder1);

        //ALLOCATION
        customer1.getItems().add(item1);
        customer1.getItems().add(item2);
        customer2.getItems().add(item2);
        item1.getCustomers().add(customer1);
        item2.getCustomers().add(customer1);
        item2.getCustomers().add(customer2);
        item1.setCustomerOrder(customerOrder1);
        item2.setCustomerOrder(customerOrder1);
        customerOrder1.getItems().add(item1);

        //SAVE ALLOCATION
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        itemRepository.save(item1);
        itemRepository.save(item2);
        customerOrderRepository.save(customerOrder1);


        System.out.println("Number of items: " + itemRepository.count());
        System.out.println("Number of customers: " + customerRepository.count());
        System.out.println("Number of orders: " + customerOrderRepository.count());

    }
}
