package com.example.gadsleaderboardmobile.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gadsleaderboardmobile.Adapter.LearningLeadersAdapter;
import com.example.gadsleaderboardmobile.Model.LearningLeadersModel;
import com.example.gadsleaderboardmobile.R;
import com.example.gadsleaderboardmobile.Util.Helper;
import com.example.gadsleaderboardmobile.Util.JsonPlaceHolderApi;
import com.example.gadsleaderboardmobile.Util.LeadersRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningLeaders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningLeaders extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearningLeaders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningLeaders.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningLeaders newInstance(String param1, String param2) {
        LearningLeaders fragment = new LearningLeaders();
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
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private Helper helper = new Helper();
    private LearningLeadersAdapter learningLeadersAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        recyclerView = root.findViewById(R.id.learning_leaders_recycler);

        return root;
    }

    private void displayLearningLeaders(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://gadsapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<LearningLeadersModel>> call = jsonPlaceHolderApi.getLearningLeaders();
        call.enqueue(new Callback<List<LearningLeadersModel>>() {
            @Override
            public void onResponse(Call<List<LearningLeadersModel>> call, Response<List<LearningLeadersModel>> response) {
                if(!response.isSuccessful()){
                    helper.toastMessage("Error Code: " + response.code() + "\n Error Message: " + response.message());
                    return;
                }

                List<LearningLeadersModel> learningLeadersModels = response.body();
                learningLeadersAdapter = new LearningLeadersAdapter(getContext(), learningLeadersModels);
                recyclerView.setAdapter(learningLeadersAdapter);
            }

            @Override
            public void onFailure(Call<List<LearningLeadersModel>> call, Throwable t) {
                helper.toastMessage("Error message: " + t.getMessage());
            }
        });
    }
}