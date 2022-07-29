package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {

    private static final double ALARMING_PRESSURE_VALUE = 15;
    private static final double CALM_PRESSURE_VALUE = 19;
    private static Alarm alarm;
    private static Sensor mockedSensor;

    @Before
    public void setup() {
        mockedSensor = Mockito.mock(Sensor.class);
        alarm = new Alarm(mockedSensor);
    }

    @Test
    public void testCheckCalmAlarm() {
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(CALM_PRESSURE_VALUE);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckAlarming() {
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(ALARMING_PRESSURE_VALUE);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testCheck(){
        alarm.check();
    }

    @Test
    public void testSensorPopPressureValue(){
        new Sensor().popNextPressurePsiValue();
    }

}