package com.pepsodent.userservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private Role role;

    @BeforeEach
    void setUp() {
        // Setup a Role instance for testing
        role = new Role();
        role.setTag("ADMIN");
    }

    @Test
    void testRoleFields() {
        // Test basic fields
        assertNotNull(role.getTag());
    }

    @Test
    void testDefaultDeletedFlag() {
        // The deleted flag should be false by default (inherited from BaseEntity)
        assertFalse(role.getDeleted());
    }

    @Test
    void testSoftDelete() {
        // Soft delete should mark the role as deleted
        role.softDelete();
        assertTrue(role.getDeleted());
    }

    @Test
    void testRestore() {
        // Soft delete the role and then restore it
        role.softDelete();
        role.restore();
        assertFalse(role.getDeleted());
    }
}
