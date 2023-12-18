//package com.projectems.repository.test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.projectems.dao.UserRepository;
//import com.projectems.entities.User;
//
//@SpringBootTest
//@DataJpaTest
//public class Userrepotest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testSaveAndGetUser() {
//        // Create a sample User
//        User user = new User();
//        user.setUserName("testUser");
//        user.setEmail("test@example.com");
//
//        // Save the User to the repository
//        User savedUser = userRepository.save(user);
//
//        // Retrieve the saved User
//        User retrievedUser = userRepository.findUserById(savedUser.getId());
//
//        assertNotNull(retrievedUser);
//        assertEquals(savedUser.getUsername(), retrievedUser.getUsername());
//        assertEquals(savedUser.getEmail(), retrievedUser.getEmail());
//    }
//
//    @Test
//    public void testFindByUsername() {
//        // Create a sample User
//        User user = new User();
//        user.setUserName("testUser");
//        user.setEmail("test@example.com");
//
//        // Save the User to the repository
//        userRepository.save(user);
//
//        // Retrieve the User by username
//        User retrievedUser = userRepository.findByUsername("testUser");
//
//        assertNotNull(retrievedUser);
//        assertEquals("testUser", retrievedUser.getUsername());
//    }
//
//    @Test
//    public void testDeleteUser() {
//        // Create a sample User
//        User user = new User();
//        user.setUserName("testUser");
//        user.setEmail("test@example.com");
//
//        // Save the User to the repository
//        User savedUser = userRepository.save(user);
//
//        // Delete the User
//        userRepository.delete(savedUser);
//
//        // Try to retrieve the deleted User
//        User deletedUser = userRepository.findUserById(savedUser.getId());
//
//        assertNull(deletedUser);
//    }
//}
