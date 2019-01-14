package com.example.picturevideo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.app.Activity;

public class MainActivity extends Activity {

    private ViewPager vp;
    private MyAdapter myAdapter;
    private List<ImageView> imgList;
    // 获取到图片
    private Integer[] img = { R.drawable.pic1, R.drawable.pic2,
            R.drawable.pic3, R.drawable.pic4 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        imgList = new ArrayList<ImageView>();
        // 将图片放到集合中
        for (int i = 0; i < img.length; i++) {
            ImageView iv = new ImageView(this);
            //显示哪张图片
            iv.setImageResource(img[i]);
            // 将图片等比居中显示
            iv.setScaleType(ScaleType.FIT_CENTER);
            imgList.add(iv);
        }

        // 进行适配
        myAdapter = new MyAdapter();
        vp.setAdapter(myAdapter);
    }

    /**
     * 自定义适配器
     *
     * @author Administrator
     *
     */
    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return imgList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            // TODO Auto-generated method stub
            return view == obj;
        }

        /**
         * 实例化视图内容（创建要显示的内容）
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(imgList.get(position));
            return imgList.get(position);
        }

        /**
         * 销毁视图内容
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView((View) object);
        }
    }
}