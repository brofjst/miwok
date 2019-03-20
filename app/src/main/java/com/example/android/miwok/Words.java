package com.example.android.miwok;

public class Words {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mDefaultTranslation, mMiwokTranslation;
    private int mImageID = NO_IMAGE_PROVIDED, mSongId = NO_IMAGE_PROVIDED;

    /**
     * constructor for views w/o images
     *
     * @param defaultTranslation
     * @param miwokTranslation
     */
    public Words(String defaultTranslation, String miwokTranslation, int songId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSongId = songId;
    }

    /**
     * constructor for views with containing images
     *
     * @param defaultTranslation word in Default language translation
     * @param miwokTranslation   word in miwok translation
     * @param imageId            integer rapresenting the id of the image
     */
    public Words(String defaultTranslation, String miwokTranslation, int imageId, int songId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageID = imageId;
        mSongId = songId;
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

    public int getSongID() {
        return mSongId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mAudioResourceId=" + mSongId +
                ", mImageResourceId=" + mImageID +
                '}';
    }
}
