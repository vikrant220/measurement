import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

enum Unit{
    KM,METER,CM
        }



public class Distance {
    final private double value;
    final private Unit unit;
    final static public Map<Unit, Integer> map = new HashMap<>();

    static {
        map.put(Unit.METER,100);
        map.put(Unit.KM,100000);
        map.put(Unit.CM,1);

    }


//    public Distance(int value){
//        this.value = value*100;
//    }

//    public  int HashCode(){
//        return this.value;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value && unit == distance.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Distance(double value, Unit unit) {
        this.unit = unit;
        this.value = map.get(unit)*value;

//        if(unit == Unit.KM)
//            this.value = value*1000;
//        else if (unit==Unit.CM) {
//            this.value = value/100;
//        } else
//            this.value = value;

    }




    public boolean similarEqual(Distance distance2) {
        return (this.value==distance2.value);
    }

    public Distance additionOfDistance(Distance distance2) {
        Unit unitOfFirstOperand = this.unit;
        double SumOfDistance = this.value + distance2.value;
        int Divider = map.get(unitOfFirstOperand);
        SumOfDistance /= Divider;
        return new Distance(SumOfDistance, unitOfFirstOperand);

    }
}
