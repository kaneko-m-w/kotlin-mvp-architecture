package login.presenter

import android.os.Handler
import android.os.Looper
import android.text.Editable
import  login.model.IUser
import  login.model.UserModel
import  login.view.ILoginView

class LoginPresenterCompl(_iLoginView: ILoginView) : ILoginPresenter{
    public var iLoginView: ILoginView
    public lateinit var user: IUser
    public lateinit var handler: Handler

    init {
        iLoginView = _iLoginView
        initUser()
        handler = Handler(Looper.myLooper()!!)
    }

    override fun clear() {
        iLoginView.onClearText()
    }

    override fun doLogin(name: String, password: String) {
        var isLoginSuccess = true
        var code: Int = user.checkUserValidity(name, password)
        if (code != 0) {
            isLoginSuccess = false
        }

        var result: Boolean = isLoginSuccess

        handler.postDelayed({
            iLoginView.onLoginResult(result, code)
        }, 5000)

    }

    override fun setProgressBarVisibility(visibility: Int) {
        iLoginView.onSetProgressBarVisibility(visibility)
    }

    private fun initUser() {
        user = UserModel("mvp", "mvp")
    }
}