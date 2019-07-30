package sg.edu.rp.c346.demodynamicactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Spinner mainSpinner, subSpinner;
    Button btn;

    ArrayList<String> categoryLists;
    ArrayAdapter<String> categoryAdapter;

    ArrayList<String> subLists;
    ArrayAdapter<String> subAdapter;

    String[] fc;
    String[] psx;
    String[] twt;
    String[] gh;
    String[] crs;
    String[] hdz;

    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainSpinner = findViewById(R.id.spinner);
        subSpinner = findViewById(R.id.spinner2);
        btn = findViewById(R.id.button);

        categoryLists = new ArrayList<>();
        categoryLists.add("FirmanCloud");
        categoryLists.add("PSXHAX");
        categoryLists.add("HardwareZone");
        categoryLists.add("Carousell");
        categoryLists.add("Twitter");
        categoryLists.add("GitHub");
        categoryAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, categoryLists);
        mainSpinner.setAdapter(categoryAdapter);

        fc = getResources().getStringArray(R.array.FirmanCoud);
        psx = getResources().getStringArray(R.array.PSXHAX);
        twt = getResources().getStringArray(R.array.Twitter);
        gh = getResources().getStringArray(R.array.GitHub);
        crs = getResources().getStringArray(R.array.Carousell);
        hdz = getResources().getStringArray(R.array.HardwareZone);

        subLists = new ArrayList<>();
        subAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, subLists);


        mainSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subLists.clear();

                switch (position) {
                    case 0:
                        subLists.addAll(Arrays.asList(fc));
                        break;
                    case 1:
                        subLists.addAll(Arrays.asList(psx));
                        break;
                    case 2:
                        subLists.addAll(Arrays.asList(hdz));
                        break;
                    case 3:
                        subLists.addAll(Arrays.asList(crs));
                        break;
                    case 4:
                        subLists.addAll(Arrays.asList(twt));
                        break;
                    case 5:
                        subLists.addAll(Arrays.asList(gh));
                        break;
                }
                subSpinner.setAdapter(subAdapter);
                subAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                if (mainSpinner.getSelectedItemPosition() == 0) {
                    if (subSpinner.getSelectedItem().equals("Homepage")) {
                        intent.putExtra("url", getResources().getString(R.string.firmancloud_url));
                    }
                } else if (mainSpinner.getSelectedItemPosition() == 1) {
                    if (subSpinner.getSelectedItem().equals("Homepage")) {
                        intent.putExtra("url", getResources().getString(R.string.pxh_url));
                    } else if (subSpinner.getSelectedItem().equals("PS4 Jailbreak")) {
                        intent.putExtra("url", getResources().getString(R.string.pxh_ps4_jailbreak_url));
                    }
                } else if (mainSpinner.getSelectedItemPosition() == 2) {
                    if (subSpinner.getSelectedItem().equals("Homepage")) {
                        intent.putExtra("url", getResources().getString(R.string.hwz_url));
                    } else if (subSpinner.getSelectedItem().equals("Internet Bandwidth")) {
                        intent.putExtra("url", getResources().getString(R.string.hwz_internet_bandwidth_url));
                    } else if (subSpinner.getSelectedItem().equals("Tech News")) {
                        intent.putExtra("url", getResources().getString(R.string.hwz_tech_news_url));
                    }
                } else if (mainSpinner.getSelectedItemPosition() == 3) {
                    if (subSpinner.getSelectedItem().equals("Homepage")) {
                        intent.putExtra("url", getResources().getString(R.string.carousell_url));
                    } else if (subSpinner.getSelectedItem().equals("Electronic")) {
                        intent.putExtra("url", getResources().getString(R.string.carousell_electronic_url));
                    }
                } else if (mainSpinner.getSelectedItemPosition() == 4) {
                    if (subSpinner.getSelectedItem().equals("Homepage")) {
                        intent.putExtra("url", getResources().getString(R.string.twitter_url));
                    }
                } else if (mainSpinner.getSelectedItemPosition() == 5) {
                    if (subSpinner.getSelectedItem().equals("Homepage")) {
                        intent.putExtra("url", getResources().getString(R.string.github_url));
                    } else if (subSpinner.getSelectedItem().equals("My Profile")) {
                        intent.putExtra("url", getResources().getString(R.string.github_my_profile_url));
                    }
                }
                startActivity(intent);
            }
        });
    }
}
