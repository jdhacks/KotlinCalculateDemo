package com.example.appcalculater.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel() {
    private val _intersection = MutableLiveData<String>()
    val intersection: LiveData<String> get() = _intersection

    private val _union = MutableLiveData<String>()
    val union: LiveData<String> get() = _union

    private val _highestNumber = MutableLiveData<Int>()
    val highestNumber: LiveData<Int> get() = _highestNumber

    fun calculateIntersectionUnion(numbers1: List<Int>, numbers2: List<Int>, numbers3: List<Int>) {
        val intersection = numbers1.intersect(numbers2).intersect(numbers3)
        val union = numbers1.union(numbers2).union(numbers3)
        val highestNumber = (numbers1 + numbers2 + numbers3).max()

        _intersection.value = intersection.joinToString(", ")
        _union.value = union.joinToString(", ")
        _highestNumber.value = highestNumber


    }
}