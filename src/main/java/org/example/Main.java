package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] countEvens = {2, 1, 2, 3, 4};
        int[] countEvens1 = {2, 2, 0};
        int[] countEvens2 = {1, 3, 5};
        int[] countEvens3 = {1, 3, 5, 8, 0, 5, 0, 6, 0, 0}; // Для проверки задания №3

        // Массив массивов, чтобы не применять методы отдельно к каждому массиву
        int[][] arrayOfIntArrays = {countEvens, countEvens1, countEvens2, countEvens3};

        // Массив строкового предстваления массивов для вывода на экран
        String[] arrayOfStringArrays = new String[arrayOfIntArrays.length];
        for (int i = 0; i < arrayOfIntArrays.length; i++) {
            arrayOfStringArrays[i] = Arrays.toString(arrayOfIntArrays[i]);
        }

        // Задача 1.
        System.out.println("""
                
                -----------------------------------------------------
                
                1. Количество чётных элементов массива:
                """);

        for (int i = 0; i < arrayOfIntArrays.length; i++) {
            System.out.print(numberOfEvenNumbersInTheArray(arrayOfIntArrays[i]));
            System.out.println("    для массива " + arrayOfStringArrays[i]);
        }


        // Задача 2.
        System.out.println("""
                           
                           -----------------------------------------------------
                           
                           2. Разница между самым большим и самым маленьким
                           элементами переданного не пустого массива:
                           """);

        for (int i = 0; i < arrayOfIntArrays.length; i++) {
            System.out.print(
                    differenceNumbers(
                            maxNumInArray(arrayOfIntArrays[i]),
                            minNumInArray(arrayOfIntArrays[i])
                    )
            );
            System.out.println("    для массива " + arrayOfStringArrays[i]);
        }


        // Задача 3.
        System.out.println("""
                           
                           -----------------------------------------------------
                           
                           3. Наличие в переданном массиве
                           двух соседних элементов, с нулевым значением
                           """);

        for (int i = 0; i < arrayOfIntArrays.length; i++) {
            System.out.print(presenceOfTwoAdjacentZeroValues(arrayOfIntArrays[i]));
            System.out.println("    для массива " + arrayOfStringArrays[i]);
        }

    }


    // Методы для задачи №1

    /**
     * Подсчет количества четных чисел в массиве int[]
     * @param intArray массив целых чисел int[]
     * @return количество четных чисел в массиве
     */
    public static int numberOfEvenNumbersInTheArray (int[] intArray) {
        int count = 0;
        for (int i : intArray) {
            count += evenFlag(i) ? 1 : 0;
        }
        return count;
    }

    /**
     * Проверка четное ли число
     * @param num число, которое проверяет
     * @return true - число четное; false - нечетное
     */
    public static Boolean evenFlag (int num) {
        return num % 2 == 0;
    }


    // Методы для задачи №2

    /**
     * Нахождение минимального числа int в массиве int[]
     * @param intArray целочисленный массив int[]
     * @return минимальное значение в массиве
     */
    public static Integer minNumInArray (int[] intArray) {
        int minNum = intArray[0];
        for (int i : intArray) {
            if (i < minNum) {
                minNum = i;
            }
        }
        return minNum;
    }

    /**
     * Нахождение максимального числа int в массиве int[]
     * @param intArray целочисленный массив int[]
     * @return максимальное значение в массиве
     */
    public static Integer maxNumInArray (int[] intArray) {
        int maxNum = intArray[0];
        for (int i : intArray) {
            if (i > maxNum) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    /**
     * Разность двух чисел
     * @param num1 первое число int
     * @param num2 второе число int
     * @return разность чисел num1 и num2
     */
    public static Integer differenceNumbers (int num1, int num2) {
        return num1 - num2;
    }


    // Методы для задачи №3

    /**
     * Проверка на наличие двух соседних нулевых значений
     * @param intArray целочисленный массив int[]
     * @return true - наличие как минимум 2-х соседних нулевых значений;
     *         false - нет нулевых соведних значений
     */
    public static boolean presenceOfTwoAdjacentZeroValues (int[] intArray) {
        boolean flag = false;
        for (int i = 1; i < intArray.length; i++) {
            if (intArray[i] == 0 && intArray[i - 1] == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}