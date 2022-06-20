package com.example.cardviewjsondata
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.example.cardviewjsondata.Model.Usuario

class UserAdapter(val context: Context, val list: ArrayList<Usuario>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)

        val usuarioName = view.findViewById(R.id.txtName) as TextView
        val UsuarioEmail = view.findViewById(R.id.txtName) as TextView
        val UsrUrlAvatar = view.findViewById(R.id.txtName) as TextView
        val UsrAvatar = view.findViewById(R.id.txtName) as TextView

        usuarioName.text = list[position].nombreUsr.toString()
        UsuarioEmail.text = list[position].emailUsr.toString()
        UsrUrlAvatar.text = list[position].urlImagen.toString()
        UsrAvatar.text = list[position].imagenUsr.toString()

        return view
    }


}