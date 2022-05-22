package com.appcenter.test

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class CustomDialog(private val text:String, val onOk: () -> Unit, val onCancel : () -> Unit) {
    fun show(context: Context) {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customLayout = inflater.inflate(R.layout.layout_dialog, null)
        val build = AlertDialog.Builder(context).apply {
            setView(customLayout)
        }

        val dialog = build.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val textView = customLayout.findViewById<TextView>(R.id.text)
        textView.text = text

        val btnOk = customLayout.findViewById<Button>(R.id.ok_button)
        btnOk.setOnClickListener {
            onOk()
            dialog.dismiss()
        }
        val btnCancel = customLayout.findViewById<Button>(R.id.cancel_button)
        btnCancel.setOnClickListener {
            onCancel()
            dialog.dismiss()
        }
        dialog.show()
    }
}