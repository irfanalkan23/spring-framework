package com.cydeo.bootstrap;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DataGenerator(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        regionRepository.findById(1L);

        System.out.println("-----------------REGION START-----------------");
        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findDistinctByCountry: " + regionRepository.findDistinctByCountry("Canada"));
        System.out.println("findByCountryContainsIgnoreCase: " + regionRepository.findByCountryContainsIgnoreCase("United"));
        System.out.println("findByCountryContainsOrderByCountry: " + regionRepository.findByCountryContainsOrderByCountry("Asia"));
        System.out.println("findTopByCountry: " + regionRepository.findTop2ByCountry("Canada"));

        System.out.println("-----------------REGION END-----------------");

        System.out.println("-----------------DEPARTMENT START-----------------");
        System.out.println("findByDepartment: " + departmentRepository.findByDepartmentIgnoreCase("toys"));
        System.out.println("findByDivisionIs: " + departmentRepository.findByDivisionIs("Outdoors"));
        System.out.println("findDistinctTop3ByDivisionContains: " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("-----------------DEPARTMENT END-----------------");

        System.out.println("-----------------EMPLOYEE START-----------------");
        System.out.println("findByEmail: " + employeeRepository.findByEmailIs("bmanueau0@dion.ne.jp"));
        System.out.println("findByFirstNameIsAndLastNameIsOrEmail: " + employeeRepository.findByFirstNameIsAndLastNameIsOrEmail("Aeriell","McNee","fmorffew4@a8.net"));
//        System.out.println("findByFirstNameIsNot: " + employeeRepository.findByFirstNameIsNot(""));
        System.out.println("findBySalaryGreaterThan: " + employeeRepository.findBySalaryGreaterThan(165000));
        System.out.println("findByEmailIsNull: " + employeeRepository.findByEmailIsNull());

        System.out.println("-----------------EMPLOYEE  END-----------------");

        System.out.println("-----------------COURSE START-----------------");



        System.out.println("-----------------COURSE  END-----------------");

    }
}
