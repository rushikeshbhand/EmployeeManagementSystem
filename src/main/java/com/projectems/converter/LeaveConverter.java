package com.projectems.converter;

import org.springframework.stereotype.Component;

import com.projectems.dto.LeaveDTO;
import com.projectems.entities.Employee;
import com.projectems.entities.Leave;

@Component
public class LeaveConverter {

    public LeaveDTO convertToLeaveDTO(Leave leave) {
        LeaveDTO leaveDTO = new LeaveDTO();
        leaveDTO.setId(leave.getId());
        leaveDTO.setEmployeeId(leave.getEmployee().getId());
        leaveDTO.setReason(leave.getReason());
        leaveDTO.setStartDate(leave.getStartDate());
        leaveDTO.setEndDate(leave.getEndDate());
        return leaveDTO;
    }

    public Leave convertToLeaveEntity(LeaveDTO leaveDTO) {
        Leave leave = new Leave();
        leave.setId(leaveDTO.getId());
        // Set employee using the employeeId
        Employee employee = new Employee();
        employee.setId(leaveDTO.getEmployeeId());
        leave.setEmployee(employee);
        leave.setReason(leaveDTO.getReason());
        leave.setStartDate(leaveDTO.getStartDate());
        leave.setEndDate(leaveDTO.getEndDate());
        return leave;
    }
}
