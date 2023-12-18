package com.projectems.repository.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectems.dao.LeaveRepository;
import com.projectems.entities.Leave;
import com.projectems.service.LeaveService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class Leaverepotest
{
	@InjectMocks
    private LeaveRepository leaveRepository;

    @Mock
    private LeaveService leaveService;

    @Test
    public void testGetLeaveById() {
        // Create a sample Leave entity and ID
        Long leaveId = 1L;
        Leave leave = new Leave();

        // Mock the behavior of the leaveRepository.findById method
        when(leaveRepository.findById(leaveId)).thenReturn(Optional.of(leave));

        // Call the repository method to get a leave by ID
        Optional<Leave> result = leaveRepository.findById(leaveId);

        // Verify that the service method was not called
        verify(leaveService, times(0)).getLeaveById(leaveId);

        // Assert that the returned Optional contains the expected Leave entity
        assertTrue(result.isPresent());
        assertEquals(leaveId, result.get().getId());
        assertEquals("Vacation", result.get().getEmployee());
    }
}

