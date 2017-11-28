package irfan.popularmovies2.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import irfan.popularmovies2.data.PopularMovieContract.MovieEntry;

public class PopularMovieDbHelper extends SQLiteOpenHelper{

    private  static  final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "popularMovies.db";

    public PopularMovieDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + MovieEntry.TABLE_NAME + " (" +
                MovieEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                MovieEntry.MOVIE_ID + " TEXT UNIQUE NOT NULL," +
                MovieEntry.MOVIE_BACKDROP_URI + " TEXT NOT NULL," +
                MovieEntry.MOVIE_TITLE + " TEXT NOT NULL," +
                MovieEntry.MOVIE_POSTER + " TEXT NOT NULL," +
                MovieEntry.MOVIE_OVERVIEW + " TEXT NOT NULL," +
                MovieEntry.MOVIE_VOTE_AVERAGE + " TEXT NOT NULL," +
                MovieEntry.MOVIE_RELEASE_DATE + " TEXT NOT NULL," +
                MovieEntry.MOVIE_REVIEWS + " TEXT NOT NULL," +
                MovieEntry.MOVIE_TRAILERS + " TEXT NOT NULL," +
                "UNIQUE (" + MovieEntry.MOVIE_ID +") ON CONFLICT IGNORE"+
                " );";

        db.execSQL(SQL_CREATE_MOVIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MovieEntry.TABLE_NAME);
        onCreate(db);
    }
}
