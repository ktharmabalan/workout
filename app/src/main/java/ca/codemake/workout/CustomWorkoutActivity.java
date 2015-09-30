package ca.codemake.workout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustomWorkoutActivity extends Activity implements ListView.OnItemClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_workout);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent i = new Intent(getApplicationContext(), CustomWorkoutGroupActivity.class);
//        startActivity(i);
        Toast.makeText(this, "ITEM CLICKED", Toast.LENGTH_SHORT).show();
    }
}
