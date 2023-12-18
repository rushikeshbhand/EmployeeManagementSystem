//package com.projectems.repository.test;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.projectems.dao.ManagerRepository;
//import com.projectems.dto.ManagerDTO;
//import com.projectems.entities.Manager;
//import com.projectems.service.ManagerService;
//
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.*;
//
//import java.util.Date;
//
//@SpringBootTest
//public class Managerrepotest {
//	@InjectMocks
//    private ManagerRepository managerRepository;
//
//    @Mock
//    private ManagerService managerService;
//
//    @Test
//    
//    
//    public void testCreateManager() {
//        // Create a sample ManagerDTO
//        ManagerDTO managerDTO = new ManagerDTO();
//        managerDTO.setUsername("SampleUsername");
//        managerDTO.setPassword("SamplePassword");
//        managerDTO.setEmail("sample@example.com");
//        managerDTO.setJoinDate(new Date());
//
//        // Mock the behavior of the managerRepository.createManager method
//        when(managerRepository.createManager(any(Manager.class))).thenAnswer(invocation -> {
//            Manager manager = invocation.getArgument(0);
//            manager.setId(1L); // Simulate the generated ID
//            return manager;
//        });
//
//        // Call the repository method to create a manager
//        Manager createdManager = managerRepository.createManager(managerDTO);
//
//        // Verify that the service method was not called
//        verify(managerService, times(0));
//		ManagerService.createManager(managerDTO);
//
//        // Assert that the createdManager matches the expected ManagerDTO
//        assertEquals(ManagerDTO.getUsername(), createdManager.getUsername());
//        assertEquals(1L, createdManager.getId()); // ID is generated
//    }
//}