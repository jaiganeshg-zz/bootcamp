package bootcamp;

import static bootcamp.Unit.INCH;

/**
 * Created by jaiganesh on 08/08/17.
 */
public class Measurement {

    private int length;
    private Unit unit;
    private InchConverter converter;

    public Measurement(int length, Unit unit) {
        this.length = length;
        this.unit = unit;
        if (unit.equals(Unit.FOOT)) this.converter = new FootToInchesConverter();
        else if (unit.equals(Unit.YARD)) this.converter = new YardToInchesConverter();
        else this.converter = new InchToInchesConverter();
    }

    public Measurement convertToInches() {
        return converter.convert(length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Measurement that = (Measurement) o;

        if (length != that.length) return false;
        return unit == that.unit;
    }

    @Override
    public int hashCode() {
        int result = length;
        result = 31 * result + unit.hashCode();
        return result;
    }

    public Measurement addMeasurement(Measurement adder) {
        return new Measurement(this.convertToInches().length + adder.convertToInches().length, INCH);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "length=" + length +
                ", unit=" + unit +
                '}';
    }
}