package iken.tech.IKGroupAvatarExample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import iken.tech.ikgroupAvatar.IKGroupAvatarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<IKGroupAvatarView>(R.id.avatars_list)

        val list = mutableListOf<Any>()
        list.add(R.drawable.ic_launcher_background)
        list.add("http://dev.furnnmore.com/media/image/67/nike-strike-football.png")
        list.add("http://dev.furnnmore.com/media/image/67/nike-strike-football.png")
        list.add("http://dev.furnnmore.com/media/image/67/nike-strike-football.png")
        list.add("http://dev.furnnmore.com/media/image/67/nike-strike-football.png")
        list.add("http://dev.furnnmore.com/media/image/67/nike-strike-football.png")
        list.add("http://dev.furnnmore.com/media/image/67/nike-strike-football.png")

        recyclerView.dataSource = list
    }
}
