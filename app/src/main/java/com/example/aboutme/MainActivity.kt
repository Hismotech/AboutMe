package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val myName:MyName = MyName("Elon Musk")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName
       binding.doneButton.setOnClickListener{
           showNickname(it)
       }
    }
    private fun showNickname(view:View){
        binding.apply {
            myName?.nickname = edit_name.text.toString()
            invalidateAll()
            edit_name.visibility = View.GONE
            nickname_text.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
        }
        val hideTheKeyboard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hideTheKeyboard.hideSoftInputFromWindow(view.windowToken,0)
    }
}
