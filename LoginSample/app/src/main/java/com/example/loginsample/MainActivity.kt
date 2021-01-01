package com.example.loginsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import login.presenter.ILoginPresenter
import login.presenter.LoginPresenterCompl
import login.view.ILoginView

class MainActivity : AppCompatActivity(), ILoginView, View.OnClickListener {
    lateinit var editUser: EditText
    lateinit var editPass: EditText
    lateinit var btnLogin: Button
    lateinit var btnClear: Button
    lateinit var loginPresenter: ILoginPresenter
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find view
        editUser = findViewById(R.id.et_login_username)
        editPass = findViewById(R.id.et_login_password)
        btnLogin = findViewById(R.id.btn_login_login)
        btnClear = findViewById(R.id.btn_login_clear)
        progressBar = findViewById(R.id.progress_login)

        // set listener
        btnLogin.setOnClickListener(this)
        btnClear.setOnClickListener(this)

        // init
        loginPresenter = LoginPresenterCompl(this)
        loginPresenter.setProgressBarVisibility(View.INVISIBLE)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_login_clear)
        {
            loginPresenter.clear()
        }
        else if(v?.id == R.id.btn_login_login)
        {
            loginPresenter.setProgressBarVisibility(View.INVISIBLE)
            btnLogin.isEnabled = false
            btnClear.isEnabled = false
            loginPresenter.doLogin(editUser.text.toString(), editPass.text.toString())
        }
    }

    override fun onClearText() {
        editUser.setText("")
        editPass.setText("")
    }

    override fun onLoginResult(result: Boolean, code: Int) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE)
        btnLogin.isEnabled = true
        btnClear.isEnabled = true
        if(result) {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Login Fail, code = $code", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSetProgressBarVisibility(visibility: Int) {
        progressBar.visibility = visibility
    }
}