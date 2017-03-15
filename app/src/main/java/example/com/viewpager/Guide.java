package example.com.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminstrator on 2017/2/2.
 */

public class Guide extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private Viewpageradapter viewpagerAdapter;
    private List<View> views;
    private ViewPager viewPager;
    private ImageView[] iv;
      private int[] ids={R.id.v1,R.id.v2,R.id.v3};
    private  Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);
        initview();
        initiv();
        button= (Button) views.get(2).findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Guide.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void initview(){
        LayoutInflater inflater=LayoutInflater.from(this);
        views=new ArrayList<View>();
        views.add(inflater.inflate(R.layout.p1,null));
        views.add(inflater.inflate(R.layout.p2,null));
        views.add(inflater.inflate(R.layout.p3,null));
        viewpagerAdapter=new Viewpageradapter(views,this);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(viewpagerAdapter);
        viewPager.setOnPageChangeListener(this);
    }
    private void initiv(){
        iv=new ImageView[views.size()];
        for (int i=0;i<views.size();i++){
            iv[i]= (ImageView) findViewById(ids[i]);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            for (int i=0;i<views.size();i++){
            if(position==i){
                iv[i].setImageResource(R.drawable.login_point_selected);
            }else{
                iv[i].setImageResource(R.drawable.login_point);
            }
            }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
