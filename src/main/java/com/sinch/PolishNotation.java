package com.sinch;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PolishNotation {

    public static void main(String[] args) {
        String input = null;
        List<String> inputList = new ArrayList<String>();
        System.out.println("Insert each expression in a single line. Insert exit to return.");
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                input = sc.nextLine();
                if(input == null || input.isEmpty())
                    continue;
                else if(input.equalsIgnoreCase("exit"))
                    break;
                else {
                    inputList.add(input);
                }
            }
        }catch (Exception e){
            System.out.println("Error parsing input : " + input);
            System.exit(1);
        }finally{
            sc.close();
        }
        evaluate(inputList);
    }

    public static Double calculate(double op1, double op2, char operator){
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                if (op1 == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return op2 / op1;
        }
        return 0.0;
    }
    public static void evaluate(List<String> expressionList) {

        for (String expression : expressionList) {
            // Treat space as separator
            String input[] = expression.split(" ");
            Stack<Double> stack = new Stack<>();

            boolean isError = false;

            for (int index = input.length - 1; index >= 0; index--) {
                String element = input[index];
                try {
                    if (element.equals("*") || element.equals("/") || element.equals("+") || element.equals("-")) {
                        double s1 = stack.pop();
                        double s2 = stack.pop();
                        double temp = calculate(s2, s1, element.charAt(0));
                        stack.push(temp);
                    } else {
                        //if here means, its a digit or exponential value
                        //extract the characters and store it in num
                        double num = Double.parseDouble(element);
                        stack.push(num);
                    }
                } catch (Exception e) {
                    isError = true;
                    break;
                }
            }
            if (!isError && stack.size() == 1) {
                double result = stack.pop();
                DecimalFormat df = new DecimalFormat("####0.00");
                System.out.println(df.format(result));
            } else
                System.out.println("error");
        }
    }

}
