package MistiProgram.service.impl;

import MistiProgram.domain.Customer;
import MistiProgram.repository.CustomerRepository;
import MistiProgram.service.CustomerService;
import MistiProgram.utility.CustomerCustomEcxeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }


    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByName(String name) throws CustomerCustomEcxeption {
        List<Customer> customers = customerRepository.findByName(name);
        if (customers.isEmpty() || customers == null) {
            throw new CustomerCustomEcxeption();
        }else
        return customers;
    }


}
