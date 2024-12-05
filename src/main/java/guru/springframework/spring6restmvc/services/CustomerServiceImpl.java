package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private Map<UUID, Customer> customersMap;

    public CustomerServiceImpl() {
        this.customersMap = new HashMap<>();

        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Rod Johnson")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .customerName("Eric Evans")
                .version(1)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        customersMap.put(customer1.getId(), customer1);
        customersMap.put(customer2.getId(), customer2);

        log.debug("Customer sample data created : {}", customersMap);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customersMap.values());
    }

    @Override
    public Customer getCustomerById(UUID id) {
        return customersMap.get(id);
    }
}
