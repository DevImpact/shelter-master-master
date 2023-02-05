import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class JobListingActivity extends AppCompatActivity {

    private ListView jobListView;
    private ArrayList<JobListingModel> jobListings;
    private JobListingAdapter jobListingAdapter;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_listing);

        jobListView = findViewById(R.id.job_list_view);
        jobListings = new ArrayList<>();

        firebaseDatabase = FirebaseUtils.getFirebaseDatabase();
        databaseReference = FirebaseUtils.getDatabaseReference().child("job_listings");

        jobListingAdapter = new JobListingAdapter(this, jobListings);
        jobListView.setAdapter(jobListingAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jobListings.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    JobListingModel jobListing = snapshot.getValue(JobListingModel.class);
                    jobListings.add(jobListing);
                }
                jobListingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }
}
