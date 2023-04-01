package isp.lab6.exercise2;


public class Equipment {
    private String name;
    private String serialNumber;
    private String owner;
    private boolean taken;

    public Equipment(String serialNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Equipment(String name, String serialNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Equipment(String name, String serialNumber, String owner) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isTaken() {
        return taken;
    }

    /**
     * Provide the owner of the equipment
     * Equipment should be set as taken
     *
     * @param owner - owner name
     */
    public void provideEquipmentToUser(final String owner) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Equipment is returned to the office
     * Equipment should not be set as taken
     * Remove the owner
     */
    public void returnEquipmentToOffice() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
