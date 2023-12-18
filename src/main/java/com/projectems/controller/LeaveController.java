package com.projectems.controller; //(for leave-related operations)

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projectems.dto.LeaveDTO;
import com.projectems.service.LeaveService;

import java.util.List;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/leaves")
    public List<LeaveDTO> getAllLeaves() {
        List<LeaveDTO> leaveDTOs = leaveService.getAllLeaves();
        return leaveDTOs;
    }

    @GetMapping("/leaves/{id}")
    public ResponseEntity<LeaveDTO> getLeave(@PathVariable Long id) {
        LeaveDTO leaveDTO = leaveService.getLeaveById(id);
        if (leaveDTO != null) {
            return ResponseEntity.ok(leaveDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/leaves")
    public ResponseEntity<LeaveDTO> createLeave(@RequestBody LeaveDTO leaveDTO) {
        LeaveDTO createdLeave = leaveService.createLeave(leaveDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeave);
    }

    @PutMapping("/leaves/{id}")
    public ResponseEntity<LeaveDTO> updateLeave(@RequestBody LeaveDTO leaveDTO, @PathVariable Long id) {
        LeaveDTO updatedLeave = leaveService.updateLeave(id, leaveDTO);
//        if (updatedLeave != null) {
//            return ResponseEntity.ok(updatedLeave);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.ok(updatedLeave);
    }

    @DeleteMapping("/leaves/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
//        if (result.equals("deleted")) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
        return ResponseEntity.noContent().build();

    }  
}
