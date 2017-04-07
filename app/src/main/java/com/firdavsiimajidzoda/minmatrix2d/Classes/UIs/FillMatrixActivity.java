package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers.FillMatrix;
import com.firdavsiimajidzoda.minmatrix2d.R;

import static android.view.View.MeasureSpec.EXACTLY;

/**
 * FillMatrixActivity to fill the Matrix values and pass the Matrix data to DisplayActivity.class
 */
public class FillMatrixActivity extends AppCompatActivity{
    // Binding views and outlets
    private TextView promptTextView;
    private Button showResultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_matrix);

        // Initializing views
        promptTextView = (TextView)findViewById(R.id.fill_matrix_promt_text_view);
        promptTextView.setBackgroundResource(R.drawable.regular_cell_shape);
        promptTextView.setTextColor(Color.WHITE);
        showResultButton = (Button)findViewById(R.id.fill_matrix_show_result_button);

        // Getting data from bundle that been passed from SetMatrixActivity.class (Matrix size)
        Bundle bundle = this.getIntent().getExtras();
        final int row = bundle.getInt("matrixSizeRow");
        final int column = bundle.getInt("matrixSizeColumn");

        // Initialize matrix-GridView and configure the size to fit the Grid in the screen
        final RelativeLayout gridParentLayout = (RelativeLayout) findViewById(R.id.fill_matrix_grid_container);
        gridParentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setGridView(gridParentLayout.getWidth(), row, column);
                gridParentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /**
     * Initialize GridView for matrix and set the adapter
     * @param width to calculate the screen size and make GridView fir the screen properly
     * @param row size for Matrix
     * @param column size for Matrix
     */
    private void setGridView(float width, int row, int column){
        // Calculate the longest side of the Matrix to feet in screen
        int cellSize;
        if (row > column){
            cellSize = row;
        } else {
            cellSize = column;
        }

        // Initialize GridView
        GridView gridView = (GridView)findViewById(R.id.fill_matrix_grid_view);

        // Creating FillMatrix - adapter for GridView
        FillMatrix fillMatrix = new FillMatrix(this, width/6, row, column, showResultButton);

        // Set GridView column width to matrix column
        gridView.setColumnWidth((int) (width/6));

        // Set number of GtidView column to matrix column
        gridView.setNumColumns(column);

        // Set GridView adapter
        gridView.setAdapter(fillMatrix);

        // Set gridView adapter to ListAdapter. Enabling horizontal scrolling
        setDynamicWidth(gridView, column);


    }

    /**
     * Measuring width of grid view and seting it's adapter to ListAdapter to make GridView enable for horizontal scrolling
     * @param gridView
     * @param column
     */
    private void setDynamicWidth(GridView gridView, int column) {
        // Initializing ListAdapter from GridView BaseAdapter
        ListAdapter gridViewAdapter = gridView.getAdapter();
        if (gridViewAdapter == null) {
            return;
        }

        int totalWidth;

        // Getting a first cell
        View listItem = gridViewAdapter.getView(0, null, gridView);

        // Measuring the with of GridView
        listItem.measure(0,0);
        totalWidth = listItem.getMeasuredWidth()+160;
        totalWidth = totalWidth*column;

        // Setting new params
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        params.width = totalWidth;
        gridView.setLayoutParams(params);
    }
}

