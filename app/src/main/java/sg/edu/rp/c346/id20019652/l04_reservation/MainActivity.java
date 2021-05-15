package sg.edu.rp.c346.id20019652.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

                //confirm reservation
                //display reservation info message for a short while
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();

                String date = "Date is " + day + "/" + month + "/" + year;
                String time = "Time is " + tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                String displayS = "Hi " + edName + ", You have reserved a " + edSize + " person(s) smoking table on " + date + " at " + time + ". Your phone number is " + edMobile + " .";
                String displayNonS = "Hi " + edName + ", You have reserved a " + edSize + " person(s) non-smoking table on " + date + " at " + time + ". Your phone number is " + edMobile + " .";

                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                if (cbEnabled.isChecked()) {
                    tvMessage.setText(displayS);
                }
                else{
                    tvMessage.setText(displayNonS);
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

                Toast.makeText(MainActivity.this, "Button Reset is long", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Button Reset is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}