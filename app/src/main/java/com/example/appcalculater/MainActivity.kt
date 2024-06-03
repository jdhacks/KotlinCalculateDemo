package com.example.appcalculater

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.appcalculater.databinding.ActivityMainBinding
import com.example.appcalculater.ui.theme.AppCalculaterTheme
import com.example.appcalculater.viewModels.NumberViewModel

// MainActivity.kt

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NumberViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(NumberViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.intersection.observe(this, { intersection ->
            binding.intersectionTextView.text = intersection
        })

        viewModel.union.observe(this, { union ->
            binding.unionTextView.text = union
        })

        viewModel.highestNumber.observe(this, { highestNumber ->
            binding.highestNumberTextView.text = "Highest Number: ${highestNumber ?: 0}"
        })
        binding.calculateButton.setOnClickListener {
            val input1 = binding.editText1.text.toString().split(",").map { it.toInt() }
            val input2 = binding.editText2.text.toString().split(",").map { it.toInt() }
            val input3 = binding.editText3.text.toString().split(",").map { it.toInt() }

            viewModel.calculateIntersectionUnion(input1, input2, input3)
        }
    }
}