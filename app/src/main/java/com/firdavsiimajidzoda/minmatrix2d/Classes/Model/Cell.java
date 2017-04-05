package com.firdavsiimajidzoda.minmatrix2d.Classes.Model;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */

public class Cell {
    // Fields
    private int value;

    private Cell reverseTop;
    private Cell reverseStraight;
    private Cell reverseBottom;

    private int positionRow;
    private int positionColumn;

    // Constructor
    public Cell(int row, int column){
        positionRow = row;
        positionColumn = column;
    }


    /**
     * Calculate to find the minimum from previous cell (top, straight, bottom) then add to the current cell value
     * @param originalValue to be added to a minimum
     */
    public void calculateValue(int originalValue){
        this.setValue(originalValue + getMinValue(new int[]{reverseTop.getValue(), reverseStraight.getValue(), reverseBottom.getValue()}));
    }

    /**
     * Find minimum from elements of an array
     * @param array to be searched for minimum element
     * @return minimum
     */
    private int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    // Setters and getters
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Cell getReverseTop() {
        return reverseTop;
    }

    public void setReverseTop(Cell reverseTop) {
        this.reverseTop = reverseTop;
    }

    public Cell getReverseStraight() {
        return reverseStraight;
    }

    public void setReverseStraight(Cell reverseStraight) {
        this.reverseStraight = reverseStraight;
    }

    public Cell getReverseBottom() {
        return reverseBottom;
    }

    public void setReverseBottom(Cell reverseBottom) {
        this.reverseBottom = reverseBottom;
    }

    public int getPositionRow() {
        return positionRow;
    }

    public int getPositionColumn() {
        return positionColumn;
    }

}


