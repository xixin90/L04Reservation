package sg.edu.rp.c346.id20019652.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnReserve;
    Button btnReset;
    TextView tvMessage;
    EditText edName;
    EditText edMobile;
    EditText edSize;
    CheckBox cbEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp.findViewById(R.id.datePicker);
        tp.findViewById(R.id.timePicker);
        btnReserve.findViewById(R.id.buttonReserve);
        btnReset.findViewById(R.id.buttonReset);
        tvMessage.findViewById(R.id.textViewMessage);
        edName.findViewById(R.id.textViewName);
        edMobile.findViewById(R.id.textViewMobileNo);
        edSize.findViewById(R.id.textViewSize);
        cbEnabled.findViewById(R.id.checkBoxSmokeOption);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //display reservation info message for a short while
                //includes name, mobile no., size of group, date and time
                //confirm reservation message

                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                int mobile = Integer.parseInt(edMobile.getText().toString());
                int size = Integer.parseInt(edSize.getText().toString());
                String name = edName.getText().toString();
                String date = "Date is " + day + "/" + month + "/" + year;
                String time = "Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();

                String displayS = "Hi " + name+ ", You have reserved a " + size + " person(s) smoking table on " + date + " at " + time + ". Your phone number is " + mobile + " .";
                String displayNonS = "Hi " + name + ", You have reserved a " + size + " person(s) non-smoking table on " + date + " at " + time + ". Your phone number is " + mobile + " .";

                //Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                if (!name.isEmpty() && mobile != 0 && size != 0) {
                    if (cbEnabled.isChecked()) {
                        Toast.makeText(MainActivity.this, displayS, Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, displayNonS, Toast.LENGTH_LONG).show();
                    }
                    tvMessage.setText("You have successfully booked a table.");
                }
                else {
                    tvMessage.setText("Your name / mobile number / size of group is/are missing. Please fill in the required fields.");
                }
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                int minHour = 8;
                int minMinute = 0;
                int maxHour = 20;
                int maxMinute = 59;

                boolean validTime = true;
                if (hourOfDay < minHour || (hourOfDay == minHour && minute < minMinute)) {
                    validTime = false;
                }
                if (hourOfDay > maxHour || (hourOfDay == maxHour && minute > maxMinute)){
                    validTime = false;
                }
                else{
                    String strResponse = "You have exceeded the booking hours";
                    setTitle(strResponse);
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // set date 1 jun 2020
                // set time 19:30 PM

                dp.updateDate(2020, 6, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                edName.setText(" ");
                edMobile.setText(" ");
                edSize.setText(" ");

                Toast.makeText(MainActivity.this, "You have Reset your reservation", Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this, "Button Reset is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}