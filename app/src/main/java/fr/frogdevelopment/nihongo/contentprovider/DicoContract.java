/*
 * Copyright (c) Frog Development 2015.
 */

package fr.frogdevelopment.nihongo.contentprovider;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class DicoContract implements BaseColumns {

    public static final String TABLE_NAME = "DICO";

    public static final String INPUT = "INPUT";
    public static final String SORT_LETTER = "SORT_LETTER";
    public static final String KANJI = "KANJI";
    public static final String KANA = "KANA";
    public static final String DETAILS = "DETAILS";
    public static final String EXAMPLE = "EXAMPLE";
    public static final String TYPE = "TYPE";
    public static final String TAGS = "TAGS";
    public static final String FAVORITE = "FAVORITE";
    public static final String LEARNED = "LEARNED";
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    public static final String[] COLUMNS = {_ID, INPUT, SORT_LETTER, KANJI, KANA, TAGS, DETAILS, EXAMPLE, FAVORITE, LEARNED, SUCCESS, FAILED};

    // Queries
    private static final String SQL_CREATE = String.format(
            "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT NOT NULL, %s TEXT, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL DEFAULT 0);",
            TABLE_NAME, _ID, INPUT, SORT_LETTER, KANJI, KANA, DETAILS, EXAMPLE, TYPE, TAGS, FAVORITE, LEARNED, SUCCESS, FAILED);

    static void create(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    // UPDATE
    static final String UPDATE_11 = "ALTER TABLE DICO ADD COLUMN LEARNED INTEGER NOT NULL DEFAULT 0";
    static final String UPDATE_12 = "ALTER TABLE DICO ADD COLUMN EXAMPLE TEXT";
    static final String UPDATE_13 = "ALTER TABLE DICO ADD COLUMN SUCCESS INTEGER NOT NULL DEFAULT 0";
    static final String UPDATE_14 = "ALTER TABLE DICO ADD COLUMN FAILED INTEGER NOT NULL DEFAULT 0";

}
