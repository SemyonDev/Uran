package com.task.uran.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.task.uran.R
import com.task.uran.ui.adapters.ExhibitListAdapter
import com.task.uran.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

  private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val exhibitListAdapter = ExhibitListAdapter()

        activity_main_rv.run {
            adapter = exhibitListAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.dataLD.observe(this, Observer {
            exhibitListAdapter.setData(it)
        })

        viewModel.emptyDataLD.observe(this, Observer {
            Toast.makeText(this, "emptyDataLD", Toast.LENGTH_LONG).show()
        })
    }
}
