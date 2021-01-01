package login.presenter

import android.text.Editable

interface ILoginPresenter {
    fun clear();
    fun doLogin(name: String, password: String);
    fun setProgressBarVisibility(visibility: Int);
}