package com.task.uran.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.model.entities.Exhibit
import com.task.model.loader.ExhibitsLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(exhibitsLoader: ExhibitsLoader) : ViewModel() {

    private val _dataLD = MutableLiveData<List<Exhibit>>()
    val dataLD: LiveData<List<Exhibit>> get() = _dataLD

    private val _emptyDataLD = MutableLiveData<List<Exhibit>>()
    val emptyDataLD: LiveData<List<Exhibit>> get() = _emptyDataLD

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val dataList = exhibitsLoader.getExhibitList()
            withContext(Dispatchers.Main) {
                if (dataList.isEmpty()) {
                    _emptyDataLD.value = dataList
                } else {
                    _dataLD.value = dataList
                }
            }
        }
    }
}