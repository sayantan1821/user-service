package com.pepsodent.userservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        // Setup a User instance for testing
        user = new User();
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");

        // Initialize the roles set
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setTag("USER");
        roles.add(role);
        user.setRoles(roles);
    }

    @Test
    void testUserFields() {
        // Test basic fields
        assertNotNull(user.getEmail());
        assertNotNull(user.getPassword());
        assertNotNull(user.getRoles());
        assertTrue(user.getRoles().size() > 0);
    }

    @Test
    void testDefaultDeletedFlag() {
        // The deleted flag should be false by default (inherited from BaseEntity)
        assertFalse(user.getDeleted());
    }

    @Test
    void testSoftDelete() {
        // Soft delete should mark the user as deleted
        user.softDelete();
        assertTrue(user.getDeleted());
    }

    @Test
    void testRestore() {
        // Soft delete the user and then restore it
        user.softDelete();
        user.restore();
        assertFalse(user.getDeleted());
    }
}
