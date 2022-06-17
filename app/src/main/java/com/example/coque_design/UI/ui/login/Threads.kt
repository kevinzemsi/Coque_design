package com.example.coque_design.UI.ui.login

import android.content.Context
import com.example.coque_design.db.Utilisateur
import com.example.coque_design.db.UtilisateurDatabase

class Threads {
    class ThreadAddMember(){

    }
    class ThreadCheckConnexion(var email : String, var password: String, var context: Context): Thread(){
         public override fun run() {
            var db: UtilisateurDatabase = UtilisateurDatabase.getInstance(this.context)
            LoginActivity.loginSuccessful = db.utilisateurDao().login(email, password)
        }
    }

    class ThreadaddDB(var username:String, var prenom:String, var email:String, var password: String, var context: Context): Thread(){
        public override fun run(){
            var db: UtilisateurDatabase = UtilisateurDatabase.getInstance(this.context)

            var id:Long = db.utilisateurDao().insertUtilisateur(
                Utilisateur(name=this.username, prenon = this.prenom, email = this.email, password = this.password)
            )
        }
    }
}