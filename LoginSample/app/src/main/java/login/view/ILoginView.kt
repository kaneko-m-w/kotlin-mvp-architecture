package login.view

interface ILoginView {
    public fun  onClearText();
    public fun onLoginResult(result: Boolean, code: Int);
    public fun onSetProgressBarVisibility(visibility: Int);
}