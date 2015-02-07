package se.dennisahlin.workoff;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.LinearLayout;

public class CheckableLinearLayout extends LinearLayout implements Checkable {
    private CheckBox _checkbox;

    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        _checkbox = getCheckBox(this);
        if(_checkbox != null) _checkbox.setFocusable(false);
    }

    private CheckBox getCheckBox( ViewGroup parent ){
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; ++i ){
            View v = getChildAt(i);
            if (v instanceof CheckBox) return (CheckBox) v;
            if (v instanceof ViewGroup) return getCheckBox((ViewGroup) v);
        }
        return null;
    }

    @Override
    public void setChecked(boolean checked) {
        if(_checkbox == null) return;
        _checkbox.setChecked( checked );
    }

    @Override
    public boolean isChecked() {
        return _checkbox != null && _checkbox.isChecked();
    }

    @Override
    public void toggle() {
        if (_checkbox == null) return;
        _checkbox.toggle();
    }
}
