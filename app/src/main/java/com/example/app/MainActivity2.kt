package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityMain2Binding
import com.google.firebase.auth.FirebaseAuth

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.textView2.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {

            val email = binding.textInputEditText4.text.toString()
            val password = binding.textInputEditText5.text.toString()
            val confirmPassword = binding.textInputEditText6.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){

                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
if (it.isSuccessful){
val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
}else {
    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

}
                    }


                }else {

                    Toast.makeText(this, "Password Not Matched", Toast.LENGTH_SHORT).show()
                }


            }else{
                Toast.makeText(this, "Empty fields are not allowed!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}