/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author tuvshuu
 */
@ManagedBean(name = "employeeList")
@SessionScoped
public class EmployeeListManagedBean {

    private List<Employee> employeeList;
    private Employee currentEmployee;

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public EmployeeListManagedBean() {
        employeeList = new ArrayList<Employee>(Arrays.asList(
                new Employee(1, "Frank Brown", "625-345-2635", 45089.5),
                new Employee(2, "John Doe", "625-345-4512", 56003.0),
                new Employee(3, "Mary Jones", "625-345-6378", 73998.1)
        ));
        currentEmployee = employeeList.get(0);

    }

    public String showEmployee(Integer id) {
        for (Employee tmpEmp : employeeList) {
            if (tmpEmp.getId() == id) {
                currentEmployee = tmpEmp;
            }
        }
        return null;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(Employee currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

}
