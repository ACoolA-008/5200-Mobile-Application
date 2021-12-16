package edu.neu.hm3.todolibrary.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.versionedparcelable.ParcelImpl;

public class SharedViewModel extends ViewModel {

    private Boolean Update;

    public Boolean getUpdate() {
        return Update;
    }

    public void setUpdate(Boolean update) {
        this.Update = update;
    }

    private final MutableLiveData<Task> aItemSelected = new MutableLiveData<>();
    public void selectItem(Task task) {
        aItemSelected.setValue(task);
    }

    public LiveData<Task> getItem(){
        return aItemSelected;
    }
}
