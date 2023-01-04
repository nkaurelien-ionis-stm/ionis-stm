package com.kamitbrains.nkaurelien.ionis_stm.practices.csvreader;

import com.kamitbrains.nkaurelien.ionis_stm.practices.csvreader.contracts.CsvRowInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Row implements CsvRowInterface {

    Map<String, String> map = new HashMap<>();
    ;
    private final List<String> header;

    Row(List<String> header) {

        this.header = header;
    }

    public static Row buildFromString(List<String> header, String row, Character separator) {
        List<String> cells = Arrays.asList(row.split(separator.toString()));
        return Row.buildFromList(header, cells);
    }


    public static Row buildFromList(List<String> header, List<String> cells) {

        Row row = new Row(header);
        for (int i = 0; i < header.size(); i++) {
            String k = header.get(i);
            String v = i < cells.size() ? cells.get(i) : null;
            row.add(k, v);
        }

        return row;
    }


    @Override
    public String get(String columnName) {
        return map.get(columnName);
    }

    @Override
    public void add(String column, String value) {
        if (header.contains(column)) {
            map.put(column, value);
        }
    }

    @Override
    public void remove(String column) {
        map.remove(column);
    }

    @Override
    public String toString() {
        return map.toString();
    }

    public List<String> values() {
        return map.values().stream().toList();
    }
}
