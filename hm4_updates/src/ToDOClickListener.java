package edu.neu.hm3.todolibrary;

import edu.neu.hm3.todolibrary.model.Task;

public interface ToDOClickListener {
    void click(Task task);
    void checkBoxClick(Task task);
}
