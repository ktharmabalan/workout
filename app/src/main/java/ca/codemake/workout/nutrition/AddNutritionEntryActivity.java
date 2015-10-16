package ca.codemake.workout.nutrition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import ca.codemake.workout.R;

public class AddNutritionEntryActivity extends AppCompatActivity {

    private HashMap<String, String> autoText;
    private ArrayList foodNameList;
    private ArrayList mealNameList;

    private Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nutrition_entry);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        TextView date = (TextView) findViewById(R.id.txt_nutrition_day);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        date.setText(simpleDateFormat.format(calendar.getTime()));

        foodNameList = new ArrayList();
        mealNameList = new ArrayList();

        foodNameList.add("Bacon");
        foodNameList.add("Eggs");
        foodNameList.add("Sausage");
        foodNameList.add("Toast");
        foodNameList.add("Juice");
        foodNameList.add("Apple");

        mealNameList.add("Breakfast");
        mealNameList.add("Lunch");
        mealNameList.add("Dinner");
        mealNameList.add("Other");

        if (mealNameList.size() > 0) {
            AutoCompleteTextView mealName = (AutoCompleteTextView) findViewById(R.id.mealName);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mealNameList);
            mealName.setAdapter(adapter);
        }

        if (foodNameList.size() > 0) {
            AutoCompleteTextView foodName = (AutoCompleteTextView) findViewById(R.id.foodName);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foodNameList);
            foodName.setAdapter(adapter);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add_nutrition_entry_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
//                Intent returnIntent = new Intent();
//                returnIntent.putExtra("result",result);
//                setResult(RESULT_OK, returnIntent);
//                finish();
                return true;
            case R.id.action_save:
//                showHelp();
                Intent i = new Intent(getApplicationContext(), AddFoodActivity.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}