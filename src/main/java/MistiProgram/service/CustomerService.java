package MistiProgram.service;

import MistiProgram.domain.Customer;
import MistiProgram.utility.CustomerCustomEcxeption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {

     Customer save(Customer customer);

     Customer update(Customer  customer);

     Page<Customer> findAll(Pageable pageable);

     Optional<Customer> findById(Long id);

     void deleteById(Long id);

     List<Customer> findByName(String name) throws CustomerCustomEcxeption;
}