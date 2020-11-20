package com.example.paymentgetewayintergation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.Sanitizer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.button.MaterialButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPager.OnPageChangeListener {
    SliderLayout sliderLayout;
    HashMap<String,String> Hash_file_maps ;
    private MaterialButton donateMask,donateSanitizer,donateGloves;
    public static final String KEY_STATUS="mask";
    public static final String SANITIZER="sanitizer";
    public static final String GLOVES="gloves";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donateMask=findViewById(R.id.donate_for_mask);
        donateSanitizer=findViewById(R.id.donate_for_sanitizer);
        donateGloves=findViewById(R.id.donate_for_gloves);
        ImageSlider();
        final Intent intent =new Intent(MainActivity.this,SelectAmount.class);
        donateMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(KEY_STATUS,"Donate For Mask");
                startActivity(intent);
            }
        });
        donateSanitizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(KEY_STATUS,"Donate For Sanitizer");
                startActivity(intent);
            }
        });
        donateGloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra(KEY_STATUS,"Donate For Gloves");
                startActivity(intent);
            }
        });



    }


    private void ImageSlider() {

        Hash_file_maps = new HashMap<String, String>();
        sliderLayout = (SliderLayout)findViewById(R.id.slider);
        Hash_file_maps.put("Slider1", "https://firebasestorage.googleapis.com/v0/b/registration-exp.appspot.com/o/Donation.jpg?alt=media&token=d271fa2e-1620-4444-9a9e-a984ccbdf551");
        Hash_file_maps.put("Slider2", "https://firebasestorage.googleapis.com/v0/b/registration-exp.appspot.com/o/donate1.jpg?alt=media&token=35711a44-e389-4c90-af1c-4882304c2d44");
        Hash_file_maps.put("Slider3", "https://firebasestorage.googleapis.com/v0/b/registration-exp.appspot.com/o/05Mag-Tip-01-mediumSquareAt3X.jpg?alt=media&token=4b47aa53-935d-4d0a-88d9-483c3787b243");
        Hash_file_maps.put("Slider4", "https://firebasestorage.googleapis.com/v0/b/registration-exp.appspot.com/o/3HRWR52RYJF4BHPZSRYVMZWDSU.jpg?alt=media&token=311ed0b7-e958-4935-a06a-afcffa18b520");
        Hash_file_maps.put("Slider1", "https://firebasestorage.googleapis.com/v0/b/registration-exp.appspot.com/o/donation1.jpg?alt=media&token=be9ba567-0e91-47e2-b7e6-f45a3c2d3196");
        Hash_file_maps.put("Slider1", "https://firebasestorage.googleapis.com/v0/b/registration-exp.appspot.com/o/stay-safe-stay-healthy-banner-vector-31205894.jpg?alt=media&token=ee679ccc-990d-4a6c-8ca7-4978dcb365da");
        for(String name : Hash_file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    //.description(name)
                    .image(Hash_file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra",name);
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(3000);
        sliderLayout.addOnPageChangeListener(new ViewPagerEx.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    protected void onStop() {

        sliderLayout.stopAutoCycle();

        super.onStop();
    }

    @Override
    protected void onStart() {
        sliderLayout.startAutoCycle();
        super.onStart();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

        //Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}