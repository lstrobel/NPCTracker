package edu.uw.npctracker.core


/*
 * @author lstrobel
 */
class DefaultTag(override val label: String): Tag {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DefaultTag

        if (label != other.label) return false

        return true
    }

    override fun hashCode(): Int {
        return label.hashCode()
    }
}