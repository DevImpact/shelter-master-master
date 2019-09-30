package com.life.shelter.homeless.devimpact;


public class Sponsor {
    private String sponsorName;
    private Integer mImageID;

    public Sponsor(String sponsorName, Integer mImageID) {
        this.sponsorName = sponsorName;
        this.mImageID = mImageID;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public Integer getmImageID() {
        return mImageID;
    }
}

