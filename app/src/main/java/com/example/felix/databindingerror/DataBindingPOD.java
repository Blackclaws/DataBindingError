package com.example.felix.databindingerror;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.view.View;


// TODO: Add a class header
public class DataBindingPOD extends BaseObservable {
    public final ObservableBoolean testBool = new ObservableBoolean();
}
