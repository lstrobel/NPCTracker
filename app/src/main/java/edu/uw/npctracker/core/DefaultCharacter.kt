package edu.uw.npctracker.core

import java.time.Instant

/*
 * @author lstrobel
 */
class DefaultCharacter private constructor(
    private val firstName: String,
    private val lastName: String,
    private val notes: String,
    private val tags: Set<Tag>
) : Character {

    private val timestamp = Instant.now()

    constructor() : this("", "", "", HashSet())

    override fun getFirstName(): String {
        return firstName
    }

    override fun setFirstName(name: String): Character {
        return DefaultCharacter(name, lastName, notes, tags)
    }

    override fun getLastName(): String {
        return lastName
    }

    override fun setLastName(name: String): Character {
        return DefaultCharacter(firstName, name, notes, tags)
    }

    override fun getNotes(): String {
        return notes
    }

    override fun setNotes(text: String): Character {
        return DefaultCharacter(firstName, lastName, text, tags)
    }

    override fun getTags(): Set<Tag> {
        return tags
    }

    override fun addTag(tag: Tag): Character {
        return DefaultCharacter(firstName, lastName, notes, tags.plus(tag))
    }

    override fun removeTag(tag: Tag): Character {
        return DefaultCharacter(firstName, lastName, notes, tags.minus(tag))
    }

    override fun hasTag(tag: Tag): Boolean {
        return tags.contains(tag)
    }

    override fun getTimestamp(): Instant {
        return timestamp
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultCharacter

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (notes != other.notes) return false
        if (tags != other.tags) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + notes.hashCode()
        result = 31 * result + tags.hashCode()
        return result
    }
}