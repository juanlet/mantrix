package applicatives.j4ftech.Mantrix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.j4ftech.simplemeditation.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner sItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startMeditationButton = (Button) findViewById(R.id.startMeditationButton);


        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("3");
        spinnerArray.add("5");
        spinnerArray.add("10");
        spinnerArray.add("20");
        spinnerArray.add("30");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         sItems = (Spinner) findViewById(R.id.number_of_minutes);
        sItems.setAdapter(adapter);

        startMeditationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfMinutes = Integer.parseInt(sItems.getSelectedItem().toString());

                Intent intent = new Intent(getApplicationContext(), MeditationActivity.class);
                intent.putExtra("meditation_time", numberOfMinutes);
                startActivity(intent);
            }
        });


    }
}
