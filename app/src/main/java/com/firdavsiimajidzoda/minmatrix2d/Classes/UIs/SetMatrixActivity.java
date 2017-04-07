package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;

import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.firdavsiimajidzoda.minmatrix2d.R;

/**
 *  SetMatrixActivity to let the user choose the matrix size and pass the details to and open FillMatrixActivity.class
 */
public class SetMatrixActivity extends AppCompatActivity {

    // Binding views and outlets
    private TextView promptTextView;

    private EditText rowEditText;
    private EditText columnEditText;

    private Button nextButton;

    private int row;
    private int column;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_matrix);

        // Initializing views
        promptTextView = (TextView)findViewById(R.id.set_matrix_promt_text_view);
        promptTextView.setBackgroundResource(R.drawable.regular_cell_shape);

        rowEditText = (EditText)findViewById(R.id.set_matrix_row_edit_text);
        rowEditText.setBackgroundResource(R.drawable.regular_cell_shape);
        rowEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        rowEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        rowEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    row = Integer.parseInt(rowEditText.getText().toString());
                    validateNextButton();
                } catch (Exception exception){

                }

            }
        });

        columnEditText = (EditText)findViewById(R.id.set_matrix_column_edit_text);
        columnEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
        columnEditText.setBackgroundResource(R.drawable.regular_cell_shape);
        columnEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        columnEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    column = Integer.parseInt(columnEditText.getText().toString());
                    validateNextButton();
                } catch (Exception exception){

                }
            }
        });

        nextButton = (Button)findViewById(R.id.set_matrix_show_result_button);
        nextButton.setBackgroundResource(R.drawable.selected_cell_shape);
        nextButton.setEnabled(false);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fillMatrixIntent = new Intent();
                Bundle b = new Bundle();
                b.putInt("matrixSizeRow", row);
                b.putInt("matrixSizeColumn", column);
                fillMatrixIntent.putExtras(b);
                fillMatrixIntent.setClass(getApplicationContext(), FillMatrixActivity.class);
                startActivity(fillMatrixIntent);
                finish();
            }
        });


//        // Initialize matrix-GridView and configure the size to fit the Grid in the screen
//        final RelativeLayout gridParentLayout = (RelativeLayout)findViewById(R.id.set_matrix_grid_container);
//        gridParentLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                setGridView(gridParentLayout.getWidth());
//                gridParentLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//            }
//        });
    }

    private void validateNextButton(){
        if (!rowEditText.getText().toString().matches("") && !columnEditText.getText().toString().matches("")){
            try {
                if (Integer.parseInt(rowEditText.getText().toString()) != 0 && Integer.parseInt(columnEditText.getText().toString()) != 0){
                    nextButton.setEnabled(true);
                    nextButton.setBackgroundResource(R.drawable.regular_cell_shape);
                } else {
                    nextButton.setEnabled(false);
                    nextButton.setBackgroundResource(R.drawable.selected_cell_shape);
                }
            }catch (Exception exception){
                Toast.makeText(this, "Only number allowed", Toast.LENGTH_SHORT).show();
                nextButton.setEnabled(false);
                nextButton.setBackgroundResource(R.drawable.selected_cell_shape);
            }

        } else {
            nextButton.setEnabled(false);
            nextButton.setBackgroundResource(R.drawable.selected_cell_shape);
        }
    }


}
