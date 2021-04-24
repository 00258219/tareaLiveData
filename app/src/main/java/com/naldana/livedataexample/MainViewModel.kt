package com.naldana.livedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.util.*

class MainViewModel : ViewModel() {

    private var _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun setMessage(message: String) {
        _message.value = message
    }

    init {
        _message.value = ""
    }

    var messageLowerCase = Transformations.map(message) { message ->
        message.toLowerCase(Locale.ROOT)
    }

    var messageSecretTransformation = Transformations.map(message) { message ->
        message.replace('i', '1', true)
            .replace('z', '2', true)
            .replace('e', '3', true)
            .replace('a', '4', true)
            .replace('s', '5', true)
            .replace('t', '7', true)
            .replace('o', '0', true)

    }

}