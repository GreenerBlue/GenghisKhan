package com.testing.atul.genghiskhan;

import android.provider.BaseColumns;

/**
 * Created by Atul on 2/19/2018.
 */

final class FeedContract {
    private FeedContract() {}
    static class FeedEntry implements BaseColumns{
        static final String TABLE_NAME = "drums";
        static final String COL_NAME = "title";
    }
}
