import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class JobDetailActivity extends AppCompatActivity {
  
  private TextView jobTitleTextView;
  private TextView jobDescriptionTextView;
  private TextView companyNameTextView;
  private TextView locationTextView;
  private InterstitialAd interstitialAd;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_job_detail);

    jobTitleTextView = findViewById(R.id.job_title_text_view);
    jobDescriptionTextView = findViewById(R.id.job_description_text_view);
    companyNameTextView = findViewById(R.id.company_name_text_view);
    locationTextView = findViewById(R.id.location_text_view);

    Intent intent = getIntent();
    if (intent != null) {
      jobTitleTextView.setText(intent.getStringExtra("job_title"));
      jobDescriptionTextView.setText(intent.getStringExtra("job_description"));
      companyNameTextView.setText(intent.getStringExtra("company_name"));
      locationTextView.setText(intent.getStringExtra("location"));
    }

    interstitialAd = new InterstitialAd(this);
    interstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
    interstitialAd.loadAd(new AdRequest.Builder().build());
  }

  public void openWebsite(View view) {
    String url = getIntent().getStringExtra("website_url");
    Intent intent = new Intent(Intent.ACTION_VIEW);
    intent.setData(Uri.parse(url));
    startActivity(intent);
    if (interstitialAd.isLoaded()) {
      interstitialAd.show();
    }
  }
}
