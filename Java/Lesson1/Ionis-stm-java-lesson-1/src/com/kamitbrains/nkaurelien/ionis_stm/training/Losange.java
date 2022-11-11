package com.kamitbrains.nkaurelien.ionis_stm.training;

public class Losange extends Car  implements Drive {
    public Losange(String color) {
        super(0 , color);
    }


    public boolean greaterThan(Car item) {
        return this.tireNumber > item.getTireNumber();
    }
}
