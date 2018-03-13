package cpri.other;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhara.cpriapp.R;

import cpri.fragment.HomeFragment;

/**
 * Created by manisha on 1/9/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.mipmap.ic_cpri,
            R.mipmap.ic_timesheet,
            R.mipmap.ic_cs,
            R.mipmap.ic_module4m,
            R.mipmap.ic_module5,
            R.mipmap.ic_module6

    };

   /* private String[] mThumbtext = {
            "CPRI",
            "TimeSheet",
            "Module3",
            "Module4",
            "Module5",
            "Module6"
    };*/

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
     //   TextView textView = new TextView(mContext);
        imageView.setImageResource(mThumbIds[position]);
     //   textView.setText(mThumbtext[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
        return imageView;
    }

}