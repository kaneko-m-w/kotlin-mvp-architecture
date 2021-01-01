package login.model

import login.model.IUser

class UserModel(private val name: String, private val password: String) : IUser {

    override fun getName(): String {
        return  name
    }

    override fun getPassword(): String {
        return  password
    }

    override fun checkUserValidity(name: String, password: String): Int {
        if(name == null || password == null || name != getName() || password != getPassword())
        {
            return  -1
        }
        return  0
    }
}