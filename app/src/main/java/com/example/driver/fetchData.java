package com.example.driver;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class fetchData{
    public static void postLoginUser() {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().userLogin("irkibby@gmail.com", "attribe");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                String data=response.toString();
                SignIn.textView.setText(data);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }

    public static void getOffersList(final String token) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().listOffers(token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                    JSONObject object = new JSONObject(data);
                    JSONArray array = object.getJSONArray("data");
                    offerDecision(token, array.getJSONObject(0).getInt("id"), "accept");
                } catch (IOException e) {
                    String st;
                    Writer writer = new StringWriter();
                    e.printStackTrace(new PrintWriter(writer));
                    st = writer.toString();
                    SignIn.textView.setText(st);

                } catch (JSONException e) {
                    String st;
                    Writer writer = new StringWriter();
                    e.printStackTrace(new PrintWriter(writer));
                    st = writer.toString();
                    SignIn.textView.setText(st);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }

    public static void refreshToken(final String token) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().refreshToken("Bearer " + token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                } catch (IOException e) {
                    String st;
                    Writer writer = new StringWriter();
                    e.printStackTrace(new PrintWriter(writer));
                    st = writer.toString();
                    SignIn.textView.setText(st);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }

    public static void receiveOffer(String token, int offer_status) {
        Map<String, Integer> map = new HashMap<>();
        map.put("offer_recieve_status", offer_status);
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().putReceiveOffer("Bearer " + token, map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                    SignIn.textView.setText(data);
                } catch (IOException e) {
                    String st;
                    Writer writer = new StringWriter();
                    e.printStackTrace(new PrintWriter(writer));
                    st = writer.toString();
                    SignIn.textView.setText(st);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String st;
                Writer writer = new StringWriter();
                t.printStackTrace(new PrintWriter(writer));
                st = writer.toString();
                SignIn.textView.setText(st);
            }
        });
    }

    public static void offerDecision(String token, int offer_Id, String decision) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().offerDecision("Bearer " + token, offer_Id, decision);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                    SignIn.textView.setText(data);
                } catch (IOException e) {
                    String st;
                    Writer writer = new StringWriter();
                    e.printStackTrace(new PrintWriter(writer));
                    st = writer.toString();
                    SignIn.textView.setText(st);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }


    //Rest goes here
    public static void postCreateLesson(String token) {
//        Lesson lesson = new Lesson("35", "5/03/2019 21:00:01", "5/03/2019 23:00:01", "China", 2);
        HashMap<String, Object> map=new HashMap<>();
        map.put("booking_id","35");
        map.put("start_date_time","5/03/2019 21:00:01");
        map.put("end_date_time","5/03/2019 23:00:01");
        map.put("pickup_location","China");
        map.put("minutes",2);
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().createLesson(token, map);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String data = null;
                try {
                    data = response.body().string();
                    SignIn.textView.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SignIn.textView.setText(data);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }
    //Rest goes there

    public static void getLearnersList(String token) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().learnersList("Bearer " + token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                    SignIn.textView.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }

    public static void getLearnerDetails(String token, int learner_id) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().learnerDetails(token, learner_id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String data = null;
                try {
                    data = response.body().string();
                    SignIn.textView.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                SignIn.textView.setText(data);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public static void getPaymentList(String token) {
        Call<ResponseBody> call = RetrofitClient.getmInstance().getApi().paymentList("Bearer " + token);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String data = response.body().string();
                    SignIn.textView.setText(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                SignIn.textView.setText(t.getMessage());
            }
        });
    }
}
