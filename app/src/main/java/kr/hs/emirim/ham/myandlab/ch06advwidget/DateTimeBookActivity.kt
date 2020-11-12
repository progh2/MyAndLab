package kr.hs.emirim.ham.myandlab.ch06advwidget

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.*
import kr.hs.emirim.ham.myandlab.R

class DateTimeBookActivity : AppCompatActivity() {

    public val TAG = "날짜예약액티비티"

    lateinit var chrono : Chronometer
    lateinit var btnStart : Button
    lateinit var btnEnd : Button
    lateinit var rdoCal : RadioButton
    lateinit var rdoTime : RadioButton
    lateinit var calView : CalendarView
    lateinit var tPicker : TimePicker
    lateinit var tvDatetime : TextView

    var selectYear : Int = 0
    var selectMonth : Int = 0
    var selectDay : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title="시간 예약"

        setContentView(R.layout.activity_date_time_book)

        btnStart = findViewById(R.id.btnStart)
        btnEnd = findViewById(R.id.btnEnd)
        chrono = findViewById(R.id.chronometer1)
        rdoCal = findViewById(R.id.rdoCal)
        rdoTime = findViewById(R.id.rdoTime)
        tPicker = findViewById(R.id.timePicker1)
        calView = findViewById(R.id.calendarView1)
        tvDatetime = findViewById(R.id.tvDatetime)

        calView.visibility = View.GONE
        tPicker.visibility = View.GONE

        rdoTime.setOnClickListener {
            calView.visibility = View.GONE
            tPicker.visibility = View.VISIBLE
            Log.d(TAG, "rdoTime클릭")
        }

        rdoCal.setOnClickListener {
            calView.visibility = View.VISIBLE
            tPicker.visibility = View.GONE
            Log.d(TAG, "rdoCal클릭")
        }

        btnStart.setOnClickListener {
            chrono.base = SystemClock.elapsedRealtime()
            chrono.start()
            chrono.setTextColor(Color.RED)
            Log.d(TAG, "btnStart 클릭됨")
        }

        btnEnd.setOnClickListener {
            chrono.stop()
            chrono.setTextColor(Color.BLUE)
            Log.d(TAG, "btnEnd 클릭됨")

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                tvDatetime.text = "" + selectYear + "년" + selectMonth + "월" + selectDay + "일" + tPicker.hour + "시" + tPicker.minute + "분 예약됨"
            }else{
                tvDatetime.text = "" + selectYear + "년" + selectMonth + "월" + selectDay + "일" + tPicker.currentHour + "시" + tPicker.currentMinute + "분 예약됨"
            }
        }

        calView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            selectYear = year
            selectMonth = month + 1
            selectDay = dayOfMonth
            Log.d(TAG, "오늘은 : " + selectYear + "/" + selectMonth + "/" + selectDay)
        }

    }
}