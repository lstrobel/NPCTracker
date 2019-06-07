package edu.uw.npctracker.core

/*
 * @author owendm
 * A model manages generated characters
 */
interface Model {

    /**
     * @return The number of characters currently in the model
     */
    fun size(): Int

    /**
     * @param character the character to add to the model, if is already in model does nothing
     */
    fun addCharacter(character: Character)

    /**
     * @param character the character to remove to the model, returns true if successful, otherwise returns false
     */
    fun removeCharacter(character: Character) : Boolean

    /**
     * @return The list of characters currently in the model
     */
    fun characters(): List<Character>

}
