package com.example.android.miwok;

public class Words {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation, mMiwokTranslation;
    private int mImageID = NO_IMAGE_PROVIDED;

    /**
     * constructor for views w/o images
     *
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Words(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     * constructor for views with containing images
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
