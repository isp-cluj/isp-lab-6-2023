package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum SensorType{
    TEMP, PRES;
}
/////////////////////////////////////////
class SensorReading implements Comparable<SensorReading>{
    double value;
    long dateAndTime;

    public SensorReading(double value, long dateAndTime) {
        this.value = value;
        this.dateAndTime = dateAndTime;
    }

    @Override
    public int compareTo(SensorReading o) {
        return (int)(value - o.value);
    }
}
/////////////////////////////////////////
class Sensor{
    ArrayList<SensorReading> readings = new ArrayList<>();
    String id;
    SensorType type;

    public Sensor(String id, SensorType type) {
        this.id = id;
        this.type = type;
    }

    public boolean addSensorReading(SensorReading reading){
        readings.add(reading);
        return true;
    }

    List<SensorReading> getSensorReadingSortedByValue(){
        Collections.sort(readings); //aceasta metoda utilizeaaz criteriul definiti in compareTo din clasa SensorReading)
        return readings;
    }

}
/////////////////////////////////////////
class SensorCluster{
    ArrayList<Sensor> sensors = new ArrayList<>();

    public void addSensor(String id, SensorType type){
        sensors.add(new Sensor(id, type));
    }

    public void writeSensorReading(String id, double value, long dtaeTime){
        for(Sensor s: sensors){
            if(s.id.equals(id)){
                s.addSensorReading(new SensorReading(value,dtaeTime));
            }
        }
    }

    public Sensor getSensorById(String id){
        return sensors.stream().filter(s -> s.id==id).findFirst().get();
    }

}
/////////////////////////////////////////
public class Exercise3 {

    public static void main(String[] args) {
        SensorCluster c = new SensorCluster();
        c.addSensor("1",SensorType.TEMP);

        c.writeSensorReading("1",8,9);
        c.writeSensorReading("1",1,91);
        c.writeSensorReading("1",7,92);
        c.writeSensorReading("1",5,93);
        c.writeSensorReading("1",2,19);

        Sensor s1 = c.getSensorById("1");
        List<SensorReading> rez = s1.getSensorReadingSortedByValue();


        ////////////
        rez.stream().forEach(s -> System.out.println(s.value));

        //////////
//        for(SensorReading s: rez){
//            System.out.println(s.value);
//        }


    }
}
