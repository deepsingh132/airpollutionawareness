package threebugs.onairpollution;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class YourContribution extends AppCompatActivity {

    String currentLevel = "";
    TextView showCurrentData;
    TextView current;
    TextView tvWedAQI;
    TextView tvThursAQI;
    TextView tvFriAQI;
    TextView tvSatAQI;
    TextView tvSunAQI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_contribution);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Your contributions");

        showCurrentData = findViewById(R.id.tv_current_show);
        current = findViewById(R.id.tv_current);
        tvWedAQI = findViewById(R.id.tv_wed_aqi);
        tvThursAQI = findViewById(R.id.tv_thurs_aqi);
        tvFriAQI = findViewById(R.id.tv_fri_aqi);
        tvSatAQI = findViewById(R.id.tv_sat_aqi);
        tvSunAQI = findViewById(R.id.tv_sun_aqi);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReferenceTue = firebaseDatabase.getReference("cities/delhi/Tue");
        final DatabaseReference databaseReferenceWed = firebaseDatabase.getReference("cities/delhi/Wed");
        final DatabaseReference databaseReferenceThurs = firebaseDatabase.getReference("cities/delhi/Thurs");
        final DatabaseReference databaseReferenceFri = firebaseDatabase.getReference("cities/delhi/Fri");
        final DatabaseReference databaseReferenceSat = firebaseDatabase.getReference("cities/delhi/Sat");
        final DatabaseReference databaseReferenceSun = firebaseDatabase.getReference("cities/delhi/Sun");


        databaseReferenceTue.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentLevel = dataSnapshot.getValue(String.class);
                showCurrentData.setText(currentLevel);
                current.setText(currentLevel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceWed.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentLevel = dataSnapshot.getValue(String.class);
                tvWedAQI.setText(currentLevel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceThurs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentLevel = dataSnapshot.getValue(String.class);
                tvThursAQI.setText(currentLevel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceFri.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentLevel = dataSnapshot.getValue(String.class);
                tvFriAQI.setText(currentLevel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceSat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentLevel = dataSnapshot.getValue(String.class);
                tvSatAQI.setText(currentLevel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReferenceSun.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentLevel = dataSnapshot.getValue(String.class);
                tvSunAQI.setText(currentLevel);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        //startActivity(new Intent(YourContribution.this, MainActivity.class));
        finish();
        super.onBackPressed();
    }
}
