package com.blogytec.happybday;

        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.DialogFragment;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.io.File;

        import static android.content.Context.MODE_PRIVATE;


public class menu_frag_2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.menu_frag_2, container, false);


    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles


             getActivity().setTitle("Menu 2");


        final EditText EnterName = getActivity().findViewById(R.id.EnterName);
        Button Submit = getActivity().findViewById(R.id.SubmitButton);



        Button pickDateButton = getActivity().findViewById(R.id.pickDateButton);


        pickDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });


         final SQLiteDatabase HappyBdayDB = getActivity().openOrCreateDatabase("PersonInfo", MODE_PRIVATE, null);




        /* Create a Table in the Database. */
        HappyBdayDB.execSQL("CREATE TABLE IF NOT EXISTS " + "PersonInfoTable" + " (Name VARCHAR,  Date VARCHAR);");



        /* Check if the database exists
        if (database.exists()) {
            Toast.makeText(getActivity(), "Database Created", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Database Missing", Toast.LENGTH_SHORT).show();
        }
        */

            Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String NameTOEnter =  EnterName.getText().toString().trim();

                HappyBdayDB.execSQL("INSERT INTO "
                        + "PersonInfoTable"
                        + " (Name,Date)"
                        + " VALUES (NameToEnter, 'RANDOMdate');");


             }
            });










        /*retrieve data from database */
        Cursor c = HappyBdayDB.rawQuery("SELECT * FROM " + "PersonInfoTable" , null);

        int Column1 = c.getColumnIndex("Name");
        int Column2 = c.getColumnIndex("Date");


        String Data = "";
        // Check if our result was valid.
        c.moveToFirst();
        if (c != null) {
            // Loop through all Results
            do {
                String Name = c.getString(Column1);
                String Date = c.getString(Column2);
                Data =Data + Name+"/"+Date+"\n";
            }while(c.moveToNext());
        }

        TextView NameAndDateTextView = getActivity().findViewById(R.id.NameAndDatesTextView);
        NameAndDateTextView.setText(Data);



    }










}