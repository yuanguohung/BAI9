import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a91.R
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChooseDateTime = findViewById<Button>(R.id.btnChooseDateTime)
        val tvSelectedDateTime = findViewById<TextView>(R.id.tvSelectedDateTime)

        val calendar = Calendar.getInstance()

        btnChooseDateTime.setOnClickListener {
            // DatePicker
            val datePicker = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    // Lưu ngày đã chọn
                    calendar.set(Calendar.YEAR, year)
                    calendar.set(Calendar.MONTH, month)
                    calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    // TimePicker
                    val timePicker = TimePickerDialog(
                        this,
                        { _, hourOfDay, minute ->
                            // Lưu giờ đã chọn
                            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                            calendar.set(Calendar.MINUTE, minute)

                            // Hiển thị ngày giờ đã chọn
                            val selectedDateTime = String.format(
                                "%02d/%02d/%04d %02d:%02d",
                                dayOfMonth,
                                month + 1,
                                year,
                                hourOfDay,
                                minute
                            )
                            tvSelectedDateTime.text = selectedDateTime
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        true // Sử dụng định dạng 24 giờ
                    )
                    timePicker.show()
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }
    }
}
