package sample.info;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class customercontrolling {

  private final EmployeeRepository repository;

  customercontrolling(EmployeeRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/customer")
  List<customer> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/customer")
  customer newEmployee(@RequestBody customer newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  
  @GetMapping("/customer/{id}")
  Optional<customer> one(@PathVariable Long id) {
    
    return repository.findById(id);
  }

  @PutMapping("/customer/{id}")
  customer replaceEmployee(@RequestBody customer newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setName(newEmployee.getName());
        employee.setRole(newEmployee.getRole());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setId(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/customer/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}


