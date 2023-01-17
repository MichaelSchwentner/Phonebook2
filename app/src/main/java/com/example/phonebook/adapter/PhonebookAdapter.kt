package com.example.phonebook.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.data.model.PhonebookItem

// und die Liste an Jokes um sie für die RecyclerView vorzubereiten
class PhonebookAdapter(
    private val dataset: List<PhonebookItem>,
    private val deletePhone: (PhonebookItem) -> Unit
) : RecyclerView.Adapter<PhonebookAdapter.ViewHolder>() {
    // IDEE EINES VIEWHOLDERS
    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val phonebookName = view.findViewById<TextView>(R.id.phonebook_name_text)
        val phonebookNumber = view.findViewById<TextView>(R.id.phonebook_number_text)
        val phonebookDelete = view.findViewById<ImageView>(R.id.phonebook_delete_view)

    }
    // ERSTELLEN DES VIEWHOLDERS
    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(adapterLayout)
    }
    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val phonebookItem = dataset[position]

        holder.phonebookName.text = phonebookItem.name
        holder.phonebookNumber.text = "+49 ${phonebookItem.number}"
        
        holder.phonebookDelete.setOnClickListener {
            deletePhone(phonebookItem)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, dataset.lastIndex)
        }


/*        //delete
        holder.phobookDelete.setOnClickListener{
            deletePhone(phonebookItem)
            notifyItemRemoved(position)
        }*/

/*        holder.adoptButton.setOnClickListener {
            Toast.makeText(context,"${dog.name} freut sich schon", Toast.LENGTH_SHORT)
                .show()
        }*/

    }
    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}