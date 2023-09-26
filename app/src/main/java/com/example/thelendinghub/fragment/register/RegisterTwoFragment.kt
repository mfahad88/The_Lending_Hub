package com.example.thelendinghub.fragment.register

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.thelendinghub.R
import com.example.thelendinghub.custom.LargeButton
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale





class RegisterTwoFragment : Fragment() {
    lateinit var editIdNumber:EditText
    lateinit var editCellNumber:EditText
    lateinit var editDob:EditText
    lateinit var buttonProceed:LargeButton
    lateinit var myCalendar:Calendar
    lateinit var linearLayoutId:LinearLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_register_two, container, false)
        initViews(view)
        myCalendar = Calendar.getInstance()
        val date =
            OnDateSetListener { view, year, month, day ->
                myCalendar[Calendar.YEAR] = year
                myCalendar[Calendar.MONTH] = month
                myCalendar[Calendar.DAY_OF_MONTH] = day
                updateLabel()
            }

        buttonProceed.setOnClickListener {v->
            if(!editIdNumber.text.isEmpty() && !editCellNumber.text.isEmpty()
                && !editCellNumber.text.isEmpty()){
                if(linearLayoutId.isSelected){
                    showBottomSheet(v)
                }
            }
        }
        editDob.setOnClickListener {
            DatePickerDialog(view.context,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        editIdNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (text!!.length>0) {
                    if(!text?.get(0).toString().equals("1")){
                        linearLayoutId.isSelected=true
                    }else{
                        linearLayoutId.isSelected=false
                    }

                }else{
                    linearLayoutId.isSelected=false
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
        return view
    }

    private fun showBottomSheet(v: View) {
        val bottomSheetDialog = BottomSheetDialog(v.context)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_error)
        val buttonContinue = bottomSheetDialog.findViewById<LargeButton>(R.id.buttonContinue)
        buttonContinue?.setOnClickListener { bottomSheetDialog.dismiss() }
        bottomSheetDialog.show()
    }

    private fun initViews(view: View) {
        editIdNumber=view.findViewById(R.id.editIdNumber)
        editCellNumber=view.findViewById(R.id.editCellNumber)
        editDob=view.findViewById(R.id.editDob)
        buttonProceed=view.findViewById(R.id.buttonProceed)
        linearLayoutId=view.findViewById(R.id.linearLayoutId)

    }

    private fun updateLabel() {
        val myFormat = "MMMM dd,yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        editDob.setText(dateFormat.format(myCalendar.time))
    }


}