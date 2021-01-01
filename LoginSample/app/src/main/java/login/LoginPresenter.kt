package login

import android.net.Credentials
import com.example.loginsample.LoginContract

class LoginPresenter: LoginContract.ToPresenter {

    lateinit var model: LoginContract.PresenterToModel
    lateinit var view: LoginContract.PresenterToView

    override fun login(userCredentials: LoginItem) {
        model.login(userCredentials)
    }

    override fun isLoggedIn() {
        model.isLoggedIn()
    }

    override fun isLoggedIn(isLogginSuccess: Boolean) {
        view.onLoginResponse(isLogginSuccess)
    }

    override fun onError(message: String) {
        view.onError(message)
    }

    override fun onLoginResponse(isLoggedIn: Boolean) {
        view.isLoggIn(isLoggedIn)
    }
}