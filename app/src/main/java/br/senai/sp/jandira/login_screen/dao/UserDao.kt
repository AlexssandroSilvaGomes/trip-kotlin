package br.senai.sp.jandira.login_screen.dao

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.senai.sp.jandira.login_screen.model.User

interface UserDao {

    @Insert
    fun save(user: User): Long

    @Update
    fun update(user: User): Int

    @Delete
    fun delete(user: User): Int

    @Query("SELECT * FROM tbl_user WHERE email = :email")
    fun findUserByEmail(email: Email): User

}