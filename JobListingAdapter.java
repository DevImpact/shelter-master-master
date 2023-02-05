
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.List;

public class JobListingAdapter extends RecyclerView.Adapter<JobListingAdapter.ViewHolder> {

    private List<JobListingModel> jobListings;
    private Context context;
    private InterstitialAd interstitialAd;

    public JobListingAdapter(List<JobListingModel> jobListings, Context context) {
        this.jobListings = jobListings;
        this.context = context;
        interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(context.getString(R.string.ad_unit_id));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_listing_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobListingModel jobListing = jobListings.get(position);
        holder.title.setText(jobListing.getTitle());
        holder.company.setText(jobListing.getCompany());
        holder.location.setText(jobListing.getLocation());

        holder.button.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(jobListing.getWebsiteLink()));
            context.startActivity(intent);

            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            } else {
                AdRequest adRequest = new AdRequest.Builder().build();
                interstitialAd.loadAd(adRequest);
            }
        });
    }

    @Override
    public int getItemCount() {
        return jobListings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView company;
        private TextView location;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            company = itemView.findViewById(R.id.company);
            location = itemView.findViewById(R.id.location);
            button = itemView.findViewById(R.id.button);
        }
   

    }
}
