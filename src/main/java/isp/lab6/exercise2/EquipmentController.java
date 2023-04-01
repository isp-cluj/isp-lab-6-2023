package isp.lab6.exercise2;

import java.util.List;
import java.util.Map;

public class EquipmentController {

    /**
     * Add new equipment to the list of equipments
     *
     * @param equipment - equipment to be added
     */
    public void addEquipment(final Equipment equipment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get current list of equipments
     *
     * @return list of equipments
     */
    public List<Equipment> getEquipments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get number of equipments
     *
     * @return number of equipments
     */
    public int getNumberOfEquipments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Group equipments by owner
     *
     * @return a dictionary where the key is the owner and value is represented by list of equipments he owns
     */
    public Map<String, List<Equipment>> getEquipmentsGroupedByOwner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Remove a particular equipment from equipments list by serial number
     * @param serialNumber - unique serial number
     * @return deleted equipment instance or null if not found
     */
    public Equipment removeEquipmentBySerialNumber(final String serialNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
