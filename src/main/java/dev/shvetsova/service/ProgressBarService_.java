package dev.shvetsova.service;

import dev.shvetsova.model.progressBar.ProgressBar;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ProgressBarService_ {
    public void initProgressBarr(ProgressBar progressBar) {
        MathContext context = new MathContext(4, RoundingMode.HALF_UP);
        BigDecimal result = new BigDecimal(progressBar.getProgress(), context);
        if (result.doubleValue() % 2.5 == 0) {
//            progressBar.outGrid += ProgressBar.GRID;
//            progressBar.progressBarString = String.format("%s%." +
//                    (progressBar.getStringDots().length() - progressBar.outGrid.length()) + "s"
//                    , progressBar.outGrid, progressBar.getStringDots());
        }
    }
//
//    public String getCurrentProgressString(ProgressBar progressBar) {
//        DecimalFormat decimalFormat = HelperUtil.initDecimalFormat();
////        return String.format(ProgressBar.FORMAT_PROGRESS_STRING, progressBar.currentTime
////                , progressBar.getMsg(), decimalFormat.format(progressBar.getProgress()), progressBar.progressBarString);
//    }
}
