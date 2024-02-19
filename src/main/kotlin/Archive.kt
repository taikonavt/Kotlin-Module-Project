import java.util.Scanner

class Archive(override val name: String, val noteList: MutableList<Note> = mutableListOf()): Item