package br.com.leo.request.converters;


public class NumberConverter {

    public static Double convertToDouble(String srtNumber) {
        if (srtNumber == null)
            return 0D;
        String number = srtNumber.replaceAll(",", ".");
        if(isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String srtNumber) {
        if (srtNumber == null)
            return false;
        String number = srtNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}
