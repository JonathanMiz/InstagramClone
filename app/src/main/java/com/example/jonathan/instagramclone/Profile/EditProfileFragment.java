package com.example.jonathan.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jonathan.instagramclone.R;
import com.example.jonathan.instagramclone.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";

    private ImageView mProfileImage;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        mProfileImage = view.findViewById(R.id.profileImage);
        setProfileImage();

        DetailRecyclerViewAdapter adapter = new DetailRecyclerViewAdapter();

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        adapter.addDetail(new Detail("Username", R.drawable.ic_username));
        adapter.addDetail(new Detail("Display name", R.drawable.ic_display_name));
        adapter.addDetail(new Detail("Website", R.drawable.ic_website));
        adapter.addDetail(new Detail("Description", R.drawable.ic_description));

        ImageView backArrow = view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        return view;
    }

    private void setProfileImage()
    {
        String imgUrl = "https://crackberry.com/sites/crackberry.com/files/topic_images/2013/ANDROID.png";
        UniversalImageLoader.setImage(imgUrl, mProfileImage, null, "");
    }

    @Nullable
    @Override
    public View getView() {
        return super.getView();
    }

    class Detail
    {
        private String text;
        private int imageSource;

        public Detail(String text, int imageSource) {
            this.text = text;
            this.imageSource = imageSource;
        }
    }

    class DetailRecyclerViewAdapter extends RecyclerView.Adapter<DetailRecyclerViewAdapter.ViewHolder>
    {
        private List<Detail> mDetails = new ArrayList<>();


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_detail, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            viewHolder.detailText.setText(mDetails.get(i).text);
            viewHolder.imageView.setImageResource(mDetails.get(i).imageSource);
        }


        @Override
        public int getItemCount() {
            return mDetails.size();
        }

        public void addDetail(Detail d)
        {
            mDetails.add(d);
        }

        class ViewHolder extends RecyclerView.ViewHolder
        {
            EditText detailText;
            ImageView imageView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                detailText = itemView.findViewById(R.id.editText);
                imageView = itemView.findViewById(R.id.image);
            }
        }


    }

}
