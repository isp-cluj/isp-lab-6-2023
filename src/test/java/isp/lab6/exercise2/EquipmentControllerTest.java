package isp.lab6.exercise2;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class EquipmentControllerTest {

    @Test
    public void testAddEquipment() {
        final Equipment firstEquipment = new Equipment("Dell", "SN123", "John");
        final EquipmentController equipmentController = new EquipmentController();

        equipmentController.addEquipment(firstEquipment);
        assertEquals("Number of equipments should be 1", 1, equipmentController.getNumberOfEquipments());
    }

    @Test
    public void testGetEquipments() {
        final Equipment firstEquipment = new Equipment("Dell", "SN123", "John");
        final EquipmentController equipmentController = new EquipmentController();
        equipmentController.addEquipment(firstEquipment);

        final List<Equipment> equipmentList = equipmentController.getEquipments();
        assertNotNull("List of equipments should not be null", equipmentList);
        assertEquals("Number of equipments should be 1", 1, equipmentList.size());
        assertEquals("First equipment should be the added one", firstEquipment, equipmentList.get(0));
    }

    @Test
    public void testGetNumberOfEquipments() {
        final Equipment firstEquipment = new Equipment("Dell", "SN123", "John");
        final Equipment secondEquipment = new Equipment("HP", "SN124", "John");
        final Equipment thirdEquipment = new Equipment("Toshiba", "SN125", "John");

        final EquipmentController equipmentController = new EquipmentController();
        equipmentController.addEquipment(firstEquipment);
        assertEquals("Number of equipments should be 1", 1, equipmentController.getNumberOfEquipments());

        equipmentController.addEquipment(secondEquipment);
        assertEquals("Number of equipments should be 2", 2, equipmentController.getNumberOfEquipments());

        equipmentController.addEquipment(thirdEquipment);
        assertEquals("Number of equipments should be 3", 3, equipmentController.getNumberOfEquipments());
    }

    @Test
    public void testGroupEquipmentsByOwner() {
        final Equipment johnFirstEquipment = new Equipment("Dell", "SN123", "John");
        final Equipment johnSecondEquipment = new Equipment("HP", "SN124", "John");
        final Equipment maryFirstEquipment = new Equipment("Toshiba", "SN125", "Mary");
        final EquipmentController equipmentController = new EquipmentController();
        equipmentController.addEquipment(johnFirstEquipment);
        equipmentController.addEquipment(johnSecondEquipment);
        equipmentController.addEquipment(maryFirstEquipment);

        final Map<String, List<Equipment>> equipmentsGroupedByOwner = equipmentController.getEquipmentsGroupedByOwner();
        assertNotNull("Equipments grouped by owner should not be null", equipmentsGroupedByOwner);

        final List<Equipment> johnEquipments = equipmentsGroupedByOwner.get("John");
        assertNotNull("John equipments array should not be null", johnEquipments);
        assertEquals("John should have 2 equipments", 2, johnEquipments.size());

        final List<Equipment> maryEquipments = equipmentsGroupedByOwner.get("Mary");
        assertNotNull("Mary equipments array should not be null", maryEquipments);
        assertEquals("Mary should have one equipment", 1, maryEquipments.size());
        assertEquals("First equipment should be the added one", maryFirstEquipment, maryEquipments.get(0));
    }

    @Test
    public void testRemoveEquipmentBySerialNumber() {
        final Equipment firstEquipment = new Equipment("Dell", "SN123", "John");
        final Equipment secondEquipment = new Equipment("Dell", "SN125", "John");
        final EquipmentController equipmentController = new EquipmentController();
        equipmentController.addEquipment(firstEquipment);
        equipmentController.addEquipment(secondEquipment);

        final Equipment notFoundEquipment = equipmentController.removeEquipmentBySerialNumber("SN124");
        assertNull("No equipment should be deleted", notFoundEquipment);
        assertEquals("The number of equipments should be 2", 2, equipmentController.getNumberOfEquipments());

        final Equipment deletedEquipment = equipmentController.removeEquipmentBySerialNumber("SN123");
        assertNotNull("Deleted equipment should not be null", deletedEquipment);
        assertEquals("Deleted equipment should be the correct one", firstEquipment, deletedEquipment);
        assertEquals("The number of equipments should be 1", 1, equipmentController.getNumberOfEquipments());
    }
}