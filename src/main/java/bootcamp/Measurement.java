package bootcamp;

/**
 * Created by jaiganesh on 08/08/17.
 */
public class Measurement {

    private int length;
    private Unit unit;
    private InchConverter converter;

    public Measurement() {

    }

    public Measurement(int length, Unit unit) {
        this.length = length;
        this.unit = unit;
    }

    public Measurement(int length, Unit unit, InchConverter converter) {
        this.length = length;
        this.unit = unit;
        this.converter = converter;
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
        return new Measurement((this.unit != Unit.INCH ? this.convertToInches().length : this.length) + (adder.unit != Unit.INCH ? adder.convertToInches().length : adder.length), Unit.INCH);
    }


    public Measurement addYard(Measurement adder) {
        return this;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "length=" + length +
                ", unit=" + unit +
                '}';
    }

    public static class MeasurementBuilder {
        private Measurement measurement;

        public MeasurementBuilder(int length, Unit unit) {
            measurement = new Measurement(length, unit);
            if (unit.equals(Unit.FOOT)) measurement.converter = new FootToInchesConverter();
            if (unit.equals(Unit.YARD)) measurement.converter = new YardToInchesConverter();
        }

        public Measurement build() {
            return measurement;
        }
    }
}