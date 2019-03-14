package com.example.android.miwok;

public class Words {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation, mMiwokTranslation;
    private int mImageID = NO_IMAGE_PROVIDED;

    /**
     * costruttore per view senza immagini
     *
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Words(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * costrutore per view con immagini
     *
     * @param defaultTranslation word in Default language translation
     * @param miwokTranslation   word in miwok translation
     * @param imageId            integer rapresenting the id of the image
     */
    public Words(String defaultTranslation, String miwokTranslation, int imageId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageID = imageId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageID() {
        return mImageID;
    }

    public boolean hasImage() {
        return mImageID != NO_IMAGE_PROVIDED;
    }
}
