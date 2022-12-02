package com.example.mvvm_example.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_example.pojo.Model;

//This class present the ViewModel in the (MVVM Architecture Pattern)
public class ProductViewModel extends ViewModel {


   public MutableLiveData<String> productNameMutableLiveData = new MutableLiveData<>();

    public void getProductName(){
        String productName = getProductFromDatabase().getName();
        productNameMutableLiveData.setValue(productName);
    }

    private Model getProductFromDatabase(){
        return new Model(1,"Milk","5$","Drink");
    }
}
