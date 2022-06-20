package com.example.cardviewjsondata

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListAdapter
import com.example.cardviewjsondata.Model.Usuario
import org.json.JSONArray
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://reqres.in/api/users"
        funcionJson().execute(url)
    }

    inner class funcionJson : AsyncTask<String, String, String>(){
        override fun doInBackground(vararg url: String?): String {
            val text: String
            val connection = URL(url[0]).openConnection() as HttpURLConnection
            try {
                connection.connect()
                text = connection.inputStream.use { it.reader().use{reader -> reader.readText()} }
            } finally {
                connection.disconnect()
            }
            return  text
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            handJson(result)
        }

    }

    private fun handJson(jsonString: String?) {
        val jsonArray = JSONArray(jsonString)
        val list = ArrayList<Usuario>()
        var aux = 0

        while (aux < jsonArray.length()){
            val jsonObject = jsonArray.getJSONObject(aux)
            list.add(Usuario(
                jsonObject.getInt("id"),
                jsonObject.getString("nme"),
                jsonObject.getString("mail"),
                jsonObject.getString("imgurl"),
                jsonObject.getString("imgavatar")
            ))
            aux++
        }
        val adapter = UserAdapter(this,list)


    }
}