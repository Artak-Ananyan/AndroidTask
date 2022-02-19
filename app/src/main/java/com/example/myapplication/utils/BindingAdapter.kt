package com.example.myapplication.utils

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.BindingAdapter
import com.example.myapplication.R
import com.example.myapplication.network.Wellsitems
import com.fonfon.kgeohash.GeoHash
import java.util.*

@BindingAdapter("showDialog")
fun showDialog(view: TextView, data: Wellsitems) {
    view.setOnClickListener {
        val wgs84 = GeoHash(data.location).toLocation()
        val builder = AlertDialog.Builder(view.context)
        builder.setTitle(data.name)
        builder.setMessage(wgs84.latitude.toString() + " " + wgs84.longitude)
        builder.setPositiveButton(view.context.getText(R.string.show_location_on_map)) { dialog, which ->
            val uri: Uri =
                Uri.parse(
                    String.format(
                        Locale.ENGLISH,
                        "geo:%f,%f",
                        wgs84.latitude,
                        wgs84.longitude
                    )
                )

            val intent = Intent(
                Intent.ACTION_VIEW,
                uri
            )
            startActivity(view.context, intent, null)
        }
        builder.setNegativeButton(view.context.getText(R.string.cancel)) { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }
}
