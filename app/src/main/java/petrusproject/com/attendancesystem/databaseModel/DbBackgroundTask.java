package petrusproject.com.attendancesystem.databaseModel;

import android.content.Context;
import android.os.AsyncTask;

public class DbBackgroundTask extends AsyncTask<String,Void,Void> {

    //Constructor
    Context ctx;
    DbBackgroundTask(Context context)
    {
        this.ctx = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(String... Voids) {

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
