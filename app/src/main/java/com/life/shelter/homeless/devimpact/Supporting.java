package com.life.shelter.homeless.devimpact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;



import java.util.ArrayList;

public class Supporting extends AppCompatActivity {
    private ArrayList<Sponsor> sponsorItem =new ArrayList<Sponsor>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporting);


        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));
        sponsorItem.add(new Sponsor("sponeor name",R.drawable.image));


        SponsorAdapter items = new SponsorAdapter(this,0,sponsorItem);
        ListView listView = findViewById(R.id.support_list);
        listView.setAdapter(items);
    }
}
