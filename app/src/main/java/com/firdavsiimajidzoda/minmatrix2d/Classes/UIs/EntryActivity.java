package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

/**
 * Created by firdavsiimajidzoda on 4/05/17.
 */

import com.firdavsiimajidzoda.minmatrix2d.R;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 *  EntryActivity is to determain where user wnats to see examples or inptut matrix data
 */
public class EntryActivity extends AppCompatActivity {
    // Binding views and outlets
    private Button seeExamplesButton;
    private Button inputMatrixGUIButton;
    private Button inputMatrixManuallyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        // Initializing views
        seeExamplesButton = (Button)findViewById(R.id.seeExamplesButton);
        seeExamplesButton.setBackgroundResource(R.drawable.regular_cell_shape);
        seeExamplesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent examplesActivityIntent = new Intent();
                examplesActivityIntent.setClass(getApplicationContext(), ExamplesActivity.class);
                startActivity(examplesActivityIntent);
                finish();
            }
        });


        inputMatrixGUIButton = (Button)findViewById(R.id.inputMatrixGUIButton);
        inputMatrixGUIButton.setBackgroundResource(R.drawable.selected_cell_shape);
        inputMatrixGUIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setMatrixIntent = new Intent();
                setMatrixIntent.setClass(getApplicationContext(), SetMatrixActivity.class);
                startActivity(setMatrixIntent);
                finish();
            }
        });
    }
}
