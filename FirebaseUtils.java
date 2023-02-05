import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class FirebaseUtils {
    private static FirebaseDatabase firebaseDatabase;

    // Connect to the Firebase database
    public static void connect() {
        if (firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
        }
    }

    // Retrieve job listings from the Firebase database
    public static void retrieveJobListings(final OnJobListingsRetrievedListener listener) {
        connect();
        firebaseDatabase.getReference("job_listings").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<JobListingModel> jobListings = new ArrayList<>();
                for (DataSnapshot jobListingSnapshot : dataSnapshot.getChildren()) {
                    JobListingModel jobListing = jobListingSnapshot.getValue(JobListingModel.class);
                    jobListings.add(jobListing);
                }
                listener.onJobListingsRetrieved(jobListings);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onError(databaseError.getMessage());
            }
        });
    }

    // Add a new job listing to the Firebase database
    public static void addJobListing(JobListingModel jobListing) {
        connect();
        firebaseDatabase.getReference("job_listings").push().setValue(jobListing);
    }

    // Interface for listening to job listings retrieval events
    public interface OnJobListingsRetrievedListener {
        void onJobListingsRetrieved(List<JobListingModel> jobListings);
        void onError(String errorMessage);
    }
}
