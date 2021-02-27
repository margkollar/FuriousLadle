package com.example.myapplication.furiousladle;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.furiousladle.db.UserDatabase;
import com.example.myapplication.furiousladle.db.UserEntity;
import com.example.myapplication.furiousladle.db.UserProfileAsyncTask;
import com.example.myapplication.furiousladle.db.UserProfileCallback;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends BottomSheetDialogFragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        UserDatabase userDatabase= Room.databaseBuilder(getContext(), UserDatabase.class,"furious_ladle_db")
                .build();
        TextView name = view.findViewById(R.id.name);
        TextView userName = view.findViewById(R.id.username);
        TextView bio = view.findViewById(R.id.bio);

        new UserProfileAsyncTask(new UserProfileCallback() {
            @Override
            public void onSuccessResult(UserEntity entity) {

//                fillProfileCard(entity);


                name.setText(entity.getFirst_name() + " " + entity.getLast_name());
                userName.setText(entity.getUsername());
                bio.setText(entity.getBio());
            }
        }, userDatabase).execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }
    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        //Set the custom view
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_profile, null);
        dialog.setContentView(view);
    }
}