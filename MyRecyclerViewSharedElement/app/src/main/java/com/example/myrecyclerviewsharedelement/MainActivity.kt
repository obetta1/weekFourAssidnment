package com.example.myrecyclerviewsharedelement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var contactList: List<DeteilContact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var drawer = findViewById<DrawerLayout>(R.id.drawerlayout)
        var toolbarr = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        var bar = ActionBarDrawerToggle(this , drawer, toolbarr,R.string.hhhh, R.string.close )




drawer.addDrawerListener(bar)
        bar.syncState()

        var contact1 = DeteilContact(R.drawable.sky_photo, "Samuel Ochoba" ,"samuel@gmail.com","(070)656-5656" )
        var contact2 = DeteilContact(R.drawable.okezi, "Joseph Okezi" , "JosephOkezi@gmail.com" ,"(707)112-2344")
        var contact3 = DeteilContact(R.drawable.godday, "Mr. Godday", "Mr.Godday@gmail.com", "(123)345-4345" )
        var contact4 = DeteilContact(R.drawable.ben, "Obetta Benjamin" , "ObettaBenjamin@gmail.com", "(070)234-2365")
        var contact5 = DeteilContact(R.drawable.pp, "Ejike Blessing", "EjikeBlessing@gmail.com", "(070)768-9090" )
        var contact6 = DeteilContact(R.drawable.mesi, "Lionel Messi", "LionelMessi@gmail.com", "(650)555-1367" )
        var contact7 = DeteilContact(R.drawable.okezi, "Paul Pugba", "PaulPugba@gmail.com", "(650)222-3456" )
        var contact8 = DeteilContact(R.drawable.godday, " Nema" , "Nema@gmail.com", "(850)667-9876")
        var contact9 = DeteilContact(R.drawable.groupphoto, "Eucharia", "Eucharia@gmail.com","(070)389-0987)")
        var contact10 = DeteilContact(R.drawable.pp, "Ejike Blessing","EjikeBlessing@gmail.com", "(070)768-9090" )

        val contactList = listOf<DeteilContact>(
            contact1, contact2, contact3, contact4 , contact5,
        contact6, contact7, contact8, contact9 , contact10  )

        val rView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.contactImage)
        var adapter = AdapterClass(contactList)
        rView.adapter = adapter
        rView.layoutManager = LinearLayoutManager(this)

        adapter.setOnItemClickListener(object : AdapterClass.onItemClickListener {
                override fun onItemClick(position: Int) {

                    var intent = Intent(this@MainActivity, ContactActivity::class.java)
                    intent.putExtra("name", contactList[position].name)
                    intent.putExtra("image", contactList[position].image)
                    intent.putExtra("email", contactList[position].email)
                    intent.putExtra("phoneNumber", contactList[position].phoneNumber)
                    startActivity(intent)
                }




        }
        )
    }


}