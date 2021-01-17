package threebugs.onairpollution;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    Spinner selectCity;
    Button btnGoToContribution;
    TextView monTextView;
    TextView tueTextView;
    TextView wedTextView;
    TextView thursTextView;
    TextView friTextView;
    TextView satTextView;
    TextView sunTextView;
    String text = "";
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monTextView = findViewById(R.id.tv_mon);
        tueTextView = findViewById(R.id.tv_tue);
        wedTextView = findViewById(R.id.tv_wed);

        thursTextView = findViewById(R.id.tv_thu);
        friTextView = findViewById(R.id.tv_fri);
        satTextView = findViewById(R.id.tv_sat);
        sunTextView = findViewById(R.id.tv_sun);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.home:
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.blogs:
                        startActivity(new Intent(MainActivity.this, informative_blog.class));
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.contributions:
                        startActivity(new Intent(MainActivity.this,PublicContributions.class));
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.stats:
                        startActivity(new Intent(MainActivity.this, Stats.class));
                        drawerLayout.closeDrawers();
                        break;

                    default:
                        return true;
                }

                return false;
            }
        });

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//        DatabaseReference databaseReference2 = firebaseDatabase.getReference("cities");
//        DatabaseReference bangalore = databaseReference2.child("bangalore");
//        DatabaseReference mon = bangalore.child("mon");
        //DatabaseReference delhiRef = firebaseDatabase.getReference("onairpollution/cities/delhi/Tue");

        selectCity = findViewById(R.id.select_city);

        final List<String> city = new ArrayList<>();
        city.add("delhi");
        city.add("mumbai");
        city.add("pune");
        city.add("bengalore");

        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, city);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectCity.setPrompt("Select your city");
        selectCity.setAdapter(cityAdapter);

        selectCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, selectedCity, Toast.LENGTH_SHORT).show();
                text = selectedCity;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference delhiMonRef = databaseReference.child("cities").child("delhi").child("Mon");
        DatabaseReference delhiTueRef = databaseReference.child("cities").child("delhi").child("Tue");
        DatabaseReference delhiWedRef = databaseReference.child("cities").child("delhi").child("Wed");
        DatabaseReference delhiThuRef = databaseReference.child("cities").child("delhi").child("Thurs");
        DatabaseReference delhiFriRef = databaseReference.child("cities").child("delhi").child("Fri");
        DatabaseReference delhiSatRef = databaseReference.child("cities").child("delhi").child("Sat");
        DatabaseReference delhiSunRef = databaseReference.child("cities").child("delhi").child("Sun");

        delhiMonRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String mon = dataSnapshot.getValue(String.class);
                monTextView.setText(mon);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        delhiTueRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String tue = dataSnapshot.getValue(String.class);
                tueTextView.setText(tue);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        delhiWedRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String wed = dataSnapshot.getValue(String.class);
                wedTextView.setText(wed);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        delhiThuRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String thu = dataSnapshot.getValue(String.class);
                thursTextView.setText(thu);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        delhiFriRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String fri = dataSnapshot.getValue(String.class);
                friTextView.setText(fri);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        delhiSatRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String sat = dataSnapshot.getValue(String.class);
                satTextView.setText(sat);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        delhiSunRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String sun = dataSnapshot.getValue(String.class);
                sunTextView.setText(sun);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btnGoToContribution = findViewById(R.id.btnContribution);

        btnGoToContribution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, YourContribution.class));
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }


}
