package com.kamitbrains.nkaurelien.ionis_stm.practices.csvreader;

public class CsvFileConfig {


    public char separator;
    public final char lineSeparator;
    public int firstHeaderLineNumber;
    public boolean hasFirstHeaderLine;

    public CsvFileConfig(boolean hasFirstHeaderLine, int firstHeaderLineNumber, char separator) {
        this.hasFirstHeaderLine = hasFirstHeaderLine ;
        this.firstHeaderLineNumber = firstHeaderLineNumber;
        this.separator = separator;
        this.lineSeparator = '\n' ;
    }

    public CsvFileConfig() {
        this.hasFirstHeaderLine = true ;
        this.firstHeaderLineNumber = 0;
        this.separator = ',' ;
        this.lineSeparator = '\n' ;
    }


}
