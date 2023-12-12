import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

enum Unit {
    KM,METER,CM
}

public class MeasurmentTest {


    @Test
    public void ShouldBeTrueIfBothAre1000Meters(){
        Distance distance1 = new Distance(1000);
        Distance distance2 = new Distance(1000);
        assertTrue(distance1.isEqual(distance2));
    }

    @Test
    public void ShouldBeFalseIfOneIs1OtherOneIs2(){
        Distance distance1 = new Distance(1);
        Distance distance2 = new Distance(2);
        assertFalse(distance1.isEqual(distance2));
    }

    @Test
    void ShouldBeTrueIfOneIs1000MetersOtherOneIs1KM() {
        Distance distance1 = new Distance(1000);
        Distance distance2  = new Distance(1,Unit.KM);

        assertTrue(distance1.isEqual(distance2));
    }

    @Test
    void ShouldBeTrueIfOneIs1000MetersOtherOneIs1KMWithString() {
        Distance distance1 = new Distance(1000);
        Distance distance2  = new Distance(1, Unit.KM);

        assertTrue(distance2.isEqual(distance1));
    }

    @Test
    public void testLengthAsHashMapKey() {
        Map<Distance, Integer> testMap = new HashMap<>();
        Distance length = new Distance(100, Unit.METER);
        testMap.put(length, 15);
        assertNotNull(testMap.get((new Distance(100, Unit.METER))));

    }

    @Test
    public void shouldBeTrueIfOneIs100CentimetersOtherOneIs1Meter(){
        Distance distance1 = new Distance(100,Unit.CM);
        Distance distance2  = new Distance(1);
        assertTrue(distance2.isEqual(distance1));

    }
    @Test
    public void shouldBeTrueIfOneIs1MetersOtherOneIs1000Centimeter(){
        Distance distance1 = new Distance(1);
        Distance distance2  = new Distance(100,Unit.CM);
        assertTrue(distance2.isEqual(distance1));

    }

    @Test
    public void shouldBeTrueIfOneIs5KilometersOtherOneIs500000Centimeter(){
        Distance distance1 = new Distance(5,Unit.KM);
        Distance distance2  = new Distance(500000,Unit.CM);
        assertTrue(distance2.isEqual(distance1));

    }
    @Test
    public void shouldBeTrueIfOneIs2KilometersOtherOneIs200000Centimeter(){
        Distance distance1 = new Distance(2,Unit.KM);
        Distance distance2  = new Distance(200000,Unit.CM);
        assertTrue(distance2.isEqual(distance1));

    }

}
