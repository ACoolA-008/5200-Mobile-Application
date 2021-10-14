package edu.neu.hm3.todolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;

public class ToDoItemView extends ConstraintLayout {
    public ToDoItemView(@NonNull Context context) {
        super(context);
        setupView(context);
    }

    public ToDoItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context);
    }

    public ToDoItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs,defStyle);
        setupView(context);
    }

    private void setupView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.to_do_item_view,this,true);
    }
}
