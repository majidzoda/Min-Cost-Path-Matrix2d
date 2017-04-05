package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers.MinimumCost;
import com.firdavsiimajidzoda.minmatrix2d.R;

/**
 *  DisplayActivity to calculate and display the result to the user
 */
public class DisplayActivity extends AppCompatActivity {
    // Binding views and outlets
    private TextView gotThroughTextView;
    private TextView minPathTextView;
    private TextView minCostValue;
    private Button refreshButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        // Initializing views
        gotThroughTextView = (TextView)findViewById(R.id.got_through);
        minPathTextView = (TextView)findViewById(R.id.min_cost_path);
        minCostValue = (TextView)findViewById(R.id.min_cost_value);

        refreshButton = (Button)findViewById(R.id.refreshButton);
        refreshButton.setBackgroundResource(R.drawable.selected_cell_shape);
        refreshButton.setText(Html.fromHtml("&#x21ba;"));
        refreshButton.setTextColor(Color.WHITE);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entryActivityIntent = new Intent();
                entryActivityIntent.setClass(getApplicationContext(), EntryActivity.class);
                startActivity(entryActivityIntent);
                finish();
            }
        });

        // Getting data from bundle that been passed from FillMatrixActivity.class (Matrix input)
        Bundle bundle = this.getIntent().getExtras();
        final int matrix [][] = (int[][]) bundle.getSerializable("matrix");

        // Initialize matrix-GridView and configure the size to fit the Grid in the screen
        final RelativeLayout gridParentLayout = (RelativeLayout)findViewById(R.id.grid_container);
        gridParentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setGridView(gridParentLayout.getWidth(), matrix);
                gridParentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }


    /**
     * Initialize GridView for matrix and set the adapter
     * @param width to calculate the screen size and make GridView fir the screen properly
     * @param m matrix with given data input
     */
    public void setGridView(float width, int [][] m){
        // Calculate the longest side of the Matrix to feet in screen
        int cellSize;
        if (m.length > m[0].length){
            cellSize = m.length;
        } else {
            cellSize = m[0].length;
        }

        // Initialize GridView
        GridView gridView = (GridView)findViewById(R.id.gridview);

        // Creating MinimumCost - adapter for GridView
        MinimumCost minimumCost = new MinimumCost(this, m, width/cellSize, gotThroughTextView, minPathTextView, minCostValue);

        // Set GridView column width to matrix column
        gridView.setColumnWidth((int) (width/m[0].length));

        // Set number of GtidView column to matrix column
        gridView.setNumColumns(m[0].length);

        // Set GridView adapter
        gridView.setAdapter(minimumCost);
    }
}

