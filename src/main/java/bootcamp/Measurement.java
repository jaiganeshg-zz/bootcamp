package bootcamp;

import java.util.InputMismatchException;

/**
 * Created by jaiganesh on 08/08/17.
 */
public class Measurement {

    private int length;
    private Unit unit;

    public Measurement(int length, Unit unit) {
        this.length = length;
        this.unit = unit;
    }

    public Measurement convertToInches() {
        if (unit == Unit.YARD) return new Measurement(length * 36, Unit.INCH);
        if (unit == Unit.FOOT) return new Measurement(length * 12, Unit.INCH);
        else throw new InputMismatchException("Input must not be other than Foot and Yards");
    }

    public Measurement convertToFoot() {
        if (unit == Unit.YARD) return new Measurement(length * 3, Unit.FOOT);
        else throw new InputMismatchException("Input must not be other than Yards");
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
        if (this.unit.equals(adder.unit)) {
            this.length += adder.length;
        } else {
            if (this.unit.equals(Unit.FOOT) && adder.unit.equals(Unit.YARD)) {
                this.length += adder.convertToFoot().length;
            }
            else if (this.unit.equals(Unit.INCH)) {
                this.length += adder.convertToInches().length;
            }
        }

        return this;
    }


    public Measurement addYard(Measurement adder) {
        return this;
    }




//    public Measurement addInch(Measurement adder) {
//
//        return this;
//    }
}
