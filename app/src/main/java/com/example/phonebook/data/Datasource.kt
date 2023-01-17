package com.example.phonebook.data

import com.example.phonebook.data.model.PhonebookItem

class Datasource {

    fun getPhonebookList(): MutableList<PhonebookItem> {
        return mutableListOf(
            PhonebookItem("Eser", " 176 456 334 23"),
            PhonebookItem("Michael", " 177 355 778 23"),
            PhonebookItem("Pete", " 178 228 274 82")
        )
    }
}