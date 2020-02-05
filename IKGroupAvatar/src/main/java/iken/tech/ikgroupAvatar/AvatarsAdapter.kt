package iken.tech.ikgroupAvatar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import de.hdodenhof.circleimageview.CircleImageView


class AvatarsAdapter(
    val context: Context,
    var avatars: List<Any>,
    var limit: Int,
    var remain: Boolean,
    var border: Int,
    var borderColor: Int,
    var avatarSize: Int,
    var avatarMargin: Int,
    var remainColor: Int,
    var remainTextColor: Int,
    var remainTextSize: Float,
    var avatarPlaceHolder: Int
) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (position < limit)
            1
        else
            2
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): ViewHolder {
        if (i == 1) {
            val view: View = LayoutInflater.from(context)
                .inflate(R.layout.avatar_list_item, viewGroup, false)
            return AvatarViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(context)
                .inflate(R.layout.remain_list_item, viewGroup, false)
            return RemainViewHolder(view)
        }
    }

    override fun onBindViewHolder(@NonNull viewHolder: ViewHolder, i: Int) {
        if (viewHolder is AvatarViewHolder) {
            viewHolder.bind(i)
        } else if (viewHolder is RemainViewHolder) {
            viewHolder.bind()
        }
    }

    override fun getItemCount(): Int {
        return if(!remain && !avatars.isNullOrEmpty() && limit == 0)
            avatars.size
        else
            limit+1
    }

    inner class AvatarViewHolder(@NonNull itemView: View) : ViewHolder(itemView) {
        var logoView: CircleImageView = itemView.findViewById(R.id.logo)

        fun bind(position: Int) {
            logoView.borderWidth = border
            logoView.borderColor = borderColor
            logoView.layoutParams.height = avatarSize
            logoView.layoutParams.width = avatarSize
            if (position == 0) {
                val params = LinearLayout.LayoutParams(
                    logoView.layoutParams.width,
                    logoView.layoutParams.height
                )
                params.setMargins(0, 0, 0, 0)
                logoView.layoutParams = params
            }else{
                val param = LinearLayout.LayoutParams(
                    logoView.layoutParams.width,
                    logoView.layoutParams.height
                )
                param.setMargins(avatarMargin, 0, 0, 0)
                logoView.layoutParams = param
            }

            Glide.with(context)
                .load(avatars[position])
                .placeholder(avatarPlaceHolder)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(logoView)
        }
    }


    inner class RemainViewHolder(@NonNull itemView: View) : ViewHolder(itemView) {
        var remainView: FrameLayout = itemView.findViewById(R.id.remain_view)
        var remainCount: TextView = itemView.findViewById(R.id.remain_count)
        var remainCircle: CircleImageView = itemView.findViewById(R.id.remain_circle)

        init {
            remainView.layoutParams.height = avatarSize
            remainView.layoutParams.width = avatarSize
            val param = LinearLayout.LayoutParams(
                remainView.layoutParams.width,
                remainView.layoutParams.height
            )
            param.setMargins(avatarMargin, 0, 0, 0)
            remainView.layoutParams = param

            remainCircle.setColorFilter(remainColor)
            remainCount.textSize = remainTextSize
            remainCount.setTextColor(remainTextColor)
        }

        fun bind() {

            if (remain){
                remainView.visibility = View.VISIBLE
                remainCount.text = (avatars.size - limit).toString()
            }else{
                remainView.visibility = View.GONE
            }
        }

    }
}