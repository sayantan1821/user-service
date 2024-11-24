package com.pepsodent.userservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseEntityTest {

    @Test
    void testSoftDelete() {
        // Given a BaseEntity instance
        BaseEntity entity = new BaseEntity();

        // Initially, the deleted flag should be false
        assertFalse(entity.getDeleted());

        // When soft delete is applied
        entity.softDelete();

        // Then the deleted flag should be true
        assertTrue(entity.getDeleted());
    }

    @Test
    void testRestore() {
        // Given a BaseEntity instance that is soft deleted
        BaseEntity entity = new BaseEntity();
        entity.softDelete();

        // Initially, the deleted flag should be true
        assertTrue(entity.getDeleted());

        // When restore is applied
        entity.restore();

        // Then the deleted flag should be false
        assertFalse(entity.getDeleted());
    }
}