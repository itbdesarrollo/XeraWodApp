package llp.itbdesarrollo.xerawodapp.model

import android.provider.ContactsContract
import android.provider.ContactsContract.*
import java.net.PasswordAuthentication

data class UserModel(val idUser: String, val name:String, val email: String, val password: PasswordAuthentication, val telefono: Number)
