package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firdavsiimajidzoda.minmatrix2d.Classes.Controllers.Matrix;
import com.firdavsiimajidzoda.minmatrix2d.R;

/**
 *  SetMatrixActivity to let the user choose the matrix size and pass the details to and open FillMatrixActivity.class
 */
public class SetMatrixActivity extends AppCompatActivity {

    // Binding views and outlets
    private TextView promptTextView;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_matrix);

        // Initializing views
        promptTextView = (TextView)findViewById(R.id.set_matrix_promt_text_view);
        nextButton = (Button)findViewById(R.id.set_matrix_show_result_button);

        // Initialize matrix-GridView and configure the size to fit the Grid in the screen
        final RelativeLayout gridParentLayout = (RelativeLayout)findViewById(R.id.set_matrix_grid_container);
        gridParentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setGridView(gridParentLayout.getWidth());
                gridParentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    /**
     * Initialize GridView for matrix and set the adapter
     * @param width to calculate the screen size and make GridView fir the screen properly
     */
    private void setGridView(float width){
        // Initialize GridView
        GridView gridView = (GridView)findViewById(R.id.set_matrix_grid_view);

        // Creating Matrix - adapter for GridView
        Matrix matrix = new Matrix(this, width/10, promptTextView, nextButton);

        // Set GridView column width to matrix column
        gridView.setColumnWidth((int) (width/10));

        // Set number of GtidView column to matrix column
        gridView.setNumColumns(10);

        // Set GridView adapter
        gridView.setAdapter(matrix);
    }
}
