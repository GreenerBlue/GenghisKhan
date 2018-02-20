package com.testing.atul.genghiskhan;

import android.provider.BaseColumns;

/**
 * Created by Atul on 2/19/2018.
 */

public final class FeedContract {
    private FeedContract() {};
    public static class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "drums";
        public static final String COL_NAME = "title";
    }
}
