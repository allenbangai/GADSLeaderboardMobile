package com.example.gadsleaderboardmobile.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboardmobile.Adapter.LearningLeadersAdapter;
import com.example.gadsleaderboardmobile.Adapter.SkillIQLeadersAdapter;
import com.example.gadsleaderboardmobile.Model.LearningLeadersModel;
import com.example.gadsleaderboardmobile.Model.SkillIQLeadersModel;
import com.example.gadsleaderboardmobile.R;
import com.example.gadsleaderboardmobile.Util.Helper;
import com.example.gadsleaderboardmobile.Util.JsonPlaceHolderApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillIQLeaders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillIQLeaders extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SkillIQLeaders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillIQLeaders.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillIQLeaders newInstance(String param1, String param2) {
        SkillIQLeaders fragment = new SkillIQLeaders();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

    private RecyclerView recyclerView;
    private Helper helper = new Helper(getContext());
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private SkillIQLeadersAdapter skillIQLeadersAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false);

        recyclerView = root.findViewById(R.id.skill_iq_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        return root;
    }

    private void SkillIQLeaders(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<SkillIQLeadersModel>> callList = jsonPlaceHolderApi.getIQLeaders();
        callList.enqueue(new Callback<List<SkillIQLeadersModel>>() {
            @Override
            public void onResponse(Call<List<SkillIQLeadersModel>> call, Response<List<SkillIQLeadersModel>> response) {
                if(!response.isSuccessful()){
                    helper.toastMessage("Error Code: " + response.code() + "\n Error Message: " + response.message());
                    return;
                }

                List<SkillIQLeadersModel> skillIQLeadersModels = response.body();
                skillIQLeadersAdapter = new SkillIQLeadersAdapter(getContext(), skillIQLeadersModels);
                recyclerView.setAdapter(skillIQLeadersAdapter);
            }

            @Override
            public void onFailure(Call<List<SkillIQLeadersModel>> call, Throwable t) {
                helper.toastMessage("Error message: " + t.getMessage());
            }
        });
    }
}