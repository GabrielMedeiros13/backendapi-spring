package com.gabriel.backendapi_spring.service.impl;

import com.gabriel.backendapi_spring.dto.EmployeeDto;
import com.gabriel.backendapi_spring.entity.Employee;
import com.gabriel.backendapi_spring.exception.ResourceNotFoundException;
import com.gabriel.backendapi_spring.mapper.EmployeeMapper;
import com.gabriel.backendapi_spring.repository.EmployeeRepository;
import com.gabriel.backendapi_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDTO(employee) )
                .collect(Collectors.toList());
    }
}
