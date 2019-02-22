package mcgill.shredit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;

import mcgill.shredit.model.Equipment;
import mcgill.shredit.model.Gym;

public class GymActivity extends AppCompatActivity {

    // TODO : generate gym data; Remove this when completed.
//    Gym selectedGym = new Gym("FlexBoi", 1);
//    Equipment gymEquipment = new Equipment("treadmill", 1);

    ListView search_gym;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        // Search bar
        search_gym = findViewById(R.id.search_gym);
        ArrayList<String> arrayGyms = queryGyms();

        adapter = new ArrayAdapter<String>(
                GymActivity.this,
                android.R.layout.simple_list_item_1,
                arrayGyms
        );

        search_gym.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_gym_menu, menu);
        MenuItem item = menu.findItem(R.id.search_gym);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    // TODO query gym data
    private ArrayList<String> queryGyms() {
        String[] array = {"McGill Fitness Center", "Economofitness St Catherine", "Economofitness Atwater"};
        ArrayList<String> gyms = new ArrayList<>(Arrays.asList(array));
        return gyms;
    }

    // TODO : Need to pass actual generated gym equipment data to MuscleGroupActivity
//    public void onGymConfirmClick(View view) {
//        selectedGym.addEquipment(gymEquipment);
//        List<Equipment> gymEquipments = selectedGym.getEquipments();
//
//        if(!gymEquipments.isEmpty()){
//            Intent intent = new Intent(this, MuscleGroupActivity.class);
//            intent.putExtra("EQUIPMENT_LIST", (Serializable) gymEquipments);
//            startActivity(intent);
//        }else {
//            Toast toast = Toast.makeText(getApplicationContext(),
//                    "A GYM HAS TO BE SELECTED",
//                    Toast.LENGTH_SHORT);
//            toast.show();
//        }
//    }
}
