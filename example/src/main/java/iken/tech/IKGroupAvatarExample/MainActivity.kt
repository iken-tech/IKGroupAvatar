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
        list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
        list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
        list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
        list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
        list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
        list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")

        recyclerView.dataSource = list
    }
}
