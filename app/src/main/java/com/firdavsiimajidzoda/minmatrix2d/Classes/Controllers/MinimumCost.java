package com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firdavsiimajidzoda.minmatrix2d.Classes.Model.Cell;
import com.firdavsiimajidzoda.minmatrix2d.Classes.Utils.AutoResizeTextView;
import com.firdavsiimajidzoda.minmatrix2d.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  MinimumCost class to be an Adapter for GridView in DisplayActivity.class
 *  Performs actions as constructing calculated matrix, minimum cost and path.
 */
public class MinimumCost extends BaseAdapter {
    private Context context;

    // Filds and outlest
    private TextView gotThroughTextView;
    private TextView minPathTextView;
    private TextView minCostValueTextView;

    // Matrix
    private int givenMatrix[][];
    private Cell calculateMatrix[][];
    private int matrixSizeRow;
    private int matrixSizeColumn;

    private ArrayList<Cell> path;
    private int minimumCost;
    private String minimumCostPath;
    private ArrayList<Integer> pathIntegersRow;
    private String gotThrough;

    private float cellSize;


    // Constructor
    public MinimumCost(Context context, int matrix[][], float cellSize, TextView gotThroughTextView, TextView minPathTextView, TextView minCostValueTextView){
        // Constructing and initializing fields
        this.context = context;

        givenMatrix = matrix;
        matrixSizeRow = givenMatrix.length;
        matrixSizeColumn = givenMatrix[0].length;


        this.cellSize = cellSize;
        this.gotThroughTextView = gotThroughTextView;
        this.minPathTextView = minPathTextView;
        this.minCostValueTextView = minCostValueTextView;

        gotThrough = "NO";
        minimumCost = 0;
        minimumCostPath = "";

        calculateMatrix = new Cell[matrixSizeRow][matrixSizeColumn];
        path = new ArrayList<Cell>();
        pathIntegersRow =  new ArrayList<Integer>();

        if (matrixSizeColumn != 0){
            // Copy first column of the righ of given matrix to constructed matrix
            copyFirstColumn();

            // Constructing the rest of the matrix
            constructMatrix();

            findMinimumInColumn();
            calculatePath();
            getMinCostPath();
        }

    }

    public int getMinimumCost() {
        return minimumCost;
    }

    public String getMinimumCostPath() {
        for (int i: pathIntegersRow){
            minimumCostPath += i+" ";
        }
        return minimumCostPath;
    }

    public String getGotThrough() {
        return gotThrough;
    }

    /**
     *  Copy the first column on the right from given Matrix to a constructing Matrix to prepare for calculation of the following columns
     */
    private void copyFirstColumn(){
        // Iterating through last column's rows
        for (int i = matrixSizeRow-1; i >=0; i-- ){
            //Creating a new cell in particuar index
            calculateMatrix[i][0] = new Cell(i, 0);

            // Set Cell's value in constructed value from copying givenMatrix value in particlura index
            calculateMatrix[i][0].setValue(givenMatrix[i][0]);
        }
    }


    /**
     * Constructing Converted Matrix based on given Matrix (currentValue + min(Top, straight, bottom))
     */
    private void constructMatrix(){
        // Iterating through the columns (skipping the 1st)
        for (int column = 1; column < matrixSizeColumn; column++){
            // Iterating though rows
            for (int row = 0; row < matrixSizeRow; row++){
                //Creating a new cell in particuar index
                calculateMatrix[row][column] = new Cell(row, column);

                // Setting reverseTop cell for this Cell
                calculateMatrix[row][column].setReverseTop(calculateMatrix[findReverseTopForNextCell(row)][column - 1]);

                // Setting reverseStraight cell for this Cell
                calculateMatrix[row][column].setReverseStraight(calculateMatrix[row][column - 1]);

                // Setting reverseBottom cell for this Cell
                calculateMatrix[row][column].setReverseBottom(calculateMatrix[findReverseBottomForNextCell(row)][column - 1]);

                // Calculate the value and set the Cell's value
                calculateMatrix[row][column].calculateValue(givenMatrix[row][column]);
            }
        }
    }

    /**
     * Wrap up if row is on the very top
     * @param row
     * @return wrapped row number
     */
    private int findReverseTopForNextCell(int row){
        return row == 0? matrixSizeRow - 1: row - 1;
    }

    /**
     * Wrap up if row is on the very bottom
     * @param row
     * @return wrapped row number
     */
    private int findReverseBottomForNextCell(int row){
        return row == matrixSizeRow - 1? 0: row + 1;
    }

    /**
     * Find minimum value in the first most right column
     */
    private void findMinimumInColumn(){
        // First cell set to be the min
        Cell min = calculateMatrix[0][matrixSizeColumn-1];

        // Iterating through the row for given column
        for (int row = 1; row < matrixSizeRow; row++) {
            // Finding the moinimum value of 3 cells
            min = calculateMatrix[row][matrixSizeColumn - 1].getValue() < min.getValue() ? calculateMatrix[row][matrixSizeColumn - 1] : min;
        }

        // Add the found min to the path
        path.add(min);

    }

    // Calculate path from right to left
    private void calculatePath(){
        // The last Cell in path is minimum value
        int column = path.get(0).getPositionColumn();

        // Loop through the coloumn at index 0
        while (column != 0){
            // finding the minimum value from three Top, straight and bottm cells for each cell
            Cell minimum = getMinValue(new Cell[]{path.get(0).getReverseTop(), path.get(0).getReverseStraight(), path.get(0).getReverseBottom()});

            // Add found minimum to the path
            path.add(0, minimum);

            // Change condition for loop
            column = minimum.getPositionColumn();
        }
    }

    // Find minimum value from array of integers
    private Cell getMinValue(Cell[] array) {
        Cell minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].getValue() < minValue.getValue()) {
                minValue = array[i];
            }
        }
        return minValue;
    }

    /**
     *  Get the minimum cost path
     */
    public void getMinCostPath(){
        for (int i = 0; i < path.size(); i++){
            // Break the process if value exceeds 50
            if (path.get(i).getValue() > 50){
                gotThrough = "NO";
                break;
            }

            // Get value of the cell
            minimumCost = path.get(i).getValue();
            gotThrough = "YES";

            // Add the row
            if (i == path.size()-1){
                minimumCostPath += path.get(i).getPositionRow()+1+"";
            } else {
                if (path.get(i+1).getValue() < 50){
                    minimumCostPath += path.get(i).getPositionRow()+1+" ";
                } else {
                    minimumCostPath += path.get(i).getPositionRow()+1+"";
                }
            }

        }


    }

    @Override
    public int getCount() {
        return matrixSizeColumn*matrixSizeRow;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Getting index of an element based on its position in GridView
        int row = (position)/matrixSizeColumn;
        int column = (position - (row+1)*matrixSizeColumn)+matrixSizeColumn;

        // Convert the view as a TextView
        AutoResizeTextView cellTextView = new AutoResizeTextView(context);

        // set the TextView text color (GridView item color)
        cellTextView.setTextColor(Color.WHITE);

        // Set the layout parameters for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        cellTextView.setLayoutParams(lp);

        // Get the TextView LayoutParams
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) cellTextView.getLayoutParams();

        // Set the width of TextView (item of GridView)
        params.width = (int)cellSize -15;

        // Set the TextView height (GridView item/row equal height)
        params.height = (int)cellSize -15;

        // Set the TextView layout parameters
        cellTextView.setLayoutParams(params);

        // Display TextView text in center position
        cellTextView.setGravity(Gravity.CENTER);

        // Set the TextView text font family and text size
        cellTextView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
//        cellTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

        // Set the TextView text (GridView item text)
        cellTextView.setText(""+givenMatrix[row][column]);

        // Set the TextView background
        cellTextView.setBackgroundResource(R.drawable.regular_cell_shape);

        // Iterate through through the constructed path to indicate the color for found cells
        for (Cell cell: path){
            // If current cell is incuded in path
            if (row == cell.getPositionRow() && column == cell.getPositionColumn()){
                // Breake if the minimu value exceeds 50
                if (cell.getValue() > 50){
                    gotThrough = "NO";
                    break;
                }

                // Set the cell as part of path
                gotThrough = "YES";
                cellTextView.setBackgroundResource(R.drawable.selected_cell_shape);
                return  cellTextView;
            }

            // Include the cell in the path and update display result
            gotThroughTextView.setTextColor(Color.WHITE);
            gotThroughTextView.setText("All the way through: "+gotThrough);
            gotThroughTextView.setBackgroundResource(R.drawable.text_view_shape);

            minCostValueTextView.setTextColor(Color.WHITE);
            minCostValueTextView.setText("Minimum value: "+minimumCost);
            minCostValueTextView.setBackgroundResource(R.drawable.text_view_shape);

            minPathTextView.setText("Path: "+minimumCostPath);
            minPathTextView.setTextColor(Color.WHITE);
            minPathTextView.setBackgroundResource(R.drawable.text_view_shape);
        }

        // Return the TextView as GridView item
        return cellTextView;

    }
}
