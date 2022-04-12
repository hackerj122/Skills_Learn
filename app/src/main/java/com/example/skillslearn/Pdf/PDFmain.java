package com.example.skillslearn.Pdf;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.bumptech.glide.Glide;
import com.example.skillslearn.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class PDFmain extends AppCompatActivity {

    public class PDFDoc {
        int id;
        String name,category,pdfURL,pdfIconURL;
        public int getId() {return id;}
        public void setId(int id) {this.id = id;}
        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public String getAuthor() {return category;}
        public void setCategory(String category) {this.category = category;}
        public String getPdfURL() {return pdfURL;}
        public void setPdfURL(String pdfURL) {this.pdfURL = pdfURL;}
        public String getPdfIconURL() {return pdfIconURL;}
        public void setPdfIconURL(String pdfIconURL) {this.pdfIconURL = pdfIconURL;}
    }
    /*
    Our custom adapter class
     */
    public class GridViewAdapter extends BaseAdapter {
        Context c;
        ArrayList<PDFDoc> pdfDocuments;

        public GridViewAdapter(Context c, ArrayList<PDFDoc> pdfDocuments) {
            this.c = c;
            this.pdfDocuments = pdfDocuments;
        }
        @Override
        public int getCount() {return pdfDocuments.size();}
        @Override
        public Object getItem(int pos) {return pdfDocuments.get(pos);}
        @Override
        public long getItemId(int pos) {return pos;}
        @Override
        public View getView(int pos, View view, ViewGroup viewGroup) {
            if(view==null)
            {
                view= LayoutInflater.from(c).inflate(R.layout.row_model,viewGroup,false);
            }

            TextView txtName = view.findViewById(R.id.pdfNameTxt);
            TextView txtAuthor = view.findViewById(R.id.authorTxt);
            ImageView pdfIcon = view.findViewById(R.id.imageView);

            final PDFDoc pdf= (PDFDoc) this.getItem(pos);

            txtName.setText(pdf.getName());
            txtAuthor.setText(pdf.getAuthor());

            if(pdf.getPdfURL() != null && pdf.getPdfURL().length()>0)
            {
                Glide.with(view.getContext()).load("https://android-database-api.000webhostapp.com/image/"+pdf.getPdfIconURL()).into(pdfIcon);
                //Picasso.get().load(pdf.getPdfIconURL()).placeholder(R.drawable.placeholder).into(pdfIcon);
            }else {
                Toast.makeText(c, "Empty Image URL", Toast.LENGTH_LONG).show();
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(c, pdf.getName(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(view.getContext(),PDFActivity.class);
                    intent.putExtra("PATH",pdf.getPdfURL());
                    startActivity(intent);
                }
            });

            return view;
        }
    }
    /*
    Our HTTP Client
     */
    public class JSONDownloader {
        private static final String PDF_SITE_URL="https://android-database-api.000webhostapp.com/pdf-api.php";
        private final Context c;
        private GridViewAdapter adapter ;

        public JSONDownloader(Context c) {
            this.c = c;
        }
        /*
        DOWNLOAD PDFS FROM MYSQL
         */
        public void retrieve(final GridView gv, final ProgressBar myProgressBar)
        {
            final ArrayList<PDFDoc> pdfDocuments = new ArrayList<>();

            myProgressBar.setIndeterminate(true);
            myProgressBar.setVisibility(View.VISIBLE);

            AndroidNetworking.get(PDF_SITE_URL)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONArray(new JSONArrayRequestListener() {
                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jo;
                            PDFDoc p;
                            try
                            {
                                for(int i=0;i<response.length();i++)
                                {
                                    jo=response.getJSONObject(i);

                                    int id=jo.getInt("id");
                                    String name=jo.getString("pdfname");
                                    String pdfURL=jo.getString("pdflink");
                                    String category=jo.getString("category");
                                    String pdfimage = jo.getString("pdfimage");

                                    p=new PDFDoc();
                                    p.setId(id);
                                    p.setName(name);
                                    p.setCategory(category);
                                    p.setPdfURL(/*PDF_SITE_URL+*/pdfURL);
                                    p.setPdfIconURL(pdfimage);

                                    pdfDocuments.add(p);
                                }
                                adapter =new GridViewAdapter(c,pdfDocuments);
                                gv.setAdapter(adapter);
                                myProgressBar.setVisibility(View.GONE);

                            }catch (JSONException e)
                            {
                                myProgressBar.setVisibility(View.GONE);
                                Toast.makeText(c, "GOOD RESPONSE BUT JAVA CAN'T PARSE JSON IT RECEIEVED. "+e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                        //ERROR
                        @Override
                        public void onError(ANError error) {
                            error.printStackTrace();
                            myProgressBar.setVisibility(View.GONE);
                            Toast.makeText(c, "UNSUCCESSFUL :  ERROR IS : "+error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfmain);

        final GridView myGridView= findViewById(R.id.myGridView);
        //Button btnRetrieve= findViewById(R.id.downloadBtn);
        final ProgressBar myProgressBar= findViewById(R.id.myProgressBar);
        new JSONDownloader(PDFmain.this).retrieve(myGridView,myProgressBar);
//        btnRetrieve.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                new JSONDownloader(MainActivity.this).retrieve(myGridView,myProgressBar);
//            }
//        });
    }
}
