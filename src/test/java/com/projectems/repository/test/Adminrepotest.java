package com.projectems.repository.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.projectems.dao.AdminRepository;
import com.projectems.entities.Admin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DataJpaTest
@ActiveProfiles("test")
public class Adminrepotest
{
	@Autowired
    private AdminRepository adminRepository;

    @Test
    public void testFindAdminById() {
        // Create a sample Admin entity and save it to the database
        Admin admin = new Admin();
        admin.setUsername("Ramesh Sinha");
        adminRepository.save(admin);

        // Retrieve the saved Admin from the database
        Admin retrievedAdmin = adminRepository.findAdminById(admin.getId());

        // Assert that the retrieved Admin is not null
        assertNotNull(retrievedAdmin);

        // Assert that the retrieved Admin's ID matches the expected ID
        assertEquals(admin.getId(), retrievedAdmin.getId());

        // Assert that the retrieved Admin's name matches the expected name
        assertEquals(admin.getUsername(), retrievedAdmin.getUsername());
    }
}
