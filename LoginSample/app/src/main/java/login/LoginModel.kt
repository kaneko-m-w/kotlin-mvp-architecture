package login

import android.util.Patterns
import com.example.loginsample.BaseContract
import com.example.loginsample.LoginContract
import com.example.loginsample.R

class LoginModel: LoginContract.PresenterToModel {
    lateinit var presenter: LoginContract.ToPresenter

    override fun login(userCredential: LoginItem) {
        if (validateData(userCredential))
        {
            performLoginOperation(userCredential)
        }
        else
        {
            presenter.onError("LOGIN FIELD VALIDATION ERROR")
        }
    }

    override fun isLoggedIn() {
        presenter.isLoggedIn(true)
    }

    override fun validateData(userCredentials: LoginItem): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(userCredentials.name).matches() &&
                userCredentials.password.trim() != ""
    }

    override fun performLoginOperation(userCredential: LoginItem) {
        presenter.onLoginResponse(true);
    }

    override fun onError(message: String) {
        presenter.onError(message)
    }
}