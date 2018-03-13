package cpri.other;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dhara.cpriapp.R;

import java.util.List;

import cpri.activity.Admin;

/**
 * Created by manisha on 1/2/2018.
 */

public class AdminAdapter  extends RecyclerView.Adapter<AdminAdapter.MyViewHolder> {

    private List<Admin> adminList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, role;
        ImageView image;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            role = (TextView) view.findViewById(R.id.role);
            image = (ImageView) view.findViewById(R.id.country);
        }
    }


    public AdminAdapter(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.admin_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Admin admin = adminList.get(position);
        holder.name.setText(admin.getName());
        holder.role.setText(admin.getRole());
       // holder.country.setText(admin.getCountry());
     //   holder.image.setImageResource(adminList.get(position).getImageView());
        holder.image.setImageResource(admin.getImage());
    }

    @Override
    public int getItemCount() {
        return adminList.size();
    }
}
