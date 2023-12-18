package com.projectems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projectems.converter.LeaveConverter;
import com.projectems.dao.LeaveRepository;
import com.projectems.dto.LeaveDTO;
import com.projectems.entities.Leave;
import com.projectems.service.LeaveService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LeaveServiceImpl implements LeaveService {
	  @Autowired
    private  LeaveRepository leaveRepository;
	  @Autowired
    private  LeaveConverter leaveConverter;

  
    public LeaveServiceImpl(LeaveRepository leaveRepository, LeaveConverter leaveConverter) {
        this.leaveRepository = leaveRepository;
        this. leaveConverter = leaveConverter;
    }

    @Override
    public LeaveDTO createLeave(LeaveDTO leaveDTO) {
        Leave leave = leaveConverter.convertToLeaveEntity(leaveDTO);
        leave = leaveRepository.save(leave);
        return leaveConverter.convertToLeaveDTO(leave);
    }

    @Override
    public LeaveDTO getLeaveById(Long id) {
        Optional<Leave> leave = leaveRepository.findById(id);
        return leave.map(leaveConverter::convertToLeaveDTO).orElse(null);
    }

    @Override
    public LeaveDTO updateLeave(Long id, LeaveDTO leaveDTO) {
        Leave leave = leaveConverter.convertToLeaveEntity(leaveDTO);
        leave.setId(id);
        leave = leaveRepository.save(leave);
        return leaveConverter.convertToLeaveDTO(leave);
    }

    @Override
    public String deleteLeave(Long id) {
        leaveRepository.deleteById(id);
        return "Leave with ID " + id + " has been deleted successfully.";
    }

    @Override
    public List<LeaveDTO> getAllLeaves() {
        List<Leave> leaves = leaveRepository.findAll();
        return leaves.stream().map(leaveConverter::convertToLeaveDTO).collect(Collectors.toList());
    }
}
