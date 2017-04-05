package com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;

import com.firdavsiimajidzoda.minmatrix2d.Classes.UIs.DisplayActivity;
import com.firdavsiimajidzoda.minmatrix2d.Classes.UIs.FillMatrixActivity;
import com.firdavsiimajidzoda.minmatrix2d.R;

/**
 *  FillMatrix class to be an Adapter for GridView in FillMatrixActivity.class
 *  Performs actions as input data to Matrix
 */
public class FillMatrix extends BaseAdapter {
    private Context context;

    // Views and outlets
    private Button showResultButton;

    // Matrix details
    private int matrix[][];
    private float cellSize;
    private int row;
    private int column;

    // Constructor
    public FillMatrix(Context context, float cellSize, int row, int column,  Button showResultButton){
        // Constructing and initializing fields
        this.context = context;

        this.matrix = new int[row][column];
        this.showResultButton = showResultButton;
        configureNextButton();

        this.cellSize = cellSize;
        this.row = row;
        this.column = column;

    }

    /**
     *  Configure Next Button text color and backgrund style
     */
    private void configureNextButton(){
        showResultButton.setTextColor(Color.WHITE);
        showResultButton.setBackgroundResource(R.drawable.regular_cell_shape);
    }

    @Override
    public int getCount() {
        return matrix.length*matrix[0].length;
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
        final int currentRow = (position)/column;
        final int currentColumn = (position - (currentRow+1)*column)+column;

        // Convert the view as a NumberPicker widget
        final NumberPicker cellNumberPicker = new NumberPicker(context);


        // Set the layout parameters for NumberPicker
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        );
        cellNumberPicker.setLayoutParams(lp);

        // Get the NumberPicker LayoutParams
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) cellNumberPicker.getLayoutParams();

        // Set the width of NumberPicker (item of GridView)
        params.width = (int)cellSize -15;

        // Set the NumberPicker height (GridView item/row equal height)
        params.height = (int)cellSize -15;



        // Set the NumberPicker layout parameters
        cellNumberPicker.setLayoutParams(params);


        // Display NumberPicker text in center position
        cellNumberPicker.setGravity(Gravity.CENTER);

        // Set the Button background color
        cellNumberPicker.setBackgroundResource(R.drawable.regular_cell_shape);

        // Configure NumberPicker min and max, wrapping, disable keyboard
        cellNumberPicker.setMinValue(0);
        cellNumberPicker.setMaxValue(99);
        cellNumberPicker.setWrapSelectorWheel(false);
        cellNumberPicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);



        // Set NumberPicker on click listener to set value to Matrix
        cellNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                matrix[currentRow][currentColumn] = newVal;
                cellNumberPicker.setBackgroundResource(R.drawable.selected_cell_shape);

            }
        });

        // Set showButton on click to intent pass the input data and open DisplayActivity.class
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fillDisplayIntent = new Intent(context,FillMatrixActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle b = new Bundle();
                b.putSerializable("matrix", matrix);
                fillDisplayIntent.putExtras(b);
                fillDisplayIntent.setClass(context, DisplayActivity.class);
                context.startActivity(fillDisplayIntent);
                ((FillMatrixActivity)context).finish();
            }
        });

        // Return the NumberPicker as GridView item
        return cellNumberPicker;

    }
}

