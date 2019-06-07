package edu.uw.npctracker.core
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLModel(ctxt: Context, name: String, factory: SQLiteDatabase.CursorFactory, version: Int)
    : SQLiteOpenHelper(ctxt, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {

        val query = ("CREATE TABLE " +
                TABLE_CHARACTERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_FIRSTNAME + " TEXT," +
                COLUMN_LASTNAME + " TEXT" + ")"
                )
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARACTERS)
        onCreate(db)
    }

    fun size() : Int {

        var size: Int = 0
        val db = this.writableDatabase

        val query = ("SELECT Count(*) FROM $TABLE_CHARACTERS")
        val cursor = db.rawQuery(query, null)
        size = cursor.count

        return size
    }

    fun removeCharacter(character: DefaultCharacter) : Boolean {

        var result = false

        val query = "SELECT * FROM $TABLE_CHARACTERS WHERE $COLUMN_FIRSTNAME = \"${character.getFirstName()}\""
        val db = this.writableDatabase

        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            val id = Integer.parseInt(cursor.getString(0))
            db.delete(TABLE_CHARACTERS, COLUMN_ID + " = ?", arrayOf(id.toString()))
            cursor.close()
            result = true
        }
        db.close()
        return result
    }

    fun addCharacter(character: DefaultCharacter) {

        val cvals = ContentValues()
        cvals.put(COLUMN_FIRSTNAME, character.getFirstName())
        cvals.put(COLUMN_LASTNAME, character.getLastName())

        val db = this.writableDatabase
        db.insert(TABLE_CHARACTERS, null, cvals)
        db.close()
    }

    companion object {

        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "NPCTrackerDB"

        val TABLE_CHARACTERS = "CHARACTERS"

        val COLUMN_ID = "_id"
        val COLUMN_FIRSTNAME = "first"
        val COLUMN_LASTNAME = "last"
    }

}