
import android.os.AsyncTask;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SearchJobTask extends AsyncTask<String, Void, List<JobListingModel>> {
private static final String TAG = "SearchJobTask";

private TaskDelegate delegate;
private List<JobListingModel> jobListings;

public SearchJobTask(TaskDelegate delegate) {
    this.delegate = delegate;
    jobListings = new ArrayList<>();
}

@Override
protected List<JobListingModel> doInBackground(String... params) {
    String searchTerm = params[0];

    DatabaseReference jobListingRef = FirebaseDatabase.getInstance().getReference().child("job_listings");
    jobListingRef.orderByChild("title").startAt(searchTerm).endAt(searchTerm + "\uf8ff").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot jobListingSnapshot : dataSnapshot.getChildren()) {
                JobListingModel jobListing = jobListingSnapshot.getValue(JobListingModel.class);
                jobListings.add(jobListing);
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            Log.e(TAG, "Error while searching job listings in Firebase: " + databaseError.getMessage());
        }
    });

    return jobListings;
}

@Override
protected void onPostExecute(List<JobListingModel> jobListings) {
    delegate.onTaskComplete(jobListings);
}

public interface TaskDelegate {
    void onTaskComplete(List<JobListingModel> jobListings);
}
}