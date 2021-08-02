package com.harry.instagram.Profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.harry.instagram.R;
import com.harry.instagram.utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfileFragment extends Fragment {
    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;// in the edit fragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container,false);
        mProfilePhoto=(ImageView) view.findViewById(R.id.Profile_photo);
        // Now I need a url for image;
        initIMageLoader();
        setProfileImage();
        return view;
    }

    // Initilize image loeader;
    private void initIMageLoader()
    {
        UniversalImageLoader universalimageloeader= new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalimageloeader.getConfig());// getting the configurationl

    }
    private void setProfileImage()
    {
        Log.d(TAG, "setProfileImage: setting profile image.");
        String imgurl="i.picsum.photos/id/237/200/300.jpg?hmac=TmmQSbShHz9CdQm0NkEjx1Dyh_Y984R9LpNrpvH2D_U";
        UniversalImageLoader.setImage(imgurl,mProfilePhoto,null,"https://");
    }
}
