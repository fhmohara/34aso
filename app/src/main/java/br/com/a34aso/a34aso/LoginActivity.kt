package br.com.a34aso.a34aso

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        criarContaButton.setOnClickListener{
            startActivity(Intent(this,
                    SignUpActivity::class.java))
        }

        conectarButton.setOnClickListener {
            mAuth.signInWithEmailAndPassword(
                    emailField.text.toString(),
                    senhaField.text.toString()
            ).addOnCompleteListener {
                if(it.isSuccessful){
                    vaiParaAProxTela()
                }else{
                    exibeErro()
                }
            }
        }
    }

    private fun exibeErro(){
        Toast.makeText(this,"Erro!", Toast.LENGTH_SHORT)
    }

    private fun vaiParaAProxTela(){
        startActivity(Intent(this, ControlActivity::class.java))
        finish()
    }
}
