package com.qzy.vendor.ui.Menu;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.qzy.vendor.R;
import com.qzy.vendor.apicall.ApiCallBackInterface;
import com.qzy.vendor.apicall.ApiInstanceClass;
import com.qzy.vendor.ui.Models.MenuItemModel;
import com.qzy.vendor.ui.Models.MenuModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MenuFragment extends Fragment implements ApiCallBackInterface {

    private MenuViewModel menuViewModel;
    ArrayList<MenuModel> menuModels = new ArrayList<>();
    RecyclerView recyclerView;
    private static final String TAG = "MenuFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuViewModel =
                ViewModelProviders.of(this).get(MenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        recyclerView = root.findViewById(R.id.menu_recycler);
        setMenu();
        setMenuData();


        return root;
    }

    public void setMenu() {
//        getMenuData();
        getMenuDataFromAPI();
    }

    private  void getMenuDataFromAPI(){
        LinkedHashMap<String, String> apiCallMap = new LinkedHashMap<>();
//        String restId = this.getIntent().getStringExtra(RestaurantHomeActivity.RESTAURANTID);
        //TODO: change below SCCP001 to restId
        apiCallMap.put("restaurant","SCCP001");
        ApiInstanceClass.getInstance().submitGetRequest(ApiInstanceClass.getBaseInterface(),apiCallMap,this,"items_list");
    }

    private void getMenuData() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.getActivity().getAssets().open("dummy_items_list")));
            String line = reader.readLine();
            StringBuilder sb = new StringBuilder();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
            String fileAsString = sb.toString();
            Gson gson = new Gson();
            JSONArray jsonArray;
            JSONObject jsonObject = new JSONObject(fileAsString);
            jsonArray= jsonObject.getJSONArray("menu");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject menuJson = jsonArray.getJSONObject(i);
                MenuModel menuModel = new MenuModel(new ArrayList<MenuItemModel>());
                ArrayList<MenuItemModel> menuItemModels = new ArrayList<>();
                menuModel.setName(menuJson.getString("name"));
                JSONArray items = menuJson.getJSONArray("items");
                for(int j=0;j<items.length();j++){
                    MenuItemModel model = gson.fromJson(items.getJSONObject(j).toString(), MenuItemModel.class);
                    menuItemModels.add(model);
                }
                menuModel.setMenuItemList(menuItemModels);
                menuModels.add(menuModel);
            }

        } catch (IOException | JSONException e) {
            System.out.println("sree detail exception "+e.getMessage());
            e.printStackTrace();
        }
    }

    private void setMenuData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(),RecyclerView.VERTICAL,false);
        Log.d(TAG, "setMenuData: menuModels size:"+menuModels.size());
        MenuPrimaryAdapter menuPrimaryAdapter = new MenuPrimaryAdapter(this.getActivity(),menuModels);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(menuPrimaryAdapter);
    }

    @Override
    public void onResponseSuccess(JSONObject json, String requestTag) throws JSONException {
        System.out.println("sree json "+ json.toString()+" tag "+ requestTag);
        Gson gson = new Gson();
        JSONArray categoryJsonArray,itemsJsonArray;
        categoryJsonArray= json.getJSONArray("categories");
        Log.d(TAG, "onResponseSuccess: categories:"+categoryJsonArray.length());
        itemsJsonArray = json.getJSONArray("items");
        Log.d(TAG, "onResponseSuccess: items:"+itemsJsonArray.length());
        HashMap<String,MenuModel> menuModelsMap = new HashMap<>();
        for (int i=0;i<categoryJsonArray.length();i++){
            JSONObject categoryJson = categoryJsonArray.getJSONObject(i);
            MenuModel menuModel = new MenuModel(new ArrayList<MenuItemModel>());
            String category = categoryJson.getString("category");
            menuModel.setName(category);
            menuModelsMap.put(category,menuModel);
        }
        for (int i=0;i<itemsJsonArray.length();i++){
            JSONObject itemJson = itemsJsonArray.getJSONObject(i);
            Log.d(TAG, "onResponseSuccess: itemJson:"+itemJson.toString());
            MenuModel m = menuModelsMap.get(itemJson.getString("category"));
            m.addMenuItemToList(gson.fromJson(itemJson.toString(),MenuItemModel.class));
        }
        for (int i=0;i<categoryJsonArray.length();i++){
            menuModels.add(menuModelsMap.get(categoryJsonArray.getJSONObject(i).getString("category")));
        }
        setMenuData();
    }

    @Override
    public void onResponseFailure(String requestTag) {

    }
}