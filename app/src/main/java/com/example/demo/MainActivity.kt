package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.adapter.InputTextItemAdapter
import com.example.demo.databinding.ActivityMainBinding
import com.example.demo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

/*********
 * MainClass to represent view - Bankesh
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this)
            .get(MainViewModel::class.java)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel = mainViewModel
        }

        btnClick.setOnClickListener(View.OnClickListener {
            bindAdapter(mainViewModel.prepareAndBindToList())
        })
    }

    /************
     * Binding Adapter To recylerview
     */
    private fun bindAdapter(inputList: List<String>){
        recylerView.adapter= InputTextItemAdapter(inputList)
        recylerView.layoutManager= LinearLayoutManager(this)
    }

}
