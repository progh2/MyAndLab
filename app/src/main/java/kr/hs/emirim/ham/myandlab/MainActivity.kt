package kr.hs.emirim.ham.myandlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kr.hs.emirim.ham.myandlab.ch04widget.CalActivity

class MainActivity : AppCompatActivity() {

    lateinit var mButton1 : Button
    lateinit var mButton2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mButton1 = findViewById(R.id.button1)
        mButton2 = findViewById(R.id.button2)

        mButton1.setOnClickListener {
            //Intent intent = new Intent(this, MainActivity.class);
            startActivity(Intent(this, FourbuttonActivity::class.java))
        }

        mButton2.setOnClickListener {
            startActivity(Intent(this, Fourbutton2Activity::class.java))
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(Intent(this, CalActivity::class.java))
        }

    }
}