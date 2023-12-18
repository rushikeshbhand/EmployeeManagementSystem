package com.projectems.service;

import java.util.List;

import com.projectems.dto.LeaveDTO;

public interface LeaveService {
    LeaveDTO createLeave(LeaveDTO leaveDTO);
    LeaveDTO getLeaveById(Long id);
    LeaveDTO updateLeave(Long id, LeaveDTO leaveDTO);
    String deleteLeave(Long id);
    List<LeaveDTO> getAllLeaves();
}
