package com.gl4.pizzatrino

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import com.gl4.pizzatrino.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var txtNom: TextInputEditText
    lateinit var txtPrenom: TextInputEditText
    lateinit var txtAdresse: TextInputEditText
    lateinit var pizzaType: AutoCompleteTextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        txtNom = findViewById(R.id.nomlayout);
        txtPrenom = findViewById(R.id.prenomlayout);
        txtAdresse = findViewById(R.id.adresselayout);
        pizzaType = findViewById(R.id.autoCompleteTextView);
        val pizzaTypes = resources.getStringArray(R.array.pizzaTypes)
        val adapter = ArrayAdapter(
            this,
            R.layout.dropdown_item,
            pizzaTypes
        )




        with(binding.autoCompleteTextView) {
            setAdapter(adapter)
        }


    }

    fun login(view: View) {
        if (view?.id == R.id.textButton) {
            var nom = txtNom.text.toString();
            var prenom = txtPrenom.text.toString();
            var adresse = txtAdresse.text.toString();
            var pizza = pizzaType.text.toString();
            val text = "Thank you for ordering";
            val order = "Thank you for ordering Mr/Mrs $nom $prenom  , your $pizza pizza is on its way to $adresse";
            val duration = Toast.LENGTH_SHORT;
            val toast = Toast.makeText(applicationContext, text, duration);
            toast.show();
            val intent = Intent(view.context, Splashpage::class.java);
            intent.putExtra("order", order);
            startActivity(intent);

            val intentMail = Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, "motez.momyaaa@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, order);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intentMail);
            }

        }
    }

}
