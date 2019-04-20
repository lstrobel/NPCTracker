package edu.uw.npctracker.core

import java.time.Instant

/*
 * @author lstrobel
 * A Character is an immutable ADT, representing a trackable rpg character, with simple fields, and a list of tags.
 */
interface Character {

    /**
     * @return The first name of this character
     */
    fun getFirstName(): String

    /**
     * @param name The name to set the first name to
     * @return A new Character, identical to this one, with the new first name
     */
    fun setFirstName(name: String): Character

    /**
     * @return The last name of this character
     */
    fun getLastName(): String

    /**
     * @param name The name to set the last name to
     * @return A new Character, identical to this one, with the new last name
     */
    fun setLastName(name: String): Character

    /**
     * @return The notes for this character
     */
    fun getNotes(): String

    /**
     * @param text The text to set this character's text to
     * @return A new Character, identical to this one, with the new text
     */
    fun setNotes(text: String): Character

    /**
     * @return An unmodifiable Set of Tags that this Character has
     */
    fun getTags(): Set<Tag>

    /**
     * @param tag The Tag to add to this Character's tags
     * @return A new Character, identical to this one, with the tag added
     */
    fun addTag(tag: Tag): Character

    /**
     * @param tag The Tag to remove from this Character's tags
     * @return A new Character, identical to this one, with the tag removed
     */
    fun removeTag(tag: Tag): Character

    /**
     * @param tag The tag to check for
     * @return true if this Character has the passed Tag
     */
    fun hasTag(tag: Tag): Boolean

    /**
     * @return The time that this Character was created (last-modified)
     */
    fun getTimestamp(): Instant
}