package com.aaronsengroup.simpleapp

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

class MainActivity : Activity() {
  override fun onCreate(savedInstanceState:Bundle?) {
    super.onCreate(savedInstanceState);

    val label = TextView(this);
    label.text = "All working now";
    setContentView(label);
  }
}
Footer
