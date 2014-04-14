package com.joe007.practice;

import java.util.ArrayList;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        

        ArrayList<ArrayList<String>> rowsList = new ArrayList<ArrayList<String>>();

        int num1Len = num1.length();
        int num2Len = num2.length();

        boolean firstRow = true;
        int totalDigits = 0;
        for (int i = 0; i <= num2Len - 1; i++) {
            int num2Elem = Integer.valueOf(String.valueOf(num2.charAt(i)));
            System.out.println("num2Elem:" + num2Elem);

            ArrayList<String> rowList = new ArrayList<String>();
            int carryVal = 0;
            for (int j = num1Len - 1; j >= 0; j--) {
                int num1Elem = Integer.valueOf(String.valueOf(num1.charAt(j)));
                System.out.println("num1Elem:" + num1Elem + "; num2Elem:"
                        + num2Elem);
                int product = num1Elem * num2Elem + carryVal;
                String productStr = String.valueOf(product);
                System.out.println("productStr:" + productStr);
                if (productStr.length() == 1) {
                    rowList.add(0, productStr);
                    carryVal = 0;
                } else if (productStr.length() == 2) {
                    rowList.add(0, String.valueOf(productStr.charAt(1)));
                    carryVal = Integer.valueOf(String.valueOf(productStr
                            .charAt(0)));
                }
            }
            
            if(carryVal != 0){
                rowList.add(0, String.valueOf(carryVal));
            }

            // add zero digits
            int zeroDigits = num2Len - 1 - i;
            if (zeroDigits > 0) {
                for (int k = 1; k <= zeroDigits; k++) {
                    rowList.add("0");
                }
            }

            if (firstRow) {
                totalDigits = rowList.size();
                firstRow = false;
            } else {
                int originalSize = rowList.size();
                for (int m = 1; m <= totalDigits - originalSize; m++) {
                    rowList.add(0, "0");
                }
            }

            rowsList.add(rowList);

        }

        // add the rows
        ArrayList<String> resultList = new ArrayList<String>();
        int carryVal = 0;
        for (int digitIndex = totalDigits - 1; digitIndex >= 0; digitIndex--) {
            int digitVal = 0;
            for (int i = 0; i < rowsList.size(); i++) {
                ArrayList<String> row = rowsList.get(i);
                digitVal += Integer.valueOf(row.get(digitIndex));
            }
            digitVal += carryVal;
            String digitStr = String.valueOf(digitVal);
            if (digitStr.length() == 1) {
                resultList.add(0, digitStr);
                carryVal = 0;
            } else {
                resultList.add(0,
                        String.valueOf(digitStr.charAt(digitStr.length() - 1)));
                carryVal = Integer.valueOf(digitStr.substring(0,
                        digitStr.length() - 1));
            }
        }
        if(carryVal != 0){
            resultList.add(0, String.valueOf(carryVal));
        }

        StringBuilder sb = new StringBuilder();
        for (String elem : resultList) {
            sb.append(elem);
        }
        System.out.println(rowsList);
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings instance = new MultiplyStrings();
        String num1 = "9";
        String num2 = "9";
        System.out.println(instance.multiply(num1, num2));

    }

}
