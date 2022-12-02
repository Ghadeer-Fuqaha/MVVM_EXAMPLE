package com.example.mvvm_example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvm_example.R;

public class MainActivity extends AppCompatActivity{

    //The MainActivity (Java Class) present the controller in (MVC Architecture)

    public TextView txt;
    public Button btn;
    ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        //after executing onClick method we will receive the value of name using mutableLiveData
        //by observer method
        productViewModel.productNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //when the value of mutableLive Data changed
                //the value will be displayed into TextView

                txt.setText(s);
            }
        });

        //by using this keyword we refer the Interface that
        //Implemented inside this activity


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productViewModel.getProductName();

            }
        });




    }

}