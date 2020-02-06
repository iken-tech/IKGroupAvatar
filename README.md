# IKGroupAvatar
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![MinSdk: 17](https://img.shields.io/badge/minSdk-17-green.svg)](https://developer.android.com/about/versions/android-4.0) [![write: Kotlin](https://img.shields.io/badge/write-Kotlin-orange.svg)](https://kotlinlang.org/) [![Release](https://jitpack.io/v/iken-tech/IKGroupAvatar.svg)](https://jitpack.io/#iken-tech/IKGroupAvatar)

![limited_list](https://raw.github.com/iken-tech/IKGroupAvatar/master/limited_list.png)
![full_list](https://raw.github.com/iken-tech/IKGroupAvatar/master/full_list.png)

## How to integrate the library in your app?
#### Step 1: Add it in your root build.gradle at the end of repositories:

```kotlin
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
#### Step 2. Add the dependency
```kotlin
dependencies {
    implementation 'com.github.iken.tech:IKGroupAvatarView:Release'
    implementation "androidx.recyclerview:recyclerview:1.1.0"
}
```
#### Step 3. Add CurveGraphView to your layout file
```xml
 <iken.tech.ikgroupAvatar.IKGroupAvatarView
        android:id="@+id/avatars_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:item_limit="3"
        app:display_remaining_items="true"
        app:avatar_border_size="2dp"
        app:avatar_size="50dp"
        app:avatar_margin="-16"
        app:avatar_border_color="@color/colorAccent"
        app:remain_color="@color/colorPrimary"
        app:remain_count_text_color="@android:color/black"
        app:remain_count_text_size="24"
        app:avatar_placeholder="@drawable/ic_launcher_background"/>
```
#### Step 4. Pass your data source to IKGroupAvatarView
```kotlin
 val mIKGroupAvatarView = findViewById<IKGroupAvatarView>(R.id.avatars_list)

 val list = mutableListOf<Any>()                  // you can pass URI, URL, Drawable
 list.add(R.drawable.ic_launcher_background)
 list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
 list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
 list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
 list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
 list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")
 list.add("https://avatarfiles.alphacoders.com/668/66833.jpg")

 mIKGroupAvatarView.dataSource = list
```

## Xml view Attributes
| Attribute  | Functionality | defult Value |
| ------------- | ------------- | ------------- |
| `item_limit`  | disblay limited items | 0 |
| `display_remaining_items`  | dispaly remaining items view | false |
| `avatar_border_size`  | avatar border size | 0 |
| `avatar_size`  | avatar circle size | 38dp |
| `avatar_margin`  | space between each avatar | -16 |
| `avatar_border_color`  | avatar border color | #0000000 |
| `remain_color`  | remaining items circle color | #d3d3d3 |
| `remain_count_text_color`  | remaining items count text color | #0000000 |
| `remain_count_text_size`  | remaining items count text size | 18 |
| `avatar_placeholder`  | avatar place holder while avatar's loading finish | R.drawable.avatar_placeholder |

License
-------
IKGroupAvatar is available under the MIT license. See the `LICENSE` file for more info.
