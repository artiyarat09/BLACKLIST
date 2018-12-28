package com.example.artt.blacklist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;

    }

    //Arrays
    public int[] slide_images = {
            R.drawable.still2,
            R.drawable.still3,
            R.drawable.still1,
            R.drawable.logo_p1,
            R.drawable.still4,

    };

    public  String[] slide_heading = {

            "โจรเนียนปลอมเป็นเพื่อนขอยืมเงิน",
            "โจรเว็บไซต์ปลอม",
            "โจรโปรแกรมเมอร์",
            "โจรพันหน้า",
            "โจรร้านค้าออนไลน์",
    };

    public String[] slide_desc ={

            "ขโมยรหัสผู้ใช้งานและรหัสผู้ใช้งานและรหัสผ่านแล้วสวมรอยส่งอีเมล์ไปหาเพื่อนบอกว่ากำลังเดือดร้อนให้โอนเงินมา",
            "ส่งอีเมล์และแนบลิงค์ที่มี URL คล้ายกับเว็บไซต์ธนาคารจริง เพื่อให้เหยื่อกรอกข้อมูลแล้วสวมรอยเข้าไปส่งคำขอโอนเงินออกจากบัญชี",
            "หลอกให้ดาวน์โหลดหรือคลิกไฟล์ที่มีโปรแกรมร้าย (Malware) เพื่อขโมยข้อมูลหรือบันทึกข้อมูลการใช้งานของเหยื่อ",
            "แอบอ้างเป็นบุคคลต่าง ๆ เช่น นักธุรกิจหรือขายหนุ่มที่ต้องการหาคู่และหลอกว่าโอนเงินมาให้แต่เหยื่อต้องจ่ายค่าธรรมเนียมไปให้ก่อน",
            "หลอกให้ซื้อขายสินค้าทางอินเตอร์เน็ตโดยใช้วิธีแยบยลจนเหยื่อหลงเชื่อและให้โอนเงินไปให้"
    };

    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageVIew = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescriotion = (TextView) view.findViewById(R.id.slide_desc);

        slideImageVIew.setImageResource(slide_images[position]);
        slideHeading.setText(slide_heading[position]);
        slideDescriotion.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
