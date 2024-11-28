package com.example.fragmentexamples

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.context_menu, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                when (item?.itemId) {
                    R.id.action_edit -> { mode?.finish() }
                    R.id.action_delete -> { mode?.finish() }
                }
                return true
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                actionMode = null
            }

        }

        findViewById<Button>(R.id.button_action_mode).setOnClickListener {
            if (actionMode == null)
                actionMode = startSupportActionMode(callback)
        }

        findViewById<Button>(R.id.button_popup_menu).setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.inflate(R.menu.context_menu)
            popupMenu.setOnMenuItemClickListener { it: MenuItem? ->
                when (it?.itemId) {
                    R.id.action_edit -> {}
                    R.id.action_delete -> {}
                }
                true
            }
            popupMenu.show()
        }
    }
}