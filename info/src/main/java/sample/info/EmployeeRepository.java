package sample.info;


import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<customer, Long> {

}

