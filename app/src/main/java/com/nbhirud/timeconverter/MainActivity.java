package com.nbhirud.timeconverter;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.nbhirud.timeconverter.R;


public class MainActivity extends AppCompatActivity {

    int Hours;
    int Minutes;
    TextView tvResult;
    TextView prevDay;
    EditText etHours;
    EditText etMinutes;
    RadioButton rb;
    RadioGroup rg;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        displayButton();

    }

    public void displayButton() {
        setContentView(R.layout.activity_main);

        Switch sw = (Switch) findViewById(R.id.switchButtonRadio);

        if (sw != null) {
            sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(!isChecked) {

                        displayRadioButton();

                    } else {

                        displayButton();

                    }
                }
            });
        }

        final Button buttonEST = (Button) findViewById(R.id.buttonEST);
        final Button buttonCST = (Button) findViewById(R.id.buttonCST);
        final Button buttonMST = (Button) findViewById(R.id.buttonMST);
        final Button buttonPST = (Button) findViewById(R.id.button_PST);
        final Button buttonClear = (Button) findViewById(R.id.button_ClearAll);

        etHours = (EditText) findViewById(R.id.editTextHours);
        etMinutes = (EditText) findViewById(R.id.editTextMinutes);

        if(etHours.toString() == null) {
            Toast.makeText(MainActivity.this, "Hours field is null", Toast.LENGTH_LONG).show();
        }

        if(etMinutes.toString() == null) {
            Toast.makeText(MainActivity.this, "Minutes field is null", Toast.LENGTH_LONG).show();
        }

        if (buttonEST != null) {
            buttonEST.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        tvResult = (TextView) findViewById(R.id.textViewResult);
                        prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 5;
                            if (Hours < 5) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }

                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            Log.d("demo", "wrong");
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }

            });
        }

        if (buttonPST != null) {
            buttonPST.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        tvResult = (TextView) findViewById(R.id.textViewResult);
                        prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");
                        //int RMinutes;


                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 8;
                            if (Hours < 8) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("PST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("PST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }
            });
        }

        if (buttonMST != null) {
            buttonMST.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());

                        TextView tvResult = (TextView) findViewById(R.id.textViewResult);
                        TextView prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");

                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 7;
                            if (Hours < 7) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("MST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("MST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }
            });
        }

        if (buttonCST != null) {
            buttonCST.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        TextView tvResult = (TextView) findViewById(R.id.textViewResult);
                        TextView prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");

                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 6;
                            if (Hours < 6) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("CST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("CST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }
            });
        }

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etHours.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Hours field is null", Toast.LENGTH_LONG).show();
                }

                if(etMinutes.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Minutes field is null", Toast.LENGTH_LONG).show();
                }

                ((EditText) findViewById(R.id.editTextHours)).setText("");
                ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                ((TextView) findViewById(R.id.textView_PrevDay)).setText("");
                ((TextView) findViewById(R.id.textViewResult)).setText("");
            }
        });


    }

    public void displayRadioButton() {
        setContentView(R.layout.radio_button);

        Log.d("demo","In Radio button activity");


        Switch sw = (Switch) findViewById(R.id.switchButtonRadio);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {

                    displayRadioButton();

                } else {

                    displayButton();

                }
            }
        });

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        etHours = (EditText) findViewById(R.id.editTextHours);
        etMinutes = (EditText) findViewById(R.id.editTextMinutes);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton) findViewById(checkedId);
            }
        });

        convert = (Button) findViewById(R.id.buttonConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rg.getCheckedRadioButtonId() == R.id.radioButtonEST) {
                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());

                        tvResult = (TextView) findViewById(R.id.textViewResult);
                        prevDay = (TextView) findViewById(R.id.textView_PrevDay);

                        int RHours;
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 5;
                            if (Hours < 5) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            Log.d("demo", "wrong");
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }

                else if(rg.getCheckedRadioButtonId() == R.id.radioButtonCST) {

                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());

                        TextView tvResult = (TextView) findViewById(R.id.textViewResult);
                        TextView prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;

                        ((TextView) findViewById(R.id.textViewResult)).setText("");
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 6;
                            if (Hours < 6) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("CST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("CST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }

                else if(rg.getCheckedRadioButtonId() == R.id.radioButtonMST) {

                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());

                        TextView tvResult = (TextView) findViewById(R.id.textViewResult);
                        TextView prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");


                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 7;
                            if (Hours < 7) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("MST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("MST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }

                else if(rg.getCheckedRadioButtonId() == R.id.radioButtonPST) {

                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    } else {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());

                        tvResult = (TextView) findViewById(R.id.textViewResult);
                        prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");


                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 8;
                            if (Hours < 8) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                if (Minutes >= 10) {
                                    tvResult.setText("PST:     0" + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("PST:     0" + RHours + ":0" + etMinutes.getText().toString());
                                }
                            } else {
                                if (Minutes >= 10) {
                                    tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                                } else {
                                    tvResult.setText("EST:     " + RHours + ":0" + etMinutes.getText().toString());
                                }
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                }

                else if(rg.getCheckedRadioButtonId() == R.id.radioButtonClear) {

                    if(etHours.getText().toString().isEmpty() || etMinutes.getText().toString().isEmpty()) {
                        Toast.makeText(MainActivity.this, "Hours or Minute field is null", Toast.LENGTH_LONG).show();
                    }
                    ((EditText) findViewById(R.id.editTextHours)).setText("");
                    ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                    ((TextView) findViewById(R.id.textView_PrevDay)).setText("");
                    ((TextView) findViewById(R.id.textViewResult)).setText("");
                }

            }
        });

    }

}

/*
if (buttonEST != null) {
                buttonEST.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        tvResult = (TextView) findViewById(R.id.textViewResult);
                        prevDay = (TextView) findViewById(R.id.textView_PrevDay);

                        int RHours;
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 5;
                            if (Hours < 5) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                tvResult.setText("EST:     0" + RHours + ":" + etMinutes.getText().toString());
                            } else {
                                tvResult.setText("EST:     " + RHours + ":" + etMinutes.getText().toString());
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            Log.d("demo","wrong");
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                });
            }
            if(buttonPST != null) {
                buttonPST.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        tvResult = (TextView) findViewById(R.id.textViewResult);
                        prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 8;
                            if (Hours < 8) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                tvResult.setText("PST:     0" + RHours + ":" + etMinutes.getText().toString());
                            } else {
                                tvResult.setText("PST:     " + RHours + ":" + etMinutes.getText().toString());
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                });
            }
            if(buttonMST != null) {
                buttonMST.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        TextView tvResult = (TextView) findViewById(R.id.textViewResult);
                        TextView prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 7;
                            if (Hours < 7) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                tvResult.setText("MST:     0" + RHours + ":" + etMinutes.getText().toString());
                            } else {
                                tvResult.setText("MST:     " + RHours + ":" + etMinutes.getText().toString());
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                });
            }
            if(buttonCST != null) {
                buttonCST.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Hours = Integer.parseInt(etHours.getText().toString());
                        Minutes = Integer.parseInt(etMinutes.getText().toString());
                        TextView tvResult = (TextView) findViewById(R.id.textViewResult);
                        TextView prevDay = (TextView) findViewById(R.id.textView_PrevDay);
                        int RHours;
                        ((TextView) findViewById(R.id.textViewResult)).setText("");
                        //int RMinutes;
                        if (Hours < 24 && Hours >= 0 && Minutes < 60 && Minutes >= 0) {
                            prevDay.setText("");
                            RHours = Hours - 6;
                            if (Hours < 6) {
                                RHours = 24 + RHours;
                                prevDay.setText("Previous Day");
                            }
                            if (RHours < 10) {
                                tvResult.setText("CST:     0" + RHours + ":" + etMinutes.getText().toString());
                            } else {
                                tvResult.setText("CST:     " + RHours + ":" + etMinutes.getText().toString());
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Time format is wrong", Toast.LENGTH_SHORT).show();
                            ((EditText) findViewById(R.id.editTextHours)).setText("");
                            ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                            prevDay.setText("");
                        }
                    }
                });
            }
            if(buttonClear != null) {
                buttonClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((EditText) findViewById(R.id.editTextHours)).setText("");
                        ((EditText) findViewById(R.id.editTextMinutes)).setText("");
                        ((TextView) findViewById(R.id.textView_PrevDay)).setText("");
                        ((TextView) findViewById(R.id.textViewResult)).setText("");
                    }
                });
            }
        }
        else {
            setContentView(R.layout.radio_button);
            Log.d("demo","else part");
        }
 */