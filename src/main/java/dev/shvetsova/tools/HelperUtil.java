package dev.shvetsova.tools;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class HelperUtil {
    private HelperUtil() {
    }
    public static DecimalFormat initDecimalFormat() {
        DecimalFormat format = new DecimalFormat("00.00");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        format.setDecimalFormatSymbols(symbols);
        return format;
    }
}
