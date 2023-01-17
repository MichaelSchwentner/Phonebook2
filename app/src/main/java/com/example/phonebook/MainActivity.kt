package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.phonebook.adapter.PhonebookAdapter
import com.example.phonebook.data.Datasource
import com.example.phonebook.data.model.PhonebookItem
import com.example.phonebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  lateinit var phonebookList: MutableList<PhonebookItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val datasource = Datasource()
        phonebookList = datasource.getPhonebookList()

        val deletePhone = { position: PhonebookItem ->
            //phonebookList.remove(position)
            deleteItem(position)
        }


        val phonebookAdapter = PhonebookAdapter(phonebookList, deletePhone)
        binding.phonebookRecycler.adapter = phonebookAdapter

        binding.addButton.setOnClickListener {
            addPhonebookItem(phonebookAdapter)
        }
        // Logo in Actionbar
/*        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_launcher_background)
        supportActionBar?.setDisplayUseLogoEnabled(true)*/
    }

    //Number delete
/*    private fun deleteNumberItem(adapter: PhonebookAdapter, item: PhonebookItem) {
        val position = phonebookList.indexOf(item)
        phonebookList.remove(item)
        adapter.notifyItemRemoved(position)
    }*/

    //Number delete
    fun deleteItem(position: PhonebookItem){
        phonebookList.remove(position)
    }

    private fun addPhonebookItem(adapter: PhonebookAdapter) {
        val name = binding.nameEdit.text.toString()
        val number = binding.numberEdit.text.toString()

        if (!name.isNullOrEmpty()){
            val newNumber = PhonebookItem(name, number)
            phonebookList.add(0,newNumber)
            adapter.notifyItemInserted(0)

        }
    }
}