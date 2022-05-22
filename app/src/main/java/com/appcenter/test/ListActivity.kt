package com.appcenter.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recyclerView)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        recyclerView.adapter = Adapter(createData())
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun createData(): ArrayList<Person> {
        val data: ArrayList<Person> = arrayListOf()
        data.add(Person("가나다", "30", "안드로이드"))
        data.add(Person("라마바", "40", "IOS"))
        data.add(Person("사아자", "50", "서버"))
        data.add(Person("카타파", "60", "디자인"))
        return data
    }
}