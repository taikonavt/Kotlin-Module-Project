import java.util.Scanner

class Archive(override val name: String, val noteList: MutableList<Note> = mutableListOf()): Item {
    fun addNewNote(scanner: Scanner) {
        var noteName: String
        while (true) {
            println("Введите название заметки: ")
            noteName = scanner.nextLine()
            if (noteName.isNotBlank()) {
                break
            } else {
                println("Название заметки не может быть пустым")
            }
        }

        var noteText: String
        while (true) {
            println("Введите текст: ")
            noteText = scanner.nextLine()
            if (noteText.isNotBlank()) {
                break
            } else {
                println("Название заметки не может быть пустым")
            }
        }
        noteList.add(Note(noteName, noteText))
        println("Заметка создана!\nДля архива $name")
    }
}