package com.firdavsiimajidzoda.minmatrix2d.Classes.UIs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.firdavsiimajidzoda.minmatrix2d.Classes.Utils.ConstantData;
import com.firdavsiimajidzoda.minmatrix2d.R;


/**
 *  ExamplesActivity let user to choose an example
 */
public class ExamplesActivity extends AppCompatActivity {
    // Binding views and outlets
    private Button exampleOneButton;
    private Button exampleTwoButton;
    private Button exampleThreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples);

        // Initializing views
        exampleOneButton = (Button)findViewById(R.id.exampleOneButton);
        exampleOneButton.setBackgroundResource(R.drawable.regular_cell_shape);
        exampleOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fillDisplayIntent = new Intent();
                Bundle b = new Bundle();
                b.putSerializable("matrix", ConstantData.scenario1.matrix);
                fillDisplayIntent.putExtras(b);
                fillDisplayIntent.setClass(getApplicationContext(), DisplayActivity.class);
                startActivity(fillDisplayIntent);
                finish();
            }
        });

        exampleTwoButton = (Button)findViewById(R.id.exampleTwoButton);
        exampleTwoButton.setBackgroundResource(R.drawable.selected_cell_shape);
        exampleTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fillDisplayIntent = new Intent();
                Bundle b = new Bundle();
                b.putSerializable("matrix", ConstantData.scenario2.matrix);
                fillDisplayIntent.putExtras(b);
                fillDisplayIntent.setClass(getApplicationContext(), DisplayActivity.class);
                startActivity(fillDisplayIntent);
                finish();
            }
        });

        exampleThreeButton = (Button)findViewById(R.id.exampleThreeButton);
        exampleThreeButton.setBackgroundResource(R.drawable.regular_cell_shape);
        exampleThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fillDisplayIntent = new Intent();
                Bundle b = new Bundle();
                b.putSerializable("matrix", ConstantData.scenario3.matrix);
                fillDisplayIntent.putExtras(b);
                fillDisplayIntent.setClass(getApplicationContext(), DisplayActivity.class);
                startActivity(fillDisplayIntent);
                finish();
            }
        });
    }
}
