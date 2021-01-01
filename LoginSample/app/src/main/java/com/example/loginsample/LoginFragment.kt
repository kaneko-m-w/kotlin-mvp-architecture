package com.example.loginsample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import login.model.IUser
import login.view.ILoginView
import login.presenter.ILoginPresenter
import login.LoginItem
import login.LoginModel

interface BaseContract {
    interface View {
    }
}

interface LoginContract: BaseContract{
    interface PresenterToView {
        fun onLoginResponse(isLosinSuccess: Boolean)
        fun onError(message: String)
        fun isLoggIn(isLoggIn: Boolean)
    }

    interface PresenterToModel {
        fun login(userCredential: LoginItem)
        fun isLoggedIn()
        fun validateData(userCredential: LoginItem) : Boolean
        fun performLoginOperation(userCredential: LoginItem)
        fun onError(message: String)
    }

    interface ToPresenter {
        fun login(userCredential: LoginItem)
        fun isLoggedIn()
        fun onLoginResponse(isLoginSuccess: Boolean)
        fun onError(message: String)
        fun isLoggedIn(isLoggedIn: Boolean)
    }
}

class LoginFragment: Fragment(), View.OnClickListener {

    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var login: Button
    lateinit var register: Button

    lateinit var presenter: LoginContract.ToPresenter

    override fun onCreateView(inflator: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Fragment
        return inflator.inflate(R.layout.activity_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Fragment
        email = view.findViewById(R.id.et_login_username)
        password = view.findViewById(R.id.et_login_password)
        login = view.findViewById(R.id.btn_login_login)
        login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (view?.id == R.id.btn_login_login) {
            var loginItem: LoginItem = LoginItem()
            loginItem.password = password.text.toString()
            loginItem.name = email.text.toString()
            presenter.login(loginItem)
        }
    }
}