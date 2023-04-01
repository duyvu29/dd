package com.example.mvpapp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.mvpapp.R

class MainActivity : AppCompatActivity() {
    var Urljpg : String = "https://anvientv.com.vn/uploads/upload/1673574526_hinh-nen-hoa-tulip-anvien.jpg"
    var urlMp3 : String = "https://zingmp3.vn/album/Bat-Tinh-Yeu-Len-Single-Tang-Duy-Tan-Hoa-Minzy/6B8C80U7.html"
    var urlMp4  : String = "https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"

    lateinit var rdSingle: RadioButton
    lateinit var rdMutipple: RadioButton
    lateinit var spinner: Spinner
    lateinit var edtDesc: EditText
    lateinit var btnDownload: Button
    lateinit var btnSave: Button
    lateinit var progessBar: ProgressBar

    lateinit var url : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ánh xạ
        mapping()
        // set Spinner
        setSpinner()
        // sự kin65
        addEvent()

    }

    private fun addEvent() {
        btnDownload.setOnClickListener(View.OnClickListener {

        })
    }

    private fun mapping() {
        rdSingle = findViewById(R.id.RadioSingle)
        rdMutipple = findViewById(R.id.RadioMutiple)
        spinner = findViewById(R.id.SpinnerList)
        edtDesc = findViewById(R.id.edtDesc)
        btnDownload = findViewById(R.id.btnDownload)
        btnSave = findViewById(R.id.btnSave)
        progessBar = findViewById(R.id.progressBar)
    }

    private fun setSpinner() {
        var list = ArrayList<String>()
        list.add("Danh sách các file")
        list.add("Hình ảnh $Urljpg ")
        list.add("Mp3 $urlMp3 ")
        list.add("Mp4 $urlMp4 ")
        // khởi tạo adaoter thông thường
        var adt = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        // gọi spiner
        spinner.adapter = adt
        // sự kiện lắng nghe item trên Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (adt.getItemViewType(id.compareTo(1)) == 1){
                    btnDownload.setOnClickListener{
                        Toast.makeText(this@MainActivity, "mmmm", Toast.LENGTH_SHORT).show()
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}