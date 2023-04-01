package isp.lab6.exercise1;

import java.util.List;

public interface IReadingRepository {

    /**
     * Add a new sensor reading.
     *
     * @param reading
     */
    public void addReading(SensorReading reading);

    /**
     * Return avarage of all readings for a specific sensor type and location.
     *
     * @param type
     * @return
     */
    public double getAvarageValueByType(Type type, String location);

    /**
     * Return all readings for a specific type.
     *
     * @param type
     * @return
     */
    public List<SensorReading> getReadingsByType(Type type);

    /**
     * List all readings sorted by location (alphabetical).
     */
    public void listSortedByLocation();

    /**
     * List all readings sorted by value;
     */
    public void listSortedByValue();

    /**
     * Return all readings filtered by type and location.
     *
     * @param location
     * @param type
     * @return
     */
    public List<SensorReading> findAllByLocationAndType(String location, Type type);

}
