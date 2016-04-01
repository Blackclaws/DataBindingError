package com.example.felix.databindingerror;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;

import java.lang.ref.WeakReference;

public class TwoWayCheckBox extends CheckBox {

    WeakReference<ObservableBoolean> boundBoolean;
    boolean notifying = false;

    public TwoWayCheckBox(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public void setBoundBoolean(View view, ObservableBoolean value)
    {
        boundBoolean = new WeakReference<ObservableBoolean>(value);
        setChecked(value.get());
    }

    @Override
    public boolean performClick()
    {
        boolean handled = super.performClick();
        if(!notifying) {
            notifying = true;
            if(boundBoolean.get() != null)
            {
                boundBoolean.get().set(isChecked());
            }
            notifying = false;
        }
        return handled;
    }
}
