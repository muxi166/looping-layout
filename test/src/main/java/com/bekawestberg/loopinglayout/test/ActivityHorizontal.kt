/*
 * Copyright 2019 Looping Layout
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.bekawestberg.loopinglayout.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.bekawestberg.loopinglayout.library.LoopingLayoutManager
import com.bekawestberg.loopinglayout.library.LoopingSnapHelper
import com.bekawestberg.loopinglayout.library.TestSnapHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityHorizontal : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private var mAdapter: AdapterGeneric = AdapterGeneric(
            Array(100) { i -> i.toString()},
            Array(100) { i -> 750})
    private var mLayoutManager =
            LoopingLayoutManager(this, RecyclerView.HORIZONTAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v("LoopingLayoutManager", "test")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recycler)

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter
        /*mLayoutManager.smoothScrollDirectionDecider = ::addViewsAtOptAnchorEdge*/

        val snapHelper = LoopingSnapHelper()
        snapHelper.attachToRecyclerView(mRecyclerView)

        val button = findViewById<FloatingActionButton>(R.id.fab)
        button.setOnClickListener {
            mRecyclerView.scrollBy(250, 0)
            /*mAdapter.updateData(arrayOf("0", "1", "2"), Array(16) { i -> 250 })
            mAdapter.notifyDataSetChanged()*/
        }
    }
}
