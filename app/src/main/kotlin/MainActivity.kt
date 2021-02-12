package com.prometheanworld.simpleapp

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.LinearLayout
import android.widget.TextView
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

class MainActivity: Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val parent = LinearLayout(this)
    parent.setLayoutParams(
      LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))
    parent.setOrientation(LinearLayout.HORIZONTAL)
    val tv1 = TextView(this)
    val spClass = Class.forName("android.os.SystemProperties")
    //val setMethod = spClass.getMethod("set", String::class.java, String::class.java)

    val setMethod = spClass.getDeclaredMethod("set", String::class.java, String::class.java)
    //setMethod.invoke(null, "property", "new-value")  // InvocationTargetException
    setMethod.invoke(null, "sys.boot_from_charger_mode", "1")

    //      Method mGetIntMethod = mClassType.getDeclaredMethod("getInt", String.class, int.class)
    //      mGetIntMethod.setAccessible(true)
    //      tv1.setText((String) mGetIntMethod.invoke(null, "ro.build.version.sdk", 14))
    tv1.setText("Yeah")
    parent.addView(tv1)
    setContentView(parent)
  }
}
