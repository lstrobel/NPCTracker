package edu.uw.npctracker.core

import androidx.room.*

/*
 * @author owendm
 */
@Dao
interface CharacterDao {

    /**
     * Inserts a character into the database, replacing on duplicate
     * @param character The character you want to insert into the database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacter(vararg character: DefaultCharacter)

    /**
     * Deletes a character from the database
     * @param character The character you wish to delete from the database
     */
    @Delete
    fun deleteCharacter(vararg character: DefaultCharacter)

    /**
     * @return A set of all the characters in the characters table
     */
    @Query("SELECT * FROM characters")
    fun getAllCharacters(): Set<DefaultCharacter>

    /**
     * @param firstName the firstname of the character you wish to retrive from the database
     * @return the character in table: characters with name firstName
     */
    @Query("SELECT * FROM characters WHERE firstName LIKE :firstName")
    fun getCharacter(firstName: String): DefaultCharacter

}