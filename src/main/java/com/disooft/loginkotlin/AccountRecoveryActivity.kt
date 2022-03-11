package com.disooft.loginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.disooft.loginkotlin.databinding.ActivityAccountRecoveryBinding
import com.disooft.loginkotlin.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AccountRecoveryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountRecoveryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountRecoveryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.senEmailAppCompatButton.setOnClickListener {
            val emailAddress = binding.emailEditText.text.toString()
            Firebase.auth.sendPasswordResetEmail(emailAddress).addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    val intent = Intent(this, SignInActivity::class.java)
                    this.startActivity(intent)

                } else {
                    Toast.makeText(baseContext, "Ingrese el email de tu cuenta", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}