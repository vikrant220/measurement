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
        Distance distance1 = new Distance(1000, Unit.METER);
        Distance distance2 = new Distance(1000, Unit.METER);
        assertTrue(distance1.similarEqual(distance2));
    }

    @Test
    public void ShouldBeFalseIfOneIs1OtherOneIs2(){
        Distance distance1 = new Distance(1, Unit.KM);
        Distance distance2 = new Distance(2, Unit.KM);
        assertFalse(distance1.similarEqual(distance2));
    }

    @Test
    void ShouldBeTrueIfOneIs1000MetersOtherOneIs1KM() {
        Distance distance1 = new Distance(1000, Unit.METER);
        Distance distance2  = new Distance(1,Unit.KM);

        assertTrue(distance1.similarEqual(distance2));
    }

    @Test
    void ShouldBeTrueIfOneIs1000MetersOtherOneIs1KMWithString() {
        Distance distance1 = new Distance(1000, Unit.METER);
        Distance distance2  = new Distance(1, Unit.KM);

        assertTrue(distance2.similarEqual(distance1));
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
        Distance distance2  = new Distance(1,Unit.METER);
        assertTrue(distance2.similarEqual(distance1));

    }
    @Test
    public void shouldBeTrueIfOneIs1MetersOtherOneIs1000Centimeter(){
        Distance distance1 = new Distance(1, Unit.METER);
        Distance distance2  = new Distance(100,Unit.CM);
        assertTrue(distance2.similarEqual(distance1));

    }

    @Test
    public void shouldBeTrueIfOneIs5KilometersOtherOneIs500000Centimeter(){
        Distance distance1 = new Distance(5,Unit.KM);
        Distance distance2  = new Distance(500000,Unit.CM);
        assertTrue(distance2.similarEqual(distance1));

    }
    @Test
    public void shouldBeTrueIfOneIs2KilometersOtherOneIs200000Centimeter(){
        Distance distance1 = new Distance(2,Unit.KM);
        Distance distance2  = new Distance(200000,Unit.CM);
        assertTrue(distance2.similarEqual(distance1));

    }

    @Test
    void SumOfDistanceShouldBe2000MetersIfOneIs1000MetersOtherOneIs1000Meters() {
        Distance distance1 = new Distance(1000, Unit.METER);
        Distance distance2 = new Distance(1000, Unit.METER);
        Distance distance3 = new Distance(2000, Unit.METER);

        assertEquals(distance3, distance1.additionOfDistance(distance2));
    }

    @Test
    void SumOfDistanceShouldBe13KmIfOneIs1KMOtherIs300Meters(){
        Distance distance1 = new Distance(1, Unit.KM);
        Distance distance2 = new Distance(300, Unit.METER);
        Distance distance3 = new Distance(1.3, Unit.KM);

        assertEquals(distance3, distance1.additionOfDistance(distance2));
    }
    @Test
    void SumOfDistanceShouldBe1500MetersIfOneIs1KMOtherIs500Meters(){
        Distance distance1 = new Distance(500, Unit.METER);
        Distance distance2 = new Distance(1, Unit.KM);
        Distance distance3 = new Distance(1500, Unit.METER);

        assertEquals(distance3, distance1.additionOfDistance(distance2));
    }

    @Test
    void SumOfDistanceShouldNotBe2KMIfOneIs1000MetersOtherIs1000Meters(){
        Distance distance1 = new Distance(1000, Unit.METER);
        Distance distance2 = new Distance(1000, Unit.METER);
        Distance distance3 = new Distance(2, Unit.KM);

        assertNotEquals(distance3, distance1.additionOfDistance(distance2));
    }


}
