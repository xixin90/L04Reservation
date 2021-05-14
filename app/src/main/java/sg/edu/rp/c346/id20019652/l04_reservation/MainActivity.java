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

                Toast.makeText(MainActivity.this, "Button Click", Toast.LENGTH_LONG).show();
                if (cbEnabled.isChecked()) {
                    tvMessage.setText("Thank you. You have reserved a table.");
                }
                else{
                    tvMessage.setText("Sorry. An error has occurred, please try again.");
                }
            }
        });
    }
}