package com.example.android1.downloadmanager;

import android.app.DownloadManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.android1.downloadmanager.Config.imageurl;
import static com.example.android1.downloadmanager.Config.musicurl;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button dwimage,dwmusic;
    DownloadManager downloadManager;
    Uri image_uri = Uri.parse(imageurl);
    Uri music_uri=Uri.parse(musicurl);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dwimage=(Button)findViewById(R.id.DownloadImage);
        dwmusic=(Button)findViewById(R.id.DownloadMusic);


        dwmusic.setOnClickListener(this);
        dwimage.setOnClickListener(this);


    }


    private long DownloadData (Uri uri, View v) {

        long downloadReference=0;


        downloadManager=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request=new DownloadManager.Request(uri);

        request.setTitle("Data Download");
        request.setDescription("This is Download Manager");

        if(v.getId() == R.id.DownloadMusic)
            request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_DOWNLOADS,"AndroidTutorialPoint.mp3");
        else if(v.getId() == R.id.DownloadImage)
            request.setDestinationInExternalFilesDir(MainActivity.this, Environment.DIRECTORY_DOWNLOADS,"AndroidTutorialPoint.jpg");

        downloadReference = downloadManager.enqueue(request);

        Button DownloadStatus = (Button) findViewById(R.id.DownloadStatus);
        DownloadStatus.setEnabled(true);
        Button CancelDownload = (Button) findViewById(R.id.CancelDownload);
        CancelDownload.setEnabled(true);


        return downloadReference;
    }





    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.DownloadImage:
                                        DownloadData(image_uri,v);
                                        break;

            case R.id.DownloadMusic:
                                        DownloadData(music_uri,v);
                                        break;
            case R.id.CancelDownload:

                                        break;
            case R.id.DownloadStatus:
                                        break;




        }

    }
}
