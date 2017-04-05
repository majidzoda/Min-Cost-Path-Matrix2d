package com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers;

/**
 * Created by firdavsiimajidzoda on 4/5/17.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firdavsiimajidzoda.minmatrix2d.Classes.UIs.FillMatrixActivity;
import com.firdavsiimajidzoda.minmatrix2d.Classes.UIs.SetMatrixActivity;
import com.firdavsiimajidzoda.minmatrix2d.R;

/**
 *  Matrix class to be an Adapter for GridView in SetMatrixActivity.class
 *  Performs actions as setting up a Matrix
 */
public class Matrix extends BaseAdapter {
    private Context context;

    // Views and outlets
    private TextView promptTextView;
    private Button nextButton;

    // Buttons array to collect references and configure colors
    private Button buttons [][];

    // Matrix details
    private int matrixSizeRow;
    private int matrixSizeColumn;
    private float cellSize;



    // Constructor
    public Matrix(Context context, float cellSize, TextView promptTextView, Button nextButton){
        // Constructing and initializing the fields
        this.context = context;
        this.promptTextView = promptTextView;
        this.promptTextView.setBackgroundResource(R.drawable.regular_cell_shape);
        this.nextButton = nextButton;
        configureNextButton();
        this.cellSize = cellSize;

        buttons = new Button[10][10];
        matrixSizeRow = 0;
        matrixSizeColumn = 0;

    }

    /**
     *  Configure Next Button text color and backgrund style
     */
    private void configureNextButton(){
        nextButton.setTextColor(Color.WHITE);
        nextButton.setBackgroundResource(R.drawable.selected_cell_shape);
        nextButton.setEnabled(false);
    }

    @Override
    public int getCount() {
        return 100;
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
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        // Getting index of an element based on its position in GridView
        final int row = (position)/10;
        final int column = (position - (row+1)*10)+10;

        // Convert the view as a Button
        final Button cellButton = new Button(context);

        // set the TextView text color (GridView item color)
        cellButton.setTextColor(Color.WHITE);

        // Set the layout parameters for Button
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT
        );
        cellButton.setLayoutParams(lp);

        // Get the Button LayoutParams
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) cellButton.getLayoutParams();

        // Set the width of Button  (item of GridView)
        params.width = (int)cellSize -15;

        // Set the Button height (GridView item/row equal height)
        params.height = (int)cellSize -15;



        // Set the Button layout parameters
        cellButton.setLayoutParams(params);


        // Display Button text in center position
        cellButton.setGravity(Gravity.CENTER);

        // Set the Button text font family and text size
        cellButton.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
        cellButton.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);

        // Set the Button text (GridView item text)
        cellButton.setText((row+1)+"x"+(column+1));

        // Add Button (GridView item) to buttons array
        buttons[row][column] = cellButton;

        // Set the Button background color
        cellButton.setBackgroundResource(R.drawable.regular_cell_shape);

        // Set on clicl action on Button click
        cellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iterating through columns
                for (int c = 0; c <= column; c++ ){
                    // Iterating through rows
                    for (int r = 0; r <= row; r++){
                        // Change buttons color to identifie user's matrix size choice
                        buttons[r][c].setBackgroundResource(R.drawable.selected_cell_shape);
                    }
                }

                // Building dialog box to confirm the size
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                alertDialogBuilder
                        .setMessage("Are you sure you want a matrix of "+(row+1)+"x"+(column+1))
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // Set matrix size details
                                matrixSizeRow = row+1;
                                matrixSizeColumn = column+1;

                                // Enableing button for next process
                                nextButton.setEnabled(true);
                                nextButton.setBackgroundResource(R.drawable.regular_cell_shape);
                            }
                        }).setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {

                        // Changing colors back to regular when user canceled confirmation

                        // Iterating through columns
                        for (int c = 0; c <= column; c++ ){
                            // Iterating through rows
                            for (int r = 0; r <= row; r++){
                                // Changing button background back to blue
                                buttons[r][c].setBackgroundResource(R.drawable.regular_cell_shape);
                            }
                        }

                        // Disable next button and change the background
                        nextButton.setBackgroundResource(R.drawable.selected_cell_shape);
                        nextButton.setEnabled(false);
                        dialog.cancel();
                    }
                });

                // Create and show the dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fillMatrixIntent = new Intent(context,SetMatrixActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle b = new Bundle();
                b.putInt("matrixSizeRow", matrixSizeRow);
                b.putInt("matrixSizeColumn", matrixSizeColumn);
                fillMatrixIntent.putExtras(b);
                fillMatrixIntent.setClass(context, FillMatrixActivity.class);
                context.startActivity(fillMatrixIntent);
                ((SetMatrixActivity)context).finish();
            }
        });

        // Return the Button as GridView item
        return cellButton;
    }
}

