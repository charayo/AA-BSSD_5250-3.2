package com.example.aa_bssd_5250_32

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
     var noteCount = 0
    private var fid = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val addButton = Button(this).apply {
            text = "+"
            id = View.generateViewId()
            setOnClickListener{
                supportFragmentManager.commit {
                    if(noteCount < 10){
                        add(fid, NoteFragment.newInstance(), null)
                        noteCount ++
                    }
                }
            }
        }
        val fragmentLinearLayout = LinearLayoutCompat(this).apply {
            id = View.generateViewId()
            fid = id
            orientation = LinearLayoutCompat.VERTICAL
            setBackgroundColor(Color.LTGRAY)
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )

            (layoutParams as RelativeLayout.LayoutParams).addRule(
                RelativeLayout.BELOW, addButton.id)
        }
        val relativeLayout = RelativeLayout(this).apply {
            setBackgroundColor(Color.WHITE)
            addView(addButton)
            addView(fragmentLinearLayout)

        }
        setContentView(relativeLayout)

    }
}