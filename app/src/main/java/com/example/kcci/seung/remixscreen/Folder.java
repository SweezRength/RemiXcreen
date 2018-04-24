package com.example.kcci.seung.remixscreen;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Folder extends AppCompatActivity {

    Uri uri;
    Button btn1;
    ImageView image_view1, image_view2, image_view3, image_view4, image_view5, image_view6, image_view7, image_view8;
    private final int GALLERY_CODE = 1112;

    // final int PICTURE_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        image_view1 = (ImageView) findViewById(R.id.image_view1);
        image_view2 = (ImageView) findViewById(R.id.image_view2);
        image_view3 = (ImageView) findViewById(R.id.image_view3);
        image_view4 = (ImageView) findViewById(R.id.image_view4);
        image_view5 = (ImageView) findViewById(R.id.image_view5);
        image_view6 = (ImageView) findViewById(R.id.image_view6);
        image_view7 = (ImageView) findViewById(R.id.image_view7);
        image_view8 = (ImageView) findViewById(R.id.image_view8);


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

                startActivityForResult(intent, GALLERY_CODE);
            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GALLERY_CODE) {

            if (resultCode == Activity.RESULT_OK) {

                image_view1.setImageResource(0);
                image_view2.setImageResource(0);
                image_view3.setImageResource(0);
                image_view4.setImageResource(0);
                image_view5.setImageResource(0);
                image_view6.setImageResource(0);
                image_view7.setImageResource(0);
                image_view8.setImageResource(0);

                ClipData clipData = data.getClipData();
                if (clipData != null) {


                    for (int i = 0; i < 8; i++) {
                        if (i < clipData.getItemCount()) {
                            Uri urione = clipData.getItemAt(i).getUri();
                            switch (i) {
                                case 0:
                                    image_view1.setImageURI(urione);
                                    break;
                                case 1:
                                    image_view2.setImageURI(urione);
                                    break;
                                case 2:
                                    image_view3.setImageURI(urione);
                                    break;
                                case 3:
                                    image_view4.setImageURI(urione);
                                    break;
                                case 4:
                                    image_view5.setImageURI(urione);
                                    break;
                                case 5:
                                    image_view6.setImageURI(urione);
                                    break;
                                case 6:
                                    image_view7.setImageURI(urione);
                                    break;
                                case 7:
                                    image_view8.setImageURI(urione);
                                    break;
                            }
                        }
                    }
                }
            } else if (uri != null) {
                image_view1.setImageURI(uri);
                //  bitmap1 = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
//                 //   배치해놓은 ImageView에 이미지를 넣는다.
                // imageView1.setImageBitmap(bitmap1);
            } //catch 0:imageView1.setImageBitmap(bitmap1);}

        }

    }
}


