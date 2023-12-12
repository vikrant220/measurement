import java.util.Objects;

enum Unit{
    KM,METER,CM
        }

public class Distance {
    final private int value;


    public Distance(int value){
        this.value = value;
    }

//    public  int HashCode(){
//        return this.value;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Distance(int value, Unit unit) {
        if(unit == Unit.KM)
            this.value = value*1000;
        else if (unit==Unit.CM) {
            this.value = value/100;
        } else
            this.value = value;

    }




    public boolean isEqual(Distance distance2) {
        return (this.value==distance2.value);
    }

}
