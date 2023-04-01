package isp.lab6.exercise2;

import org.junit.Test;

import static org.junit.Assert.*;

public class EquipmentTest {
    @Test
    public void testCreate() {
        final Equipment firstEquipment = new Equipment("Dell", "SN123");
        assertFalse("Equipment should not be automatically set as taken", firstEquipment.isTaken());
        assertNull("Owner should be null", firstEquipment.getOwner());

        final Equipment secondEquipment = new Equipment("Dell", "SN124", "John");
        assertTrue("Equipment should automatically set as taken", secondEquipment.isTaken());
        assertEquals("Owner should be 'John'", "John", secondEquipment.getOwner());
    }

    @Test
    public void testProvideEquipmentToUser() {
        final Equipment unprovidedEquipment = new Equipment("Dell", "SN123");
        assertFalse("Equipment should be automatically set as taken", unprovidedEquipment.isTaken());
        assertNull("Owner should be null", unprovidedEquipment.getOwner());

        unprovidedEquipment.provideEquipmentToUser("John");
        assertTrue("Equipment should be set as taken", unprovidedEquipment.isTaken());
        assertEquals("Equipment owner should be 'John'", "John", unprovidedEquipment.getOwner());
    }

    @Test
    public void testReturnEquipmentToOffice() {
        final Equipment providedEquipment = new Equipment("Dell", "SN123", "John");
        assertTrue("Equipment is provided to 'John'", providedEquipment.isTaken());
        assertEquals("Equipment is provided to 'John'", "John", providedEquipment.getOwner());

        providedEquipment.returnEquipmentToOffice();
        assertFalse("Equipment should not be provided anymore", providedEquipment.isTaken());
        assertNull("Equipment should not be provided anymore to 'John'", providedEquipment.getOwner());
    }
}