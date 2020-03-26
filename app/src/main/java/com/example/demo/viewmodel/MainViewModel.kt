package com.example.demo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
     val editTextContent = MutableLiveData<String>()

    fun getInputBoxVal():String{
        val inputVal = editTextContent.value+""
        if(!inputVal.equals("null",  true)){
            return inputVal;
        }else
            return "";

    }

    /*********
     * preparing list item for adapters
     */
      fun prepareAndBindToList(): List<String> {
          val value:String = getInputBoxVal();
        val itemList = ArrayList<String>()
        for (w in value.indices) {
            itemList.add(value[w]+"")
        }
        return itemList;
    }


}