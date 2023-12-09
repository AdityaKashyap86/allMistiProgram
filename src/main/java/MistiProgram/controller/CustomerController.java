package MistiProgram.controller;

import MistiProgram.domain.Customer;
import MistiProgram.service.CustomerService;
import MistiProgram.utility.CustomerCustomEcxeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api")
public class CustomerController {


    @Autowired
    CustomerService customerService;

    @PostMapping("/CreatedCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        Customer result = customerService.save(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }

    @PutMapping("/updateCus/{Id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer result = customerService.update(customer);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

    @GetMapping("/findCustomer")
    public ResponseEntity<Page<Customer>> findAllCustomer (Pageable pageable) {
        Page<Customer> result = customerService.findAll(PageRequest.of(0,2));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }


    @GetMapping("/GetOneCustomer/{id}")
    public ResponseEntity<Optional<Customer>> findOneCustomer(@PathVariable Long id) {
        Optional<Customer> result = customerService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }

//And we here the fetching the data and that time DATA not found then it will throw the exception CustomerRecordNotFound


    @GetMapping("/getCusRecord/{name}")
    public ResponseEntity<List<Customer>> getRecByName(@PathVariable String name) throws CustomerCustomEcxeption {
        List<Customer> result = customerService.findByName(name);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(result);
    }



    /*   @DeleteMapping ("/DeleteOneCustomer/{id}")
    public void deleteCustomer (@PathVariable Long id) {
        Customer cus = customerService.deleteById(id);
    }*/

}
